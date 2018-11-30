//  reporting failure
//  ant,testng,maven
//  implement more features
//  Git and Jenkins


package com.rediff.connector;
import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.rediff.util.ExtentManager;
// Webdriver layer
public class WebConnector {

	public WebDriver driver;
	public Properties prop;
	public ExtentReports rep ;
	public ExtentTest test;
	
	public WebConnector() {
		// init the prop file
		if(prop==null) {
			prop=new Properties();
			String path=System.getProperty("user.dir")+"//src//test//resources//project.properties";
			try {
				FileInputStream fs = new FileInputStream(path);
				prop.load(fs);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println(prop.getProperty("createPortfolioSubmitButton"));
	}
	
	
	
	public void openBrowser(String browser) {
		if(browser.equals("Mozilla")) {
			driver= new FirefoxDriver();
		}else if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
		}else if(browser.equals("IE")) {
			driver  = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void navigate(String urlKey) {

		log(prop.getProperty(urlKey));
		driver.get(prop.getProperty(urlKey));
	}
	
	public void click(String objectKey) {
		getObject(objectKey).click();
	}
	
	
	public void clear(String objectKey) {
		getObject(objectKey).clear();
	}
	
	public void type(String value, String objectKey) {
		getObject(objectKey).sendKeys(value);
	}
	
	public WebElement getObject(String objectKey) {
		WebElement e=null;
		try {
			if(objectKey.endsWith("_xpath"))
				 e = driver.findElement(By.xpath(prop.getProperty(objectKey)));
			else if(objectKey.endsWith("_id"))
				 e = driver.findElement(By.id(prop.getProperty(objectKey)));
			else if(objectKey.endsWith("_name"))
				 e = driver.findElement(By.name(prop.getProperty(objectKey)));
			
		}catch(Exception ex) {
			// object found- report failure
			reportFailure("Object not found "+objectKey);
		}
		return e;
	}
	
	
	public boolean isElementPresent(String objectKey) {
		List<WebElement> list=driver.findElements(By.xpath(prop.getProperty(objectKey)));
		if(list.size()==0) {
			log("Object not found "+objectKey);
			return false;
		}
		else {
			log("Object found "+objectKey);
			return true;
		}
	}

	public Properties getProperty() {
		return prop;
	}
	/*******************Logging*********************/
	public void initRep() {
		 rep = ExtentManager.getInstance(System.getProperty("user.dir")+"//reports//");
		 test = rep.createTest("Sample Test");	
	}
	
	public void log(String logMsg) {
		test.log(Status.INFO, logMsg);
	}
	
	public void flush() {
		rep.flush();
	}
	
	public void reportFailure(String failureMsg) {
		// fail in extent reports
		test.log(Status.FAIL, failureMsg);
		// take screenshot and embed in reports
		takeSceenShot();
		// fail in cucumber
		assertThat(false);
	}
	
	
	public void takeSceenShot(){
		// fileName of the screenshot
		Date d=new Date();
		String screenshotFile=d.toString().replace(":", "-")+".png";
		// take screenshot
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// get the dynamic folder name+save
			FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
			//put screenshot file in reports
			test.log(Status.FAIL,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	
	
}
