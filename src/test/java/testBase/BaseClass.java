package testBase;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {
	
	
public static  WebDriver driver;
public Logger logger; //for logger variable for log4j2
public Properties p;

	
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	
	@Parameters({"os", "browser"})
	public void setup(String os, String br) throws IOException 
	{
		
		//Loding config.properties file
		
		FileReader file = new FileReader(".\\src\\test\\resources\\config.properties");
		p=new Properties(); //object
		p.load(file);
		
		
		logger=LogManager.getLogger(this.getClass());
		
		/*
		//For remote environment , we need to change the script to lunch browser
		
		
		if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
		{
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			//Operating system: --
			//Which operating system we have to use from the Grid and 
			
			//Here we are taking the enviranment value from properties file but stii we are 
			//taking the operating system value browser name from xml file that will not change.
			
			if(os.equalsIgnoreCase("window"))
			{
				capabilities.setPlatform(Platform.WIN10);
			}
			else if (os.equalsIgnoreCase("mac"))
			{
				capabilities.setPlatform(Platform.MAC);
			}
			else 
			{
				System.out.println("No maching os");
				return;
			}
			
			//browser
			//which browser we have lunch on that particular node.
			switch(br.toLowerCase())
			{
			case "chrome" : capabilities.setBrowserName("chrome");break;
			case "edge" : capabilities.setBrowserName("MicrosoftEdge");break;
			default:System.out.println("No matching browser"); 
			return;
			}
			//to lunch the url
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
			
			
		}
		
		//if execution environment is local
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			//we need to put switch case for multiple browser
			switch(br.toLowerCase())
			{
			case "chrome" : driver = new ChromeDriver();break;
			case "edge" : driver = new EdgeDriver();break;
			case "firefox" : driver = new FirefoxDriver();break;
			default : System.out.println("Invalid browser name..");return;
			}
			
		}*/
		
	
		
		//we need to put switch case for multiple browser
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver = new FirefoxDriver();break;
		default : System.out.println("Invalid browser name..");return;
		}
			
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(" https://tutorialsninja.com/demo/");
		
		driver.get(p.getProperty("appURL")); //Reading url from properties file.
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	
	public void teardown()
	{
		driver.quit();
		
	}
	
	//To Create string
	
	public String randomeString()
	{
		
	//Dependency version should 3.12.0 ( my observation)
		String Generatedstring=RandomStringUtils.randomAlphabetic(6);
		return Generatedstring;
	}
	
	//To Create Number
	public String randomeNumber()
	{
		
	//Dependency version should 3.12.0 ( my observation)
		String Generatednumber=RandomStringUtils.randomNumeric(10);
		return Generatednumber;
	}
	
	//To Create both mix AlphaNumeric for password
	
		public String randomeAlphaNumberic()
		{
			String Generatedstring=RandomStringUtils.randomAlphabetic(3);
			String Generatednumber=RandomStringUtils.randomNumeric(3);
			return (Generatedstring+"@"+Generatednumber);
	
		}
		
		//user method to capture screen shot
		public String captureScreenShot(String tName) throws IOException
		{
			String timestamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
			
			TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
			File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
			
			String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\" + tName + "_" + timestamp + ".png";
			File targetFile = new File (targetFilePath);
			
			sourceFile.renameTo(targetFile);
			return targetFilePath;	
			
		}

}
