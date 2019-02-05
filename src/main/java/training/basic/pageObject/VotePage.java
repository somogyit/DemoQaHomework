package training.basic.pageObject;

import common.CustomLogger;
import common.helper.ActionHelper;
import common.helper.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Home page which is the page displayed after user is logged in.
 * Home page contains the user header menu elements, therefore it
 * extends the UserHeaderMenu class.
 *
 * @author fapateanu
 */
public class VotePage {

    @FindBy(css = "#post-9619 > div:nth-child(2) > div > div > div.td-pb-span8.td-main-content > div > div.td-post-content.td-pb-padding-side > form > div > div > div.Total_Soft_Poll_1_Ans_Div_3 > div:nth-child(4) > label")
    private WebElement castVote;

    @FindBy(xpath = "//*[@id=\"Total_Soft_Poll_1_But_Vote_3\"]")
    private WebElement voteBtn;

    @FindBy(xpath = "//*[@id=\"post-9619\"]/div[2]/div/div/div[1]/div/div[3]/form/div/div/div[4]/div[2]/div[4]/label/span[3]")
    private WebElement result;


    protected ActionHelper driverActionHelper;
    protected WaitHelper driverWaitHelper;

    private Logger log;
    protected WebDriver driver;
    public VotePage(WebDriver driver) {
        log = CustomLogger.getInstance(LoginPage.class).getLogger();
        log.info("Initializing HomePage...");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driverActionHelper = ActionHelper.getInstance();
        driverWaitHelper = WaitHelper.getInstance();
        driverWaitHelper.waitForElementVisibility(castVote);
        log.info("Finished HomePage initialization");
    }

    public VotePage addVodte() {
        for (int i =0; i < 10; i++){
            castVote.click();
            voteBtn.click();
            driverWaitHelper.waitForElementVisibility(result);
//            driverWaitHelper.simpleWait(1000);
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        }
        return this;
    }


}
