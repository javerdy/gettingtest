package goo.stqa.sgmail;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class RegistratFormTest {
  WebDriver wd;

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
  public void logTest() throws Exception {

    goToGmail();
    goToCreateAccount();
    fillRegFormFromExcel();
  }

  private void fillRegFormFromExcel() {
    try {
      File file = new File("C:\\Reposit\\gettingtest\\UserData.xlsx");
      FileInputStream iFile = new FileInputStream(file);

      XSSFWorkbook wb = new XSSFWorkbook(iFile);
      XSSFSheet sheet = wb.getSheet("Sheet1");

      int rowCount = sheet.getLastRowNum();

      for (int row = 1; row <= rowCount; row++) {

        String Username = sheet.getRow(row).getCell(0).getStringCellValue();
        String LastName = sheet.getRow(row).getCell(1).getStringCellValue();
        String GmailAddress = sheet.getRow(row).getCell(2).getStringCellValue();
        String Password = sheet.getRow(row).getCell(3).getStringCellValue();

        wd.findElement(By.id("FirstName")).sendKeys(Username);
        wd.findElement(By.id("LastName")).sendKeys(LastName);
        wd.findElement(By.id("GmailAddress")).sendKeys(GmailAddress);
        wd.findElement(By.id("Passwd")).sendKeys(Password);
        wd.findElement(By.id("PasswdAgain")).sendKeys(Password);

        wd.findElement(By.id("birthday-placeholder")).click();
        wd.findElement(By.id("BirthDay")).clear();
        wd.findElement(By.id("BirthDay")).sendKeys("12");

        wd.findElement(By.xpath(".//*[@id='BirthYear']")).click();
        wd.findElement(By.xpath(".//*[@id='BirthYear']")).sendKeys("1985");

      }

      iFile.close();

      wd.findElement(By.xpath("//*[@id=\"BirthMonth\"]/div")).click();
      wd.findElement(By.xpath("//*[@id=\":6\"]/div")).click();

      wd.findElement(By.xpath("./*//*[@id='Gender']/div")).click();
      wd.findElement(By.xpath("//div[@id=':f']//div[.='Male']")).click();

      wd.findElement(By.id("submitbutton")).click();
      wd.findElement(By.id("iagreebutton")).click();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void goToCreateAccount() {
    wd.findElement(By.linkText("Create account")).click();
  }

  private void goToGmail() {
    wd.get("https://gmail.com");
  }


  @AfterMethod
  public void tearDown() {
    wd.quit();
  }

}



