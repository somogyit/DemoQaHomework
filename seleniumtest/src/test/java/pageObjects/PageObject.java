package pageObjects;

import helpers.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
    protected WebDriver webDriver;

    public PageObject(WebDriver webDriver){
        webDriver = Environment.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
    }
}
