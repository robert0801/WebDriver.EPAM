package HardCore;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;

public class PageWithSettings extends AbstractForCloudGoogle{

    static ArrayList<String> tab;
    public static Double priceOnCalculatorPage;

    public PageWithSettings(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[contains(@ng-model,'quantity')]")
    WebElement numberOfInstances;

    @FindBy(xpath = "//label[text()='Operating System / Software']/../md-select")
    WebElement listOperatingSystem;

    @FindBy(xpath = "//md-option[@value='free']")
    WebElement freeOperatingSystem;

    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    WebElement listMachineClass;

    @FindBy(xpath = "//md-select-menu[@style=contains(text(), '')]/descendant::md-option[@value='regular']")
    WebElement regularMachineClass;

    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    WebElement listMachineType;

    @FindBy(xpath = "//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']")
    WebElement n1Standard8MachineType;

    @FindBy(xpath = "//*[contains(@ng-model,'GPU')]")
    WebElement addGPU;

    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    WebElement listNumberOfGPU;

    @FindBy(xpath = "//div[normalize-space()='1']/parent::md-option")
    WebElement checkNumberOfGPU;

    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    WebElement listGPUType;

    @FindBy(xpath = "//md-option[@value='NVIDIA_TESLA_V100']")
    WebElement checkGPUType;

    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    WebElement listLocalSSD;

    @FindBy(xpath = "//div[normalize-space()='2x375 GB']/parent::md-option")
    WebElement localSSD;

    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    WebElement listDatacenterLocation;

    @FindBy(xpath = "//md-select-menu[@class='md-overflow']/descendant::div[contains(text(), 'Frankfurt')]/parent::md-option")
    WebElement frankfurtDatacenterLocation;

    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    WebElement listCommittedUsage;

    @FindBy(xpath = "//md-select-menu[contains(@style, 'transform-origin')]//div[text()='1 Year']/parent::md-option")
    WebElement yearCommittedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    WebElement buttonAddToEstimate;

    @FindBy(xpath = "//button[@id='email_quote']")
    WebElement buttonEmailEstimate;

    @FindBy(xpath = "//input[@type='email']")
    WebElement buttonInputMail;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement buttonSendEmail;


    public PageWithSettings checkNumberOfInstances(){

        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitForVisibility(numberOfInstances);
        numberOfInstances.sendKeys("4");
        return this;
    }

    public PageWithSettings checkOperatingSystem(){
        click(listOperatingSystem);
        click(freeOperatingSystem);

        return this;
    }

    public PageWithSettings checkMachineClass(){
        click(listMachineClass);
        click(regularMachineClass);
        return this;
    }

    public PageWithSettings checkMachineType(){
        click(listMachineType);
        click(n1Standard8MachineType);

        return this;
    }

    public PageWithSettings checkAddGPU(){
        click(addGPU);
        click(listNumberOfGPU);
        click(checkNumberOfGPU);
        click(listGPUType);
        click(checkGPUType);

        return this;
    }

    public PageWithSettings checkLocalSSD(){
        click(listLocalSSD);
        click(localSSD);

        return this;
    }

    public PageWithSettings checkDatacenterLocation(){
        click(listDatacenterLocation);
        click(frankfurtDatacenterLocation);

        return this;
    }

    public PageWithSettings checkCommittedUsage(){
        click(listCommittedUsage);
        click(yearCommittedUsage);
        return this;
    }

    public PageWithSettings addToEstimate(){
        click(buttonAddToEstimate);
        return this;
    }

    public PageWithSettings emailEstimate(){
        click(buttonEmailEstimate);
        return this;
    }

    public PageWithSettings createNewTab(){
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tab = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tab.get(1));
        return this;
    }

    public PageWithSettings checkInputMail(){
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        waitForVisibility(buttonInputMail);
        buttonInputMail.sendKeys(GenerateMailPage.generateMail);
        return this;
    }

    public PageWithSettings checkSendEmail(){
        click(buttonSendEmail);
        return this;
    }

    public void getPriceInCalculator(){
        driver.switchTo().window(tab.get(0));
        driver.switchTo().frame(0);
        driver.switchTo().frame("myFrame");
        WebElement priceCalculator = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//md-card-content[@id='resultBlock']//div/b[contains(text(),Total)]")));

        String s = priceCalculator
                .getText()
                .replace("1 month","")
                .replaceAll("[^0-9.]", "");

        priceOnCalculatorPage = Double.parseDouble(s);

    }



    public WebElement waitForVisibility(WebElement element){
        new WebDriverWait(driver, 20)
                .until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void click(WebElement element){
        waitForVisibility(element);
        element.sendKeys(Keys.ENTER);
    }




}
