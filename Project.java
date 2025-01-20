package Sample_project;

import static org.junit.Assert.assertArrayEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class Project {
	 private static final List<WebElement> Radio = null;
	WebDriver driver;
	
	 
 @BeforeTest
 public void setup() {
	 System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\EHRC\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	 
	  driver = new ChromeDriver();
	 driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	 driver.manage().window().maximize();
}
 
  @Test(enabled = true, priority = 1) 
  public void Radio() throws InterruptedException {
	  
//	 List<WebElement> radiobuttons = driver.findElements(By.xpath("//input[@name='radioButton']"));
//		
//	   for (WebElement  radiobutton :  radiobuttons ) {
//	   
//	   radiobutton.click();
//	   Thread.sleep(1000);
//	   }
//  }or
	  
	  for (int i=0;i<=2;i++) {
	  
	  driver.findElements(By.xpath("//input[@name='radioButton']")).get(i).click();
	  Thread.sleep(2000);
	  }
	  
	  
  }
  
  
  @Test(enabled = true, priority = 2)
  public void Suggession() {
	  driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Sample Test");
  }
  
  @Test(enabled = true, priority = 3)
  public void dropdown() {
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	  WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
	  Select sel = new Select(dropdown);
		sel.selectByIndex(2);
  }
  
  @Test(enabled = true, priority = 4)
  public void checkbox() throws InterruptedException {  
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	  for (int i=0;i<=2;i++) {
		  
		  driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
		  Thread.sleep(2000);
		  }
	  
  } 
  
//  List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
//	
// for (WebElement  checkbox :  checkboxes ) {
// 
//	 checkbox.click();
// Thread.sleep(1000);
// }

 
 @Test(enabled = true, priority = 5)
 public void Tab() {
	 driver.findElement(By.xpath("//a[@class='btn-style class1 class2']")).click();
	 Set<String> windowHandles = driver.getWindowHandles();
	 List<String> tabs = new ArrayList<>(windowHandles);
	 driver.switchTo().window(tabs.get(1));
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	 driver.findElement(By.xpath("//a[@class='main-btn']")).click();
	 driver.switchTo().window(tabs.get(0));
 }
 
 @Test(enabled = true, priority = 6)
 public void alert() throws InterruptedException {
	 
	 driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
	 driver.findElement(By.xpath("//input[@name='enter-name']")).sendKeys("Test");
	 Thread.sleep(10000);
	 driver.findElement(By.id("confirmbtn")).click();
	 
	Alert alert = driver.switchTo().alert();
	 alert.accept();
	// alert.dismiss();
	 
 }
     
}
