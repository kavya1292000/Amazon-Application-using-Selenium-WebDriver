package Phase1EndProject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumJDBCTransaction {
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException, SQLException {
		WebDriver	driver = new ChromeDriver();
		driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.get("https://www.amazon.in/");
		
		String title = driver.getTitle();
		Thread.sleep(2000);
		WebElement mobilelink = driver.findElement(By.linkText("Mobiles"));
		mobilelink.click();
		WebElement mobile = driver.findElement(By.xpath("//div[@id='nav-progressive-subnav']/descendant::span[2]"));
		Actions a = new Actions(driver);
		a.moveToElement(mobile).perform();
		Thread.sleep(2000);
		WebElement apple_link = driver.findElement(By.linkText("Apple"));
		String text = apple_link.getText();
		apple_link.click();
		
		String dburl = "jdbc:mysql://localhost:3306/seleniumtest";
		String username = "root";
		String password = "root";
		
       Class.forName("com.mysql.cj.jdbc.Driver");
      
       Connection con = DriverManager.getConnection(dburl, username, password);
      
       PreparedStatement ps = con.prepareStatement("insert into endproject values(?,?,?)");
       ps.setString(1, title);
       ps.setString(2, text);
       ps.setString(3, "Yes");
       ps.executeUpdate();
		
	}


}
