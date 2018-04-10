package grid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestGrid {

	static WebDriver driver;
	static String nodeURL;

	public static void main(String[] args) {

		try {
			nodeURL = "http://172.26.7.122:5521/wd/hub";

			DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			capabilities.setBrowserName("chrome");
			capabilities.setPlatform(Platform.WINDOWS);

			driver = new RemoteWebDriver(new URL(nodeURL), capabilities);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
			driver.get("http://rpm.kp.org");
			System.out.println("Title is :"+driver.getTitle());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
