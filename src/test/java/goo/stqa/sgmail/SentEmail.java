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

public class SentEmail {
  WebDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {

    //For Firefox
    wd = new FirefoxDriver();

    //For Chrome
/*
    System.setProperty("webdriver.chrome.driver", "C:\\Tools\\chromedriver_win32\\chromedriver.exe");
    wd = new ChromeDriver();
*/

    //For IE
/*    System.setProperty("webdriver.IE.driver", "C:\\Tools\\IE\\IEdriver.exe");
    wd = new InternetExplorerDriver();*/

    //For Opera
/*    System.setProperty("webdriver.opera.driver", "C:\\Tools\\IE\\IEdriver.exe");
    wd = new OperaDriver();*/

    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void sentEmail() {
    goToGoogleAcc();
    fillFormLogin();
    goToInbox();
    writeNewLetter();
    exitAcc();
  }

  private void exitAcc() {
    wd.findElement(By.cssSelector("span.gb_7a.gbii")).click();
    wd.findElement(By.id("gb_71")).click();
  }

  private void writeNewLetter() {
    wd.findElement(By.xpath("//div[@class='z0']//div[.='COMPOSE']")).click();
    wd.findElement(By.id(":ck")).click();
    wd.findElement(By.id(":ck")).clear();
    wd.findElement(By.id(":ck")).sendKeys("mytesforgett@gmail.com");
    wd.findElement(By.id(":c4")).click();
    wd.findElement(By.id(":c4")).clear();
    wd.findElement(By.id(":c4")).sendKeys("test");
    wd.findElement(By.id(":d9")).click();
    wd.findElement(By.id(":bu")).click();
    wd.findElement(By.cssSelector("div.Cr.aqJ")).click();
  }

  private void goToInbox() {
    wd.get("https://mail.google.com/mail/#inbox");
  }

  private void fillFormLogin() {
    wd.findElement(By.id("Email")).click();
    wd.findElement(By.id("Email")).clear();
    wd.findElement(By.id("Email")).sendKeys("krutomar@gmail.com");
    wd.findElement(By.id("next")).click();
    wd.findElement(By.id("Passwd")).click();
    wd.findElement(By.id("Passwd")).clear();
    wd.findElement(By.id("Passwd")).sendKeys("ytgPVY96P4u");
    wd.findElement(By.id("signIn")).click();
  }

  private void goToGoogleAcc() {
    wd.get("https://accounts.google.com");
  }

  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  public static boolean isAlertPresent(FirefoxDriver wd) {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }
}
