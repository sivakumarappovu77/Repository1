package TestNG1.TestNG1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.asserts.*;

import dev.failsafe.internal.util.Assert;

public class TestNGPracticePageTest {
	public WebDriver driver ;
	
	
	@Test(priority=0)
  public void config() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver.exe");
	 driver = new ChromeDriver();
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }
				
	
	
	@Test(dataProvider="Login_data_provider",priority=1)
	public void loginpage(String uname,String psw) throws InterruptedException {
		System.out.println(uname +" : "+psw);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input")).sendKeys(uname);
		driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input")).sendKeys(psw);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@type='submit']")).click(); 
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).isDisplayed());
		driver.quit();
	}
	
	@DataProvider(name="Login_data_provider")
	public Object [] [] provider(){
		Object [][] data = {{"Admin","admin123"},{"admin","Admin123"}};
		return data;
	}
	
	
	/*@AfterClass
	@Test
	public void exit() {
		driver.close();
	}*/
	
	
}
