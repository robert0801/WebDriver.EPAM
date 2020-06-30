package HurtMePlenty;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CloudHomePage extends AbstractClassPage{

    private String webSite = "https://cloud.google.com/";

    @FindBy(xpath = "//input[@name='q']")
    WebElement searchLineCloud;

    public CloudHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudSearchPage cloudStartPage() {
        driver.get(webSite);
        searchLineCloud.sendKeys("Google Cloud Platform Pricing Calculator");
        searchLineCloud.sendKeys(Keys.ENTER);
        return new CloudSearchPage(driver);
    }


}
