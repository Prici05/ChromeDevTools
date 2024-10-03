import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class setGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		
		Map<String, Object> coordinates = new HashMap<String, Object>();
		coordinates.put("latitude", 40);
		coordinates.put("longitude", 3);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
		driver.get("https://my-location.org/");
		System.out.println(driver.findElement(By.id("address")).getText());
		
		
		
//		driver.get("https://www.google.co.in/");
//		driver.findElement(By.cssSelector(".gLFyf")).sendKeys("netflix", Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector(".LC20lb")).click();
//		String message = driver.findElement(By.cssSelector(".default-ltr-cache-jmnaey")).getText();
//		System.out.println(message);

	}

}
