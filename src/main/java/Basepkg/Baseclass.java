package Basepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	public WebDriver driver;
	 @BeforeClass
	 
	 public void Setup()
	 {
		 driver=new ChromeDriver();
		 driver.get("https://www.only.in/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		 
	 }
	 
	
}

