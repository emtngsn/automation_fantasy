package fantasy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;


public class baseball{
	
	static int i, j, k, l=1;
	static int newrowsize;
	static List<String> all_rows =new ArrayList<String>();
	static WebDriver driver;
	
	
	public static void main(String[] args) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\etongson\\Desktop\\Automation\\chromedriver_win32\\chromedriver.exe");
	//	ChromeOptions options = new ChromeOptions();
	//	options.addArguments("user-data-dir=C:/Users/etongson/AppData/Local/Google/Chrome/User Data/Default");
	//	options.addArguments("--start-maximized");
		driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver,30);
		
		String baseUrl2 = "https://swishanalytics.com/optimus/mlb/fanduel-draftkings-live-scoring";
		driver.get(baseUrl2);
		driver.manage().window().maximize();
		
		Thread.sleep(5000);
		
		WebElement main = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div/div[3]/div/div/div[1]/button[2]")));
		main.click();
		
		Thread.sleep(15000);

		List<WebElement> rows = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/div[6]/div/div[3]/div/table/tbody/tr/td[1]"));
		
		for(i=0; i<rows.size(); i++){
			all_rows.add(rows.get(i).getText().replaceAll("\\(.*\\)",""));  
			System.out.println(rows.get(i).getText().replaceAll("\\(.*\\)",""));
		}
		System.out.println(all_rows.size());
		System.out.println("----------");
		
		
		String baseUrl1 = "https://baseball.fantasysports.yahoo.com/b1/152675/players";
		driver.get(baseUrl1);
		driver.manage().window().maximize();
		
		WebElement uname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-username\"]")));
		uname.sendKeys("fstester@yahoo.com");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login-passwd\"]")));
		pass.sendKeys("1234@abc");
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
		
		
		if (all_rows.size() <= 99) {
			for (j=0; j<all_rows.size(); j++) {
				WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playersearchtext\"]")));
				System.out.println(j);
				System.out.println(all_rows.get(j));
				search.sendKeys(all_rows.get(j));
				
				WebElement search_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/div[1]/div/form/div/input")));
				search_button.click();
				
				WebElement watch_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[2]/div/div/div/div/table/tbody/tr/td[1]")));
				js.executeScript("arguments[0].scrollIntoView();", watch_list);
				watch_list.click();
				
				WebElement clear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/div[1]/div/form/div/div[1]/input")));
				clear.clear();
				
				Thread.sleep(30000);	
			}
				
		}
		
		else {
			for (j = 0; j<=99; j++) {
				WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"playersearchtext\"]")));
				System.out.println(j);
				System.out.println(all_rows.get(j));
				search.sendKeys(all_rows.get(j));
				
				WebElement search_button = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/div[1]/div/form/div/input")));
				search_button.click();
				
				WebElement watch_list = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[2]/div/div/div/div/table/tbody/tr/td[1]")));
				js.executeScript("arguments[0].scrollIntoView();", watch_list);
				watch_list.click();
				
				WebElement clear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[2]/div[2]/div[2]/div/div/div[2]/div[2]/section/div/div/div[3]/section[1]/div[1]/div/form/div/div[1]/input")));
				clear.clear();
				
				Thread.sleep(30000);
			}
		}
		System.out.println("J: "+j);
		newrowsize = all_rows.size();
		System.out.println("New Row Size:" + newrowsize);
		
				
		driver.quit();
	              
	}
	
}
