package pageObjects;

import entityModel.Product;
import helpers.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {

    private WebDriver webDriver;

    public SearchResultsPage(){
        webDriver=Environment.getInstance().getWebDriver();
       PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//div[@class='card']")
    private List<WebElement> products;

    public List<Product> getProductsOnCurrentPage(){
        List<Product> productEntities = new ArrayList<Product>();
        for (int i=0;i<5;i++){
        //for (WebElement productContainer:products){
            WebElement productContainer=products.get(i);
            Product product=new Product();
            product.setName(productContainer.findElement(By.xpath(".//*[@class='product-title js-product-url']")).getText());
            product.setPrice(productContainer.findElement(By.xpath(".//*[@class='product-new-price']")).getText());
            product.setOldPrice(productContainer.findElement(By.xpath(".//*[@class='product-old-price']")).getText());
            productEntities.add(product);
        }

        return productEntities;
    }

    public ProductPage openProductPage(String name) {
        webDriver.findElement(By.xpath("//a[@class='product-title js-product-url' and contains(text(),'"+name+"')]")).click();
        return new ProductPage();
    }
}
