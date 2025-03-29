package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
import org.testng.annotations.Test;

import bsh.Capabilities;

import org.apache.logging.log4j.LogManager; //log4j
import org.apache.logging.log4j.Logger;  //log4j
//import org.apache.logging.log4j.core.Logger;

public class BaseClass {
	public static WebDriver driver;
	public Logger logger; //Log4j
	public Properties p;

	@BeforeClass(groups={"Sanity","Master","Regression","DataDriven"})
	@Parameters({"os","browser"})
	public void setUp(String os,String br) throws IOException {
		FileReader file = new FileReader(".//src/test/resources/config.properties"); // find location of property file
		p=new Properties(); //creating object property
		p.load(file); // loading the file which we declared
		logger=LogManager.getLogger(this.getClass()); // this will load log4j2 xml from test/resources

		DesiredCapabilities capabilities = new DesiredCapabilities();
		if (p.getProperty("execution_env").equalsIgnoreCase("remote")) {


			//os
			if (os.equalsIgnoreCase("windows")) {
				capabilities.setPlatform(Platform.WIN10);
			} else if(os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			}else {
				System.out.println("no matching os");
				return;
			}


			//browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("no matching browser name");
				return;
			}
			driver= new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
		}



		if (p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				return;
			}
		}
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("URL"));
		driver.manage().window().maximize();
	}


	@AfterClass(groups={"Sanity","Master","Regression","DataDriven"})
	public void tearDown() {
	driver.close();
	}

	// generating random string to avoid dublicates and jus chking purpose
	public String randomString() {
		String randomAlphabetic = RandomStringUtils.randomAlphabetic(5);
		return randomAlphabetic;
	}

	public String randomNumber() {
		String randomNumeric = RandomStringUtils.randomNumeric(10);
		return randomNumeric;
	}

	public String randomAlphanumberic() {
		String randomalphaNumeric = RandomStringUtils.randomAlphanumeric(8); 
		return randomalphaNumeric;

	}

	//		 public String captureScreen(String tname) {
	//			 
	//			 String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	//			 
	//			 TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
	//			 
	//			 File sourceFile = takesscreenshot.getScreenshotAs(OutputType.FILE);
	//			 
	//			 String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timestamp+".png";
	//			 
	//			 File targetFile = new File(targetFilePath);
	//			 
	//			 sourceFile.renameTo(targetFile);
	//			 
	//			 return targetFilePath;
	//			 
	//			
	//		}

	public  String captureScreen(String tname) throws Exception {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+ tname +"_"+ timestamp+".png";
		File destFile = new File(targetFilePath);
		FileUtils.copyFile(srcFile, destFile);
		return targetFilePath;
	}

}
