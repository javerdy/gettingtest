package goo.stqa.sgmail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginExist {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void LoginExist() {
    wd.get("https://accounts.google.com");

    wd.findElement(By.id("Email")).click();
    wd.findElement(By.id("Email")).clear();
    wd.findElement(By.id("Email")).sendKeys("troikaosipova@gmail.com");
    wd.findElement(By.id("next")).click();
    wd.findElement(By.id("Passwd")).click();
    wd.findElement(By.id("Passwd")).clear();
    wd.findElement(By.id("Passwd")).sendKeys("sfolyata2016");
    wd.findElement(By.id("signIn")).click();
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