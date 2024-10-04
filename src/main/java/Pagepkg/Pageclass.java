package Pagepkg;

import java.util.List;
import java.util.Set;
import java.io.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pageclass {
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"account-section-div\"]/div[1]/a/i")
	WebElement iconclick;
	
	@FindBy(xpath="//*[@id=\"account-section-div\"]/div[1]/ul/li[1]/a")
	WebElement register;
	
	@FindBy(id="input-registration-firstname")
	WebElement name;
	@FindBy(id="email")
	WebElement email;
	@FindBy(id="input-registration-telephone")
	WebElement mob;
	@FindBy(id="input-registration-password")
	WebElement pswd;
	@FindBy(id="input-register-dateofbirth")
	WebElement DOB1;
	
	@FindBy(id="search_query")
	WebElement onlysearch;
	@FindBy(xpath="/html/body/div[4]/div[2]/div[1]/div[1]/div[2]/div[3]/div[2]/div/div[4]/label[1]")
	WebElement size;
	@FindBy(id="button-cart")
	WebElement addcart;
	
	
	public Pageclass(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	/*title verify*/
	/*registration page*/
	public void setvalues(String Name,String Email,String Mob,String Pswd,String DOB) throws Exception
	{
		iconclick.click();
		register.click();
		Thread.sleep(3000);
		name.sendKeys(Name);
		email.sendKeys(Email);
		mob.sendKeys(Mob);
		pswd.sendKeys(Pswd);
		DOB1.sendKeys(DOB);
		
	}
	public void search() throws Exception/*search "top" in search bar*/
	{
		Thread.sleep(3000);
		onlysearch.sendKeys("tops");
		WebElement top=driver.findElement(By.xpath("//*[@id=\"search-content\"]/div[3]/div/div[2]/div[3]/div[1]/div/div[1]/a"));
		top.click();
		System.out.println("CHECK THE NEW WINDOW TITLE");
		String parentWindow=driver.getWindowHandle();
		Set<String> allWindowHandles=driver.getWindowHandles();
		for(String handle: allWindowHandles)
		{
			if(!handle.equalsIgnoreCase(parentWindow))
			{
				driver.switchTo().window(handle);
				System.out.println("Child window title:"+driver.getTitle());
				
				Thread.sleep(3000);
			}
			
		}
		System.out.println("CHOOSE THE SIZE");
		size.click();//choose size of top
		System.out.println("NOW ADD TO CART");
		
	}
	public void cart() throws Exception
	{

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		System.out.println("ADD TO CART BUTTON CLICK");
		addcart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));		
		driver.findElement(By.id("cart")).click();
		System.out.println("CLICK THE CART ICON");
		System.out.println("DROPDOWN CHOOSE 4 AS QUANTITY");
		WebElement testdropdown=driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div/form/div/table/tbody/tr[3]/td[3]/select"));
		Select dropdown=new Select(testdropdown);/*no of items 4*/
		dropdown.selectByVisibleText("4");
		WebElement msg=driver.findElement(By.xpath("/html/body/div[4]/div[1]"));
		System.out.println(msg.getText());
		Thread.sleep(3000);
		System.out.println("PLACE THE ORDER NOW");
		driver.findElement(By.xpath("//*[@id=\"button-proceed-to-pay\"]")).click();
		
	}
	public void screenshot() throws IOException, InterruptedException
	{ 
		Thread.sleep(3000);
		File screenpic=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenpic,new File("./MyScreenshot/screenpic.png"));
		System.out.println("CHECK SCREENPIC IN MYSCREENSHOT");
		
		String childWindow=driver.getWindowHandle();
		Set<String> allWindowHandles=driver.getWindowHandles();
		for(String handle: allWindowHandles)
		{
			if(!handle.equalsIgnoreCase(childWindow))
			{
				driver.switchTo().window(handle);
				System.out.println("parent window title:"+driver.getTitle());
				
				Thread.sleep(3000);
			}
			
		}
		
	}
	public void home()
	{
		
		System.out.println("CHOOSE GIRL BUTTON");
		driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/ul/li[1]/div/label/span[1]/i")).click();
		System.out.println("CLICK THE GRID");
		driver.findElement(By.xpath("//*[@id=\"st-product-grid-4\"]")).click();//click the grid 
		driver.findElement(By.xpath("//*[@id=\"search-content\"]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/span/span[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"search-content\"]/div[3]/div/div[2]/div[1]/div[2]/div/div/div/span/ul/li[4]/span")).click();
		System.out.println("CHOSE SORT BY OPTION");
		
		List<WebElement> link=driver.findElements(By.tagName("a"));
		System.out.println("No of links in the current page="+link.size());
		iconclick.click();
		System.out.println("Register to purchase.Thank You!");
	}

}
