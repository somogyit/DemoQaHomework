import entityModel.Product;
import helpers.Environment;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import pageObjects.SearchResultsPage;
import java.util.List;

/**
 * Created by rtomos on 12/12/2017.
 */
public class WebDriverTests {

    private WebDriver webDriver;
    Environment openDriver = Environment.getInstance();
    String browser = "chrome";
    String registerUrl = "http://demoqa.com/registration/";



    @Before
    public void init() {
        webDriver = openDriver.startDriver(browser, registerUrl);
        //webDriver.get("https://www.emag.ro/search/jucarii?ref=autosuggest");
    }



    @Test
    public void emagTestPageObjectFactory() {
        SearchResultsPage resultsPage=new SearchResultsPage();

        int productIndex=0;
        String testProduct="";
        for(Product product:resultsPage.getProductsOnCurrentPage()){
            if (!product.getOldPrice().equals(""))
                productIndex++;
            if (productIndex==1) {
                testProduct = product.getName();
                break;
            }

        }
        resultsPage.openProductPage(testProduct).addToCart()
                .goToCart();

    }

    @After
    public void cleanup() {
       // webDriver.quit();
    }
}
