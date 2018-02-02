package pageObjects;

import helpers.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public abstract class EmagAbstractPage {

    protected WebDriver webDriver;

    public EmagAbstractPage(){
        webDriver= Environment.getInstance().getWebDriver();
        PageFactory.initElements(
                new AjaxElementLocatorFactory(webDriver, 15),
                this);
    }
}
