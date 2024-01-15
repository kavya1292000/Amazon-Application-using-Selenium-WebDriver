package Phase1EndProject;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestMobilePage {
	
public static WebDriver driver;
	
	public static void takescreenshot_method(String filepath) throws IOException
	{
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File(filepath);
		FileUtils.copyFile(srcFile, destFile);
	}
	public static void main(String[] args) throws InterruptedException, IOException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
   
		driver.get("https://www.amazon.in/");
		
		Thread.sleep(2000);
		
		WebElement mobilelink = driver.findElement(By.linkText("Mobiles"));
		
		  String text = mobilelink.getText();
			
			System.out.println(text);
		
		
		mobilelink.click();
		
		
		WebElement mobile = driver.findElement(By.xpath("//div[@id='nav-progressive-subnav']/descendant::span[2]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(mobile).perform();
		
		Thread.sleep(2000);
		
		takescreenshot_method("./Screenshot/mobile1.png");
		
		WebElement apple_link = driver.findElement(By.linkText("Apple"));
		
        text = apple_link.getText();
		
		System.out.println(text);
		
		apple_link.click();
		
		
		Thread.sleep(2000);
		
		WebElement link2 = driver.findElement(By.xpath("(//div[@class='sg-col-inner'])[6]/descendant::span[9]"));
		
		 text = link2.getText();
		
		System.out.println(text);
		
		link2.click();
		
		takescreenshot_method("./Screenshot/mobile2.png");
		
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(1));
	
		
		Thread.sleep(1500);
		
		WebElement addtoCart = driver.findElement(By.id("add-to-cart-button"));
		
		
		addtoCart.click();
		
		
		takescreenshot_method("./Screenshot/mobile3.png");
		
		
		driver.quit();
		
		
	}


}
