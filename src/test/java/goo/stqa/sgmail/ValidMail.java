package goo.stqa.sgmail;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ValidMail {
  FirefoxDriver wd;

  @BeforeMethod
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
  }

  @Test
  public void validMail() {
    goToExistGmailAccount();
    loginAsExistSender("ytgPVY96P4u", "krutomar@gmail.com");
    writeNewEmail();
    sendEmail("mytesforgett@gmail.com","test");
    goToOtherAccount();
    loginAsExistSender("marios2005", "mytesforgett@gmail.com");
    goToInbox();
    assertElementOnPage();

    wd.findElement(By.xpath("//div[@id=':3f']/div")).click();
    wd.findElement(By.cssSelector("span.gb_7a.gbii")).click();
    wd.findElement(By.id("gb_71")).click();
  }

  private void assertElementOnPage() {
    if (!validEmail()) {
      goToOtherAccount();
      sendEmail("mytesforgett@gmail.com","test");
    }
    wd.findElement(By.name("Mario Pelin")).click();
  }

  private void goToInbox() {
    wd.findElement(By.linkText("Inbox")).click();
  }

  private void goToOtherAccount() {
    wd.findElement(By.id("account-chooser-link")).click();
    wd.findElement(By.id("account-chooser-add-account")).click();
  }

  private void writeNewEmail() {
    wd.get("https://mail.google.com/mail/#inbox");
    wd.findElement(By.xpath("//div[@class='z0']//div[.='COMPOSE']")).click();
  }

  private void sendEmail(String emailreseiver, String subject) {
    wd.findElement(By.id(":ck")).click();
    wd.findElement(By.id(":ck")).clear();
    wd.findElement(By.id(":ck")).sendKeys(emailreseiver);
    wd.findElement(By.id(":c4")).click();
    wd.findElement(By.id(":c4")).clear();
    wd.findElement(By.id(":c4")).sendKeys(subject);
    wd.findElement(By.id(":d9")).click();
    wd.findElement(By.id(":bu")).click();
    wd.findElement(By.cssSelector("span.gb_7a.gbii")).click();
    wd.findElement(By.id("gb_71")).click();
  }

  private void loginAsExistSender(String password, String login) {
    wd.findElement(By.id("Email")).click();
    wd.findElement(By.id("Email")).clear();
    wd.findElement(By.id("Email")).sendKeys(login);
    wd.findElement(By.id("next")).click();
    wd.findElement(By.id("Passwd")).click();
    wd.findElement(By.id("Passwd")).clear();
    wd.findElement(By.id("Passwd")).sendKeys(password);
    wd.findElement(By.id("signIn")).click();
  }

  private void goToExistGmailAccount() {
    wd.get("https://accounts.google.com");
  }

  public boolean validEmail() {
    return isElementPresent(By.name("Mario Pelin"));

  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

  protected boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (java.util.NoSuchElementException ex) {
      return false;

    }
  }

  }

