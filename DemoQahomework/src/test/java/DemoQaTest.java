import PageObjects.DemoQaRegPage;
import helpers.Environment;
import org.junit.Test;

public class DemoQaTest extends Environment{
    @Test
    public void register() {
    driver.get("http://demoqa.com/registration/");
        DemoQaRegPage demoQaRegPage = new DemoQaRegPage(driver);
        demoQaRegPage.enterName("Isus", "Christos");
        demoQaRegPage.selectMaritalStatus("married");
        demoQaRegPage.selectHobby("dance");
        demoQaRegPage.selectHobby("cricket ");
        demoQaRegPage.selectCountry("Romania");
        demoQaRegPage.selectDateOfBirth("9", "3", "1989");
        demoQaRegPage.enterPhone("0712345678");
        demoQaRegPage.enterUserName();
        demoQaRegPage.enterEmail();
        demoQaRegPage.uploadProfilePic();
        demoQaRegPage.enterAboutYourself("Ala bala portocala");
        demoQaRegPage.enterPassword("Qwertasd123!@#qwe!");
        demoQaRegPage.clickSubmit();
    }
}
