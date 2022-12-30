package TestNG1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//import org.testng.DataProviderHolder;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;


public class TestParameters {

WebDriver driver;
	
	//@BeforeSuite
	@BeforeClass
	public void setup() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C://Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(5000);
}
	
	@Test(priority=1,dataProvider="param2")
	public void login(String mail, String psw) {
		driver.get("https://www.browserstack.com/users/sign_in");
		driver.findElement(By.xpath("//input[@id='user_email_login']")).sendKeys(mail);
	
		driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys(psw);
		
		driver.findElement(By.xpath("//input[@id='user_submit']")).click();
		Assert.assertEquals(driver.getTitle( ), "Webpage3");
		
	}


	
	@AfterMethod
	
	public void screenshot(ITestResult rs) throws IOException {
		
		if(rs.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			File target = new File(System.getProperty("user.dir")+"/Screenshots/"+rs.getName()+".png");
			FileUtils.copyFile(source,target);
			
			System.out.println("Screenshot captured");
			
		}else {
			
			System.out.println("Login method Pass");
		}
	}
	
	@DataProvider(name="param2")
	String [][] loginData() {
		String r[][]={{"siva.gtf@gmail.com", "56tfdrhj"},{"chandu@gmail.com","5645667"}};
		return r;
		
	} 
	

	@AfterClass
	public void quit() {
		
		driver.close();
		
	}

}

	

