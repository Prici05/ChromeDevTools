import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import org.testng.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoITFileuploadingfromdevice {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		String downloadPath=System.getProperty("user.dir");
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		ChromeOptions options=new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.pdf.to/jpg/");
		driver.findElement(By.cssSelector("span[class*='mt-3']")).click();
		System.out.println("completed");
		Thread.sleep(3000);
		
		 String[] command = {
		            "C:/Users/arockia.p.stephen/Downloads/AutoIt3.exe",  // Path to AutoIt interpreter
		            "C:/Users/arockia.p.stephen/Downloads/fileexecution.au3"  // Path to .au3 script
		        };
		 
		// Environment variables (if any)
	        String[] envp = null;

	        File dir = new File("C:/Users/arockia.p.stephen/Downloads");
	        
	        
	
		Runtime.getRuntime().exec(command, envp, dir);
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
//		waiting for loading option and clicking on that
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));
		driver.findElement(By.cssSelector("button[class*='medium']")).click();
		
//		Waiting for download option and clicking on that
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Download Now")));
		driver.findElement(By.linkText("Download Now")).click();

		Thread.sleep(5000);

		File f=new File(downloadPath+"/converted.zip");

		if(f.exists())

		{

		Assert.assertTrue(f.exists());

		if(f.delete())

		System.out.println("file deleted");

		}

		}


	}


