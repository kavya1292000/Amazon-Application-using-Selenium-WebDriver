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

public class TestSearchPage {
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
		
		Thread.sleep(1500);
		WebElement searchbox = driver.findElement(By.id("twotabsearchtextbox"));
		WebElement searchbutton = driver.findElement(By.id("nav-search-submit-button"));
		searchbox.sendKeys("iphone 13");
		searchbutton.submit();
		takescreenshot_method("./Screenshot/amazonsearch1.png");
		Thread.sleep(3000);
		WebElement mobilelink = driver.findElement(By.xpath("(//div[@class='a-section'])[2]/descendant::span[11]"));
		mobilelink.click();
		takescreenshot_method("./Screenshot/amazonsearch2.png");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	    Thread.sleep(1500);
		WebElement wishlist = driver.findElement(By.id("wishListMainButton"));
		wishlist.click();
		driver.quit();
    }
}
