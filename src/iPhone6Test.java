import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.RectangleSize;
import com.applitools.eyes.Region;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class iPhone6Test {
	
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		Eyes eyes = new Eyes();
		eyes.setApiKey("95dlJqlySCR2I46tb9J0HBHdlQjAq5JSN66Y4BcmQig110"); //<-- BA gmail account
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");

		
		//setup iOS driver
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver = eyes.open(driver, "test", "header test");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.get("http://qa.aaa.dev/batest-simple.html");
		driver.get("http://www.signaturehardware.com/");
		
		System.out.println("Before check region");
		
		Thread.sleep(2000);
		
		//eyes.checkRegion(By.id("header"), "AAA mobile header"); // <- for AAA
		eyes.checkRegion(By.id("header-container"), "sig header test"); //<- for SIG
		
		/*WebElement element = driver.findElement(By.id("header-container"));
		int top = element.getLocation().getY();
		int left = element.getLocation().getX();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		Region region = new Region(left,top + 65,width,height);
		System.out.println("HELLO");
		eyes.checkRegion(region);
		eyes.checkWindow();*/
		
		System.out.println("After check region");
		Thread.sleep(2000);
		
		eyes.close();
		driver.quit();
	}

}

/*class AppltioolsCheckRegion {
	
	private static void checkRegion(Eyes eyes, WebElement element, int heightShift) {
//		int top = element.getLocation().getY();
//		int left = element.getLocation().getX();
//		int width = element.getSize().getWidth();
//		int height = element.getSize().getHeight();
//
//		Region region = new Region(left,top + heightShift,width,height);
//
//		eyes.checkRegion(region);
	}
	
	public void checkReg(Eyes eyes, WebElement element, int heightShift) {
		int top = element.getLocation().getY();
		int left = element.getLocation().getX();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		Region region = new Region(left,top + heightShift,width,height);
		System.out.println("HELLO");
		eyes.checkRegion(region);
	}

}*/