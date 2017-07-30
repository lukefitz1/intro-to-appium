import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;

import com.applitools.eyes.Eyes;


public class androidbasics {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		Eyes eyes = new Eyes();
		eyes.setApiKey("95dlJqlySCR2I46tb9J0HBHdlQjAq5JSN66Y4BcmQig110"); //<-- BA gmail account
		
		System.out.println("ANDROID_HOME: " + System.getenv("ANDROID_HOME"));
		System.out.println("ANDROID_SDK: " + System.getenv("ANDROID_SDK"));
		System.out.println("JAVA_HOME: " + System.getenv("JAVA_HOME"));
		System.out.println("PATH: " + System.getenv("PATH"));
		
		DesiredCapabilities cap = new DesiredCapabilities();	
		
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "VS9804G4f088eb9");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "48");
		
		//Firefox on Android is not supported yet
		//cap.setCapability(MobileCapabilityType.BROWSER_NAME, "Firefox");
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "44");
		
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "100");
		
		//invoking the android driver
		//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), cap);
		
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//invoking the android driver
		//AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), cap);
		driver = new AndroidDriver(new URL("http://127.0.0.1:4727/wd/hub"), cap);
		driver = eyes.open(driver, "test", "header test");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		//driver.get("http://qa.aaa.dev/batest-simple.html");
		driver.get("http://www.signaturehardware.com/");
		
		System.out.println("Before check region");
		
		//eyes.checkRegion(By.id("header"), "Header"); <- for AAA
		eyes.checkRegion(By.id("header-container"), "sig header test in chrome"); //<- for SIG
		
		System.out.println("After check region");
		
		//Thread.sleep(3000);
		eyes.close();
		driver.quit();
	}

}
