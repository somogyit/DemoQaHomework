package pageObjects;

import helpers.Environment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class DemoQaRegistrationPage  {

    @FindBy(id = "name_3_firstname")
    private WebElement firstName;

    @FindBy(id = "name_3_lastname")
    private WebElement lastName;

    @FindBy(name = "radio_4[]")
    private WebElement maritalStatus;

    @FindBy(name = "checkbox_5[]")
    private WebElement hobby;

    @FindBy(id = "dropdown_7")
    private WebElement country;

    @FindBy(id = "mm_date_8")
    private WebElement dobMonth;

    @FindBy(id = "dd_date_8")
    private WebElement dobDay;

    @FindBy(id = "yy_date_8")
    private WebElement dobYear;

    @FindBy(id = "phone_9")
    private WebElement phoneNumber;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "email_1")
    private WebElement email;

    @FindBy(id = "profile_pic_10")
    private WebElement chooseFileBtn;

    @FindBy(id = "description")
    private WebElement aboutYourself;

    @FindBy(id = "password_2")
    private WebElement password;

    @FindBy(id = "confirm_password_password_2")
    private WebElement confirmPassword;

    @FindBy(id = "piereg_passwordStrength")
    private WebElement passwordStrIndicator;

    @FindBy(id = "pie_submit")
    private WebElement submitButton;

    public DemoQaRegistrationPage (){
        WebDriver webDriver = Environment.getInstance().getWebDriver();
        PageFactory.initElements(webDriver, this);
    }

    //TODO metoda de navigate to

    public void enterName (String firstName, String lastName){
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void selectMaritalStatus (String status){
//        List<WebElement> maritalSts = maritalStatus.findElements(By.name("radio_4[]"));
//        int statusSize = maritalSts.size();
//
//        for (int i = 0; i<statusSize; i++){
//            String statusValue = maritalSts.get(i).getAttribute("value");
//            if (statusValue.equals(status)){
//                maritalSts.get(i).click();
//            }
//        }
    }

    public void selectHobby (String hby){
//        List<WebElement> hbyCheckbox = hobby.findElements(By.name("checkbox_5[]"));
//        int hSize = hbyCheckbox.size();
//        for (int i=0;i<hSize;i++) {
//            String hValue = hbyCheckbox.get(i).getAttribute("value");
////            if (hValue.equals(hby)) {
////                hbyCheckbox.get(i).click();
////            }
//            if (hobby.isSelected()){
//                hobby.clear();
//                hobby.click();
//            }
//        }
    }

    public void selectCountry(){

    }

    public void selectDateOfBirth(){

    }

    public void enterPhone(){

    }

    public void enterUserName(){

    }

    public void enterEmail(){

    }

    public void uploadProfilePic(){

    }

    public void enterAboutYourself(){

    }

    public void enterPassword(){

    }

    public void clickSubmit(){

    }

}
