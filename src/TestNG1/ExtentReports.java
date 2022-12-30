package TestNG1;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentReports {
	
	
	WebDriver driver;
	WebDriverWait mywait;
	  
	
  @BeforeClass
  public void set() throws Exception{
	  
	  System.setProperty("webdriver.chrome.driver","C://Drivers//chromedriver.exe" );
	  driver = new ChromeDriver();
	  driver.get("https://artoftesting.com/samplesiteforselenium");
	  
  }
  
  @Test
  public void drag() throws Exception{
	  
	   mywait= new WebDriverWait(driver, Duration.ofSeconds(30));
	  
	  WebElement source = mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@id='sourceImge']")));
	  WebElement desti = driver.findElement(By.xpath("//input[@type='text' and @name='firstName']"));
	  
	  Actions act = new Actions(driver);
	  Assert.assertTrue(false);
	  
	  act.dragAndDrop(source, desti).build().perform();
	  
  }
}
