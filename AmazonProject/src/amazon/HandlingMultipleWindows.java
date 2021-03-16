package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindows {
	
	

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahilkumar\\OneDrive - Quark Software Inc\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");	
		
	   String parentWindow = driver.getWindowHandle();	
	   System.out.println("Parent Window "+parentWindow);
	   driver.switchTo().frame("iframeResult");
	   driver.findElement(By.tagName("button")).click();
	   
	   String childWindow = driver.getWindowHandles().toArray()[1].toString();
	   driver.switchTo().window(childWindow);
	   String childWindowTitle =  driver.getTitle();
	   System.out.println("Child Window Title: "+childWindowTitle);  
	   driver.close();
	   driver.switchTo().window(parentWindow);
	   String ParentWindow = driver.getTitle();
	   System.out.println("Parent Window Title: "+ParentWindow);  
	   driver.quit();

	}

}
