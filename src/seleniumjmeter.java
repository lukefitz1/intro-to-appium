import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;


public class seleniumjmeter {

	public static void main(String[] args) throws MalformedURLException {
		WebDriver driver;
		DesiredCapabilities cap = new DesiredCapabilities();
		
		cap.setBrowserName("firefox");
		cap.setVersion("45.0.2");
		cap.setPlatform(Platform.MAC);
		
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		driver.manage().window().setSize(new Dimension(1280, 850));
		
		driver.get("http://google.com");
		System.out.println("Hello1");
		
		driver.quit();

	}

}
