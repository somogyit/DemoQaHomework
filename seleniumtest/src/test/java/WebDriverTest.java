import helpers.Environment;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

//TODO check error messages on each field
//TODO test password indicator + color
//TODO implicit wait
//TODO alert windows
//TODO iframe
//TODO actions (drag and drop, hold, etc.)

//TODO Emag, cauta o categorie (ex: lego), alegi un produs cu reducere (not hardoced), adauga in cos, verifica pretul de pe iframe
//TODO dai pe verifica cos, verifici pretul din cos again sa fie ca pe site in momentul cand ai ales produsul

public class WebDriverTest {
    private WebDriver webDriver;
    String randomString = RandomStringUtils.randomAlphanumeric(7);
    Environment openDriver = Environment.getInstance();
    String browser = "chrome";
    String registerUrl = "http://demoqa.com/registration/";

    @Before
    public void init(){
        webDriver = openDriver.startDriver(browser, registerUrl);
    }




    public void fillMaritalStatus (String status){ //make status as enum
        //TODO fill marital status radio button
        List<WebElement> maritalSts = webDriver.findElements(By.name("radio_4[]"));
        int statusSize = maritalSts.size();

        for (int i = 0; i<statusSize; i++){
            String statusValue = maritalSts.get(i).getAttribute("value");
            if (statusValue.equals(status)){
                maritalSts.get(i).click();
            }
        }
    }
//TODO verifica intai statusul checkboxului si check doar daca-i unchecked
    public void checkHobby (String hobby){
        List<WebElement> hbyCheckbox = webDriver.findElements(By.name("checkbox_5[]"));
        int hSize = hbyCheckbox.size();
        for (int i=0;i<hSize;i++) {
            String hValue = hbyCheckbox.get(i).getAttribute("value");
            if (hValue.equals(hobby)) {
                hbyCheckbox.get(i).click();
            }
        }
    }
    public void uncheckHobby (String uHobby) {
        List<WebElement> unCheckH = webDriver.findElements(By.name("checkbox_5[]"));
        int uncheckSize = unCheckH.size();

        for (int i = 0; i < uncheckSize; i++) {
            String hValue = unCheckH.get(i).getAttribute("value");
            if (unCheckH.get(i).isSelected()){
             if (hValue.equals(uHobby)) {
                unCheckH.get(i).click();
                }
            }
        }
    }


