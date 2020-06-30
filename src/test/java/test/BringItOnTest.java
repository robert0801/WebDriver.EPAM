package test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import BringItOn.*;

public class BringItOnTest {

    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup(){

        driver = new ChromeDriver();
    }
    @Test
    public void pasteOnPastebin() {
        new CreatNewPasteOnPastebin(driver)
                .enterCodeOnPastebin()
                .syntaxHighlighting()
                .checkThe10Minutes()
                .insertPasteNameAndCreatPaste();


        Assert.assertTrue(driver.findElement(By.xpath("//h1")).getText().equals("how to gain dominance among developers"),
                "Error in first check");
        Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Bash']")).getText().equals("Bash"),
                "Error in second check");
        Assert.assertTrue(driver.findElement(By.xpath("//ol")).getText().equals("git config --global user.name  \"New Sheriff in Town\"\n" +
                        "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                        "git push origin master --force"),
                "Error in third check");

    }

    @AfterTest(alwaysRun = true)
    public void closeBrowser(){
        driver.quit();
        driver = null;
    }
}
