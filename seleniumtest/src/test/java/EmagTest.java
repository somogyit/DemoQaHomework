import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.List;

public class EmagTest {
    private WebDriver webDriver;

//TODO separa locatorii
    //TODO

    @Before
    public void init() {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        webDriver = new ChromeDriver(options);
        webDriver.navigate().to("https://www.emag.ro/search/jucarii");
        webDriver.manage().window().maximize();
    }

    @Test
    public void scenario1(){
//       WebElement searchField = webDriver.findElement(By.xpath("//*[@id=\"searchboxTrigger\"]"));
//       searchField.sendKeys("casti audio");

        List<WebElement> cards = webDriver.findElements(By.xpath("//div[@class='card']"));
        WebElement productsWithDiscount=null;

        int index = 0;
        for (WebElement card:cards){
            String oldPriceText=card.findElement(By.xpath(".//p[@class='product-old-price']")).getText();
            if (!oldPriceText.trim().equals("")){
                index++;
            }
            if (index==2){
                productsWithDiscount=card;
                break;
            }
        }
    }

}
