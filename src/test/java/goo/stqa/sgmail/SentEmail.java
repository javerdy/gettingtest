package goo.stqa.sgmail;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;
import java.util.Date;
import java.io.File;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.*;
import static org.openqa.selenium.OutputType.*;

public class SentEmail {
    FirefoxDriver wd;
    
    @BeforeMethod
    public void setUp() throws Exception {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }
    
    @Test
    public void sentEmail() {
        wd.get("https://accounts.google.com");

        wd.findElement(By.id("Email")).click();
        wd.findElement(By.id("Email")).clear();
        wd.findElement(By.id("Email")).sendKeys("krutomar@gmail.com");
        wd.findElement(By.id("next")).click();
        wd.findElement(By.id("Passwd")).click();
        wd.findElement(By.id("Passwd")).clear();
        wd.findElement(By.id("Passwd")).sendKeys("ytgPVY96P4u");
        wd.findElement(By.id("signIn")).click();
        wd.get("https://mail.google.com/mail/#inbox");
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
        wd.findElement(By.cssSelector("span.gb_7a.gbii")).click();
        wd.findElement(By.id("gb_71")).click();
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
