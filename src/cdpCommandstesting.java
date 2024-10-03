import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v125.emulation.Emulation;

public class cdpCommandstesting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		ChromeDriver driver = new ChromeDriver();
		DevTools devtools = driver.getDevTools();
		devtools.createSession();
		Map cdpcommand = new HashMap();
		cdpcommand.put("width", 600);
		cdpcommand.put("height", 1000);
		cdpcommand.put("deviceScaleFactor", 50);
		cdpcommand.put("mobile", true);
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", cdpcommand);
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		driver.findElement(By.className("navbar-toggler-icon")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Library")).click();

	}

}
