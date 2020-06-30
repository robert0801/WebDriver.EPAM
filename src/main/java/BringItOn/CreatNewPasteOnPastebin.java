package BringItOn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreatNewPasteOnPastebin extends AbstractClassForPastebin{
    private String pasteName = "how to gain dominance among developers";
    private String areaName = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String selectPaste = "10 Minutes";
    private String syntaxName = "Bash";


    private String areaNameXPath = "//textarea[@name='paste_code']";
    private String selectNameXPath = "//select[@name='paste_expire_date']";
    private String pasteNameXPath = "//input[@name='paste_name']";
    private String syntaxHighlightingXPath = "//select[@name='paste_format']";

    @FindBy (xpath = "//textarea[@name='paste_code']")
    private WebElement textAreaForNewPaste;

    @FindBy (xpath = "//select[@name='paste_expire_date']")
    private Select selectPasteExpiration;

    @FindBy (xpath = "//select[@name='paste_expire_date']")
    private Select selectSyntaxHighlighting;

    @FindBy (xpath = "//input[@name='paste_name']")
    private WebElement pasteNameForNewPaste;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement creatNewPasteBtn;

    public CreatNewPasteOnPastebin(WebDriver driver) {
        super(driver);
    }
    public CreatNewPasteOnPastebin enterCodeOnPastebin() {
        driver.get(webSite);
        driver.findElement(By.xpath(areaNameXPath));
        textAreaForNewPaste.sendKeys(areaName);
        return this;
    }

    public CreatNewPasteOnPastebin syntaxHighlighting() {
        selectSyntaxHighlighting = new Select(driver.findElement(By.xpath(syntaxHighlightingXPath)));
        selectSyntaxHighlighting.selectByVisibleText(syntaxName);
        return this;
    }


    public CreatNewPasteOnPastebin checkThe10Minutes() {
        selectPasteExpiration = new Select(driver.findElement(By.xpath(selectNameXPath)));
        selectPasteExpiration.selectByVisibleText(selectPaste);
        return this;
    }

    public CreatNewPasteOnPastebin insertPasteNameAndCreatPaste() {
        pasteNameForNewPaste.sendKeys(pasteName);
        creatNewPasteBtn.click();
        return this;
    }

}