import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TeamExplorerTest {
    private WebDriver driver;
    @Before
    public void init(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://team.endava.com/#/start/agile");
    }

    @Test
    public void inputTest(){

    WebElement inputField = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
    inputField.sendKeys("test");
    System.out.print(inputField.getText());
        Assert.assertTrue(inputField.getText().contains("test"));
        //se poate extrage text din imput cu javascript
    }
}
