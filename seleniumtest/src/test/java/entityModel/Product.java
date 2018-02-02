package entityModel;

import org.openqa.selenium.WebElement;

import java.util.List;

public class Product {
    private String name;
    private String price;
    private String oldPrice;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPrice() {
        return price;
    }

    public void setOldPrice(String oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getOldPrice() {
        return oldPrice;
    }
}
