package pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TidePowder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Amrutha G\\Desktop\\chromedriver (2).exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://tide.com/en-us");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(210, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//div[@id='page-wrapper'] //span[@class='login-register']")).click();
		driver.findElement(By.xpath("//a[@class='lilo3746-close-link lilo3746-close-icon']")).click();
		
		driver.findElement(By.xpath("//div[@id='__next'] //a[@class='event_internal_link']")).click();

		
		
		String ParentWindowHandle=driver.getWindowHandle();
		for(String mychild:driver.getWindowHandles()) {
			driver.switchTo().window(mychild);
		}
		
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Amrutha");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sonyoled66@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Idont!know@7677");
		driver.findElement(By.xpath("//input[@value='CREATE ACCOUNT']")).click();
		
		//livechat
		for(String mychild:driver.getWindowHandles()) {
			driver.switchTo().window(ParentWindowHandle);
			
		}
		driver.findElement(By.linkText("Live Chat")).click();
		
		//contact us
		driver.findElement(By.linkText("Contact Us")).click();
		
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//a[@data-action-detail='Shop Products']"))).build().perform();
		driver.findElement(By.linkText("Powder")).click();


	}
	

}
