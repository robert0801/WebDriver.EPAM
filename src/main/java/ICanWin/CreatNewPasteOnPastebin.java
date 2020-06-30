package ICanWin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.function.Function;

public class CreatNewPasteOnPastebin extends AbstractClassForPastebin{
    private String areaName = "//textarea[@name='paste_code']";
    private String selectName = "//select[@name='paste_expire_date']";
    private String pasteName = "//input[@name='paste_name']";

    @FindBy (xpath = "//textarea[@name='paste_code']")
    private WebElement textAreaForNewPaste;

    @FindBy (xpath = "//select[@name='paste_expire_date']")
    private Select selectPasteExpiration;

    @FindBy (xpath = "//input[@name='paste_name']")
    WebElement pasteNameForNewPaste;

    public CreatNewPasteOnPastebin(WebDriver driver) {
        super(driver);
    }
    public CreatNewPasteOnPastebin enterCodeOnPastebin() {
        driver.get(webSite);
        textAreaForNewPaste = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(areaName)));
        driver.findElement(By.xpath(areaName));
        textAreaForNewPaste.sendKeys("Hello from WebDriver");
        return this;
    }

    public CreatNewPasteOnPastebin checkThe10Minutes() {
        selectPasteExpiration = new Select(driver.findElement(By.xpath(selectName)));
        selectPasteExpiration.selectByVisibleText("10 Minutes");
        return this;
    }

    public CreatNewPasteOnPastebin insertPasteName() {
        pasteNameForNewPaste = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(pasteName)));
        pasteNameForNewPaste.sendKeys("helloweb");
        return this;
    }

}


