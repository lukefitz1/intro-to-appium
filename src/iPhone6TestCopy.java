import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.applitools.eyes.Eyes;
import com.applitools.eyes.Region;


public class iPhone6TestCopy {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver;
		Eyes eyes = new Eyes();
		eyes.setApiKey("95dlJqlySCR2I46tb9J0HBHdlQjAq5JSN66Y4BcmQig110"); //<-- BA gmail account
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
	
		//setup iOS driver
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver = eyes.open(driver, "test", "header test");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://www.signaturehardware.com/");
		
		System.out.println("Before check region");
		
		Thread.sleep(2000);

		//Check region with checkRegion command
		eyes.checkRegion(By.id("header-container"), "sig header test"); //<- for SIG

		//Check region with shift for iOS simulator issue
		/*WebElement element = driver.findElement(By.id("header-container"));
		int top = element.getLocation().getY();
		int left = element.getLocation().getX();
		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();
		
		Region region = new Region(left,top + 65,width,height);
		eyes.checkRegion(region);*/
		
		System.out.println("After check region");
		
		eyes.close();
		driver.quit();
	}
}
