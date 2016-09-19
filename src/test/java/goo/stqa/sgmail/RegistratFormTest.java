package goo.stqa.sgmail;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class RegistratFormTest {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void logTest() {
    wd.get("https://accounts.google.com/SignUp?continue=https%3A%2F%2Faccounts.google.com%2FManageAccount");
    wd.findElement(By.id("firstname-placeholder")).click();
    wd.findElement(By.id("FirstName")).click();
    wd.findElement(By.id("FirstName")).clear();
    wd.findElement(By.id("FirstName")).sendKeys("Der");
    wd.findElement(By.id("LastName")).click();
    wd.findElement(By.id("LastName")).clear();
    wd.findElement(By.id("LastName")).sendKeys("Hyui");
    wd.findElement(By.id("GmailAddress")).click();
    wd.findElement(By.id("GmailAddress")).clear();
    wd.findElement(By.id("GmailAddress")).sendKeys("dervikol12");
    wd.findElement(By.id("Passwd")).click();
    wd.findElement(By.id("Passwd")).clear();
    wd.findElement(By.id("Passwd")).sendKeys("getttaxi");
    wd.findElement(By.id("PasswdAgain")).click();
    wd.findElement(By.id("PasswdAgain")).clear();
    wd.findElement(By.id("PasswdAgain")).sendKeys("getttaxi");
        /*wd.findElement(By.xpath("//div[@id=':8']//div[.='August']")).click();
        wd.findElement(By.id("birthday-placeholder")).click();
        wd.findElement(By.id("BirthDay")).click();
        wd.findElement(By.id("BirthDay")).clear();
        wd.findElement(By.id("BirthDay")).sendKeys("4");
        wd.findElement(By.id("birthyear-placeholder")).click();
        wd.findElement(By.id("BirthYear")).click();
        wd.findElement(By.id("BirthYear")).clear();
        wd.findElement(By.id("BirthYear")).sendKeys("2010");
        wd.findElement(By.xpath("//div[@id='Gender']/div[1]")).click();
        wd.findElement(By.id(":e")).click();*/
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
