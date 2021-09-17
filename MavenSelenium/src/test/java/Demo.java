import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;



import io.github.bonigarcia.wdm.WebDriverManager;



public class Demo {

ExtentSparkReporter reporter;
ExtentReports extent;

@BeforeSuite
public void setUp()
{
reporter = new ExtentSparkReporter("myreport.html");
extent = new ExtentReports();
extent.attachReporter(reporter);
}
@Test
public void TestMethod() {
ExtentTest test = extent.createTest("My first test");
test.log(Status.INFO, "This shows info");

//System.setProperty("webdriver.chrome.driver", "C:\\Users\\gopalakrishnanjm\\eclipse-workspace-seleniumTraining\\SeleniumProject\\drivers\\chromedriver.exe");
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();

//System.setProperty("webdriver.gecko.driver", "C:\\Users\\gopalakrishnanjm\\eclipse-workspace-seleniumTraining\\SeleniumProject\\drivers\\geckodriver.exe");
//WebDriver driver = new FirefoxDriver();

driver.get("http://www.google.com");
//Thread.sleep(5000);
WebElement searchBox = driver.findElement(By.name("q"));
searchBox.sendKeys("Chennai");
searchBox.submit();
//Thread.sleep(5000);
driver.quit();

}
@AfterSuite
public void tearDown() {
extent.flush();
}
}