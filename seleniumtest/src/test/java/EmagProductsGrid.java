import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EmagProductsGrid {

    private WebDriver webDriver;

    public EmagProductsGrid(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public List<ProductCard> getProducts(){
        List<ProductCard> productCards = new ArrayList<ProductCard>();
        List<WebElement> cards = webDriver.findElements(By.xpath("//div[@class='card']"));
        for (WebElement card:cards){
            productCards.add(new ProductCard(card));
        }
        return productCards;
    }


}
