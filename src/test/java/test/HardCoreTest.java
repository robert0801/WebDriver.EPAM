package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import HardCore.*;

import java.util.concurrent.TimeUnit;


public class HardCoreTest {
    public WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
        driver.manage().window().maximize();
                }

    @Test
    public void openPage(){
        PageWithSettings cloudPage = new CloudGoogleComPage(driver)
                .getToStartPage()
                .checkNumberOfInstances()
                .checkOperatingSystem()
                .checkMachineClass()
                .checkMachineType()
                .checkAddGPU()
                .checkLocalSSD()
                .checkDatacenterLocation()
                .checkCommittedUsage()
                .addToEstimate()
                .emailEstimate()
                .createNewTab();

        GenerateMailPage mailPage = new GenerateMailPage(driver)
                .getToMailPage()
                .copyMail();
        cloudPage
                .checkInputMail()
                .checkSendEmail()
                .getPriceInCalculator();
        mailPage
                .clickToOpenMail()
                .getPriceOnGenerateMailPage();
    }

    @Test(dependsOnMethods = "openPage")
    public void checkCost() {
        Assert.assertEquals(PageWithSettings.priceOnCalculatorPage, GenerateMailPage.priceOnGenerateMailPage, "Price on equals");
    }

    @AfterTest
    public void closeBrowser(){
    driver.quit();
    driver = null;
    }


}