    @Test
    public void happyFlow() throws InterruptedException {

        WebElement firstName = webDriver.findElement(By.id("name_3_firstname"));
        WebElement lastName = webDriver.findElement(By.xpath("//*[@id=\"name_3_lastname\"]"));
        WebElement month = webDriver.findElement(By.id("mm_date_8"));
        WebElement day = webDriver.findElement(By.id("dd_date_8"));
        WebElement year = webDriver.findElement(By.id("yy_date_8"));
        WebElement phone = webDriver.findElement(By.id("phone_9"));
        WebElement usrName = webDriver.findElement(By.id("username"));
        WebElement eMail = webDriver.findElement(By.id("email_1"));
        WebElement uploadBtn = webDriver.findElement(By.id("profile_pic_10"));
        WebElement description = webDriver.findElement(By.id("description"));
        WebElement passwd = webDriver.findElement(By.id("password_2"));
        WebElement confirmPwd = webDriver.findElement(By.id("confirm_password_password_2"));
        WebElement pwdStr = webDriver.findElement(By.id("piereg_passwordStrength"));
        WebElement submitBtn = webDriver.findElement(By.name("pie_submit"));


        //first name
        firstName.sendKeys("Laci");

        Assert.assertTrue("first name is displayed",firstName.isDisplayed());
        Assert.assertThat("first name",firstName.getAttribute("value"),is("Laci"));

        //last name
        lastName.sendKeys("Bacsi");

        Assert.assertTrue("last name displayed",lastName.isDisplayed());
        Assert.assertThat("last name",lastName.getAttribute("value"),is("Bacsi"));

        //marital status
        fillMaritalStatus("single");

        //hobby
//        checkHobby("cricket ");
        checkHobby("dance");
//        uncheckHobby("dance");
        uncheckHobby("cricket ");

        //country
        WebElement countryDropd = webDriver.findElement(By.id("dropdown_7"));
        Select countrySelect = new Select(countryDropd);
        countrySelect.selectByValue("Romania");
        Assert.assertTrue("country",countryDropd.getText().contains("Romania"));

        //Date of Birth
        //month
        month.sendKeys("3");
        Assert.assertThat("Dob month",month.getAttribute("value"),is("3"));
        //day
        day.sendKeys("27");
        Assert.assertThat("Dob day",day.getAttribute("value"),is("27"));
        //year
        year.sendKeys("1989");
        Assert.assertThat("Dob year",year.getAttribute("value"),is("1989"));

        //phone number
        phone.sendKeys("0712345678");
        Assert.assertThat("phone number",phone.getAttribute("value"),is("0712345678"));

        //username

       // usrName.sendKeys("Laci6");
        usrName.sendKeys("Laci" + randomString);
        Assert.assertThat("username",usrName.getAttribute("value"),is("Laci" + randomString));

        //email
        eMail.sendKeys("laci"+randomString+"@example.com");
        Assert.assertThat("username",eMail.getAttribute("value"),is("laci"+randomString+"@example.com"));

        //upload button
        uploadBtn.sendKeys("D:\\yamaha_yzfr1_2010_1.jpg");
        Assert.assertTrue("upload pic btn",uploadBtn.isDisplayed());

        //description
        description.sendKeys("Something about myself");
        Assert.assertThat("description",description.getAttribute("value"),is("Something about myself"));

        //password
//        Thread.sleep(2000);
        passwd.sendKeys("Qwertasd123!@#qwe!");

        //confirm password
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("piereg_passwordStrength")));
        confirmPwd.sendKeys("Qwertasd123!@#qwe!");
        Assert.assertTrue(myDynamicElement.isDisplayed());
        //password strength
        String passStr = pwdStr.getText();
        Assert.assertThat("password strength", passStr, is("Strong"));

        //submit button
//        Thread.sleep(2000);

      //  submitBtn.click();


        //success message
//        WebElement successMsg = webDriver.findElement(By.className("piereg_message"));
//        WebElement successMsg = webDriver.findElement(By.xpath("//*[@id=\"post-49\"]/div/p"));

//        WebElement myDynamicElement2 = (new WebDriverWait(webDriver, 10))
//                .until(ExpectedConditions.presenceOfElementLocated(By.className("piereg_message")));

//        Assert.assertTrue("successful registration msg",successMsg.isDisplayed());
//        Assert.assertThat(successMsg.getText(),is("Thank you for your registration"));

    }

    @Test
    public void sadFlow() throws InterruptedException {
//TODO cauta mesaje de eroare prin xpath relativ
        WebElement firstName = webDriver.findElement(By.id("name_3_firstname"));
        WebElement lastName = webDriver.findElement(By.xpath("//*[@id=\"name_3_lastname\"]"));
        WebElement month = webDriver.findElement(By.id("mm_date_8"));
        WebElement day = webDriver.findElement(By.id("dd_date_8"));
        WebElement year = webDriver.findElement(By.id("yy_date_8"));
        WebElement phone = webDriver.findElement(By.id("phone_9"));
        WebElement usrName = webDriver.findElement(By.id("username"));
        WebElement eMail = webDriver.findElement(By.id("email_1"));
        WebElement uploadBtn = webDriver.findElement(By.id("profile_pic_10"));
        WebElement description = webDriver.findElement(By.id("description"));
        WebElement passwd = webDriver.findElement(By.id("password_2"));
        WebElement confirmPwd = webDriver.findElement(By.id("confirm_password_password_2"));
        WebElement pwdStr = webDriver.findElement(By.id("piereg_passwordStrength"));
        WebElement submitBtn = webDriver.findElement(By.name("pie_submit"));

        happyFlow();
        firstName.clear();
        submitBtn.click();

        WebElement firstNameError = webDriver.findElement(By.xpath("//*[@id=\"pie_register\"]/li[1]"));
        Assert.assertTrue(firstNameError.getText().contains("* This field is required"));
//        List<WebElement> regForm = webDriver.findElements(By.xpath("//*[@id=\"pie_register\"]"));
    }
        @After
        public void cleanup () {
//        webDriver.quit();
        }
    }
