package pageObjects;

import entityModel.Product;
import helpers.Environment;
import org.apache.http.annotation.Obsolete;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends EmagAbstractPage{

    @FindBy(xpath = "//form[@class='main-product-form']//button[@type='submit']")
    private WebElement addToCartButton;

    @FindBy(id="navbar_sticky")
    private WebElement sticky;

    @FindBy(xpath = "//div[@class='modal-content']//a[text()='Vezi detalii cos']")
    private WebElement modalGoToCart;

    public ProductPage addToCart() {
        //Wait wait = new WebDriverWait(webDriver,30);
        JavascriptExecutor jse = (JavascriptExecutor)webDriver;
        jse.executeScript("window.scrollBy(0,400)");
        //wait.until(ExpectedConditions.visibilityOf(sticky));
        addToCartButton.click();
        return this;
    }

    public void goToCart(){

            modalGoToCart.click();
    }
}
