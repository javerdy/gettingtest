package goo.stqa.sgmail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginExist {
  WebDriver wd;

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  @BeforeMethod
  public void setUp() throws Exception {

    //For Firefox
    //wd = new FirefoxDriver();

    //For Chrome
    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
    wd = new ChromeDriver();

    //For IE
/*    System.setProperty("webdriver.IE.driver", "C:\\Tools\\IE\\IEdriver.exe");
    wd = new InternetExplorerDriver();*/

    //For Opera
/*    System.setProperty("webdriver.opera.driver", "C:\\Tools\\IE\\IEdriver.exe");
    wd = new OperaDriver();*/

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void loginExist() {
    wd.get("https://accounts.google.com");

    wd.findElement(By.id("Email")).click();
    wd.findElement(By.id("Email")).clear();
    wd.findElement(By.id("Email")).sendKeys("krutomar@gmail.com");
    wd.findElement(By.id("next")).click();
    wd.findElement(By.id("Passwd")).click();
    wd.findElement(By.id("Passwd")).clear();
    wd.findElement(By.id("Passwd")).sendKeys("ytgPVY96P4u");
    wd.findElement(By.id("signIn")).click();
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }
}
