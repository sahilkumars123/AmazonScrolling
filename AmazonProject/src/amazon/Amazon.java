package amazon;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Amazon {
	
WebDriver driver;
int count;
	
	public void invokeBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sahilkumar\\OneDrive - Quark Software Inc\\Desktop\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");	
	}
	
	public String searchProduct(String Product, String Category)
	{
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Product);
		WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
		Select categoryWise = new Select(dropdown);
	    categoryWise.selectByVisibleText(Category);
	    driver.findElement(By.id("nav-search-submit-button")).click();
			
	    return driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span")).getText();
	}
	
	public void getNthProductInfo(int number)
	{
		String productXpath = String.format("//div[@class='s-main-slot s-result-list s-search-results sg-row']//div[@data-index='%d']", number);
		String value = driver.findElement(By.xpath(productXpath)).getText();
		System.out.println("Description of "+number+"th product is :: "+value);
	}
	
	public void  getAllProductInfo() 
	{
		List<WebElement> listofallElements = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div"));
		int productCount = listofallElements.size();
		System.out.println("Number of links:: "+productCount);
		int x,y;
		
		for(WebElement temp : listofallElements)
		{
			x = temp.getLocation().x;
			y = temp.getLocation().y;
			scrollByUsingJS(x,y);
			System.out.println("COUNT IS "+count++);
			System.out.println("Product Info::  "+"\n"+temp.getText()+"\n\nProduct Unique code is :: "+temp.getAttribute("data-asin"));
			System.out.println("----------------------------------------------------------------------------------------");
		} 
	}
	
	public void  getAllProductInfoViaScrollDown() 
	{
		List<WebElement> listofallElements = driver.findElements(By.xpath("//div[@class='s-main-slot s-result-list s-search-results sg-row']/div"));
		int productCount = listofallElements.size();
		System.out.println("Number of links:: "+productCount);
		Actions action = new Actions(driver);
		
		for(WebElement temp : listofallElements)
		{
			action.moveToElement(temp).build().perform();
			System.out.println("COUNT IS "+count++);
			System.out.println("Product Info::  "+"\n"+temp.getText()+"\n\nProduct Unique code is :: "+temp.getAttribute("data-asin"));
			System.out.println("----------------------------------------------------------------------------------------");
		} 
	}
	
	private void  scrollByUsingJS(int x, int y) 
	{
		JavascriptExecutor jsEngine;
	    String jsCommand; 
	    jsEngine = (JavascriptExecutor) driver; //Webdriver interface is called above to invoke chrome browser
	    jsCommand = String.format("window.scrollBy(%d,%d)",x,y);
	    jsEngine.executeScript(jsCommand);
	}

}
