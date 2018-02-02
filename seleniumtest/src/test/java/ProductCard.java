import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductCard{

    private WebElement card;

    public ProductCard(WebElement card) {

        this.card = card;
    }

    public WebElement oldPrice() {

        return card.findElement(By.xpath(".//p[@class='product-old-price']"));
    }

    public WebElement title() {

        return card.findElement(By.xpath(".//a[@class='product-title js-product-url']"));
    }
}
