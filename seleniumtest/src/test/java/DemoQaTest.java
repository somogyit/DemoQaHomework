import helpers.Environment;
import org.junit.Before;
import org.junit.Test;
import pageObjects.DemoQaRegistrationPage;

public class DemoQaTest extends Environment {
    Environment openDriver = Environment.getInstance();
    String browser = "chrome";
    String registerUrl = "http://demoqa.com/registration/";



    @Before
    public void init() {
        webDriver = openDriver.startDriver(browser, registerUrl);
    }

    @Test
    public void RegisterTest(){
        DemoQaRegistrationPage dQRegPage = new DemoQaRegistrationPage();
        dQRegPage.enterName("Jozsef", "Pista");
        dQRegPage.selectMaritalStatus("Married");
//        dQRegPage.selectHobby("Dance");
    }
}
