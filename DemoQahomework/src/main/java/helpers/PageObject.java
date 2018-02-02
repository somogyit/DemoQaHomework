package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver driver;

    public PageObject(org.openqa.selenium.WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
}
