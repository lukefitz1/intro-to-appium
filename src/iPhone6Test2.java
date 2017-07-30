import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;


public class iPhone6Test2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//desired capabilities setup
		cap.setCapability(MobileCapabilityType.BROWSER_NAME, "safari");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.4");
		
		//choose device
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		
		//setup iOS driver
		IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		//WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
		
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("Signature Hardware");
		
		WebElement click = driver.findElement(By.name("btnG"));
		click.click();
		
		WebElement result = driver.findElement(By.cssSelector("#s0p1"));
		result.click();
		
		WebElement mobileNav = driver.findElement(By.cssSelector("#mobile-trigger"));
		mobileNav.click();
		
		Thread.sleep(2000);
		WebElement bathroom = driver.findElement(By.cssSelector("#main-nav > li.level0.nav-1.level-top.parent > a"));
		bathroom.click();
		
		Thread.sleep(2000);
		WebElement bathtubs = driver.findElement(By.cssSelector("#amshopby-page-container > div.category-view > div.categories-list > ul > li.category.category-1.end.tablet-end.first.odd > a > div"));
		bathtubs.click();
				
		Thread.sleep(2000);
		WebElement boyce = driver.findElement(By.cssSelector("#amshopby-page-container > div.category-view > div.category-products > div > ul.products-grid.first.odd > li.item.first > a"));
		boyce.click();
		
		Thread.sleep(2000);
		WebElement mobileNav1 = driver.findElement(By.cssSelector("#mobile-trigger"));
		mobileNav1.click();
		
		Thread.sleep(2000);
		WebElement kitchen = driver.findElement(By.cssSelector("#main-nav > li.level0.nav-2.level-top.parent > a"));
		kitchen.click();
		
		Thread.sleep(2000);
		WebElement kitchensinks = driver.findElement(By.cssSelector("#amshopby-page-container > div.category-view > div.categories-list > ul > li.category.category-1.end.tablet-end.first.odd > a > div"));
		kitchensinks.click();
		
		Thread.sleep(2000);
		WebElement reinhard = driver.findElement(By.cssSelector("#amshopby-page-container > div.category-view > div.category-products > div > ul.products-grid.first.odd > li.item.first > a"));
		reinhard.click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
