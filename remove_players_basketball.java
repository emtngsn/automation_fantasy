package fantasy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class remove_players_basketball{
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\etongson\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("user-data-dir=C:/Users/etongson/AppData/Local/Google/Chrome/User Data/Default");
//		options.addArguments("--start-maximized");
		ChromeDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		String baseUrl1 = "https://basketball.fantasysports.yahoo.com/nba/255421/players";
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-username\"]")));
		uname.sendKeys("fstester@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-passwd\"]")));
		pass.sendKeys("1234@abc");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		
//		WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/header/section/nav/div/ul/li[3]/a")));
		WebElement menu = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/header/section/nav/div/ul/li[3]/a"));
		WebElement sub = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/header/section/nav/div/ul/li[3]/ul/li[3]/a"));
		
		Actions builder = new Actions(driver);
		builder.moveToElement(menu).build().perform();
		builder.moveToElement(sub).build().perform();
		sub.click();
		
		
		js.executeScript("window.scrollBy(0,250)");
		Thread.sleep(10000);
		WebElement TogetRows = driver.findElement(By.xpath("//*[@id=\"playerswatchform\"]"));		
		List<WebElement> rows = TogetRows.findElement(By.tagName("tbody")).findElements(By.tagName("tr"));
		System.out.println(rows.size());
		for (int i=1; i<=rows.size(); i++){
			
			WebElement player = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/form/div/table/tbody/tr["+ i +"]/td[1]/div/a")));
			js.executeScript("arguments[0].scrollIntoView();", player);
			
			WebElement remove = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/form/div/table/tbody/tr["+ i +"]/td[1]/div/a")));
			remove.click();
			System.out.println(i);
			
			Thread.sleep(10000);
		}
	
		driver.navigate().refresh();
		driver.quit();
	              
	}
	
}
