package BringItOn;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract public class AbstractClassForPastebin {
    protected WebDriver driver;
    protected final String webSite = "https://pastebin.com";
    protected final int WAIT_TIMEOUT_SECONDS = 10;

    protected AbstractClassForPastebin(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
