package PageObjects;

import helpers.PageObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DemoQaRegPage extends PageObject {
    String randomString = RandomStringUtils.randomAlphanumeric(7);

    @FindBy(id = "name_3_firstname")
    private WebElement firstName;

    @FindBy(id = "name_3_lastname")
    private WebElement lastName;

    @FindBy(name = "radio_4[]")
    private List<WebElement> maritalStatus;

    @FindBy(name = "checkbox_5[]")
    private List<WebElement> hobby;

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

    @FindBy(xpath = "//*[@class='fieldset piereg_submit_button']/input")
    private WebElement submitButton;

    public DemoQaRegPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void enterName(String firstName, String lastName) {
        this.firstName.clear();
        this.firstName.sendKeys(firstName);

        this.lastName.clear();
        this.lastName.sendKeys(lastName);
    }

    public void selectMaritalStatus(String status) {
        List<WebElement> maritalSts = maritalStatus;
        int statusSize = maritalSts.size();

        for (int i = 0; i<statusSize; i++){
            String statusValue = maritalSts.get(i).getAttribute("value");
            if (statusValue.equals(status)){
                maritalSts.get(i).click();
            }
        }
    }

    public void selectHobby(String hby) {
        int hSize = hobby.size();
        for (int i=0;i<hSize;i++) {
            if (!hobby.get(i).isSelected()) {
                String hValue = hobby.get(i).getAttribute("value");
                if (hValue.equals(hby)) {
                    hobby.get(i).click();
                }
            }

        }
    }

    public void selectCountry(String cty) {
        Select countrySelect = new Select(country);
        countrySelect.selectByValue(cty);
    }

    public void selectDateOfBirth(String month, String day, String year) {
        Select dobM = new Select(dobMonth);
        Select dobD = new Select(dobDay);
        Select dobY = new Select (dobYear);
        dobM.selectByValue(month);
        dobD.selectByValue(day);
        dobY.selectByValue(year);
    }

    public void enterPhone(String number) {
        this.phoneNumber.sendKeys(number);
    }

    public void enterUserName() {
        this.userName.clear();
        String userN = firstName.getAttribute("value") + randomString;
        this.userName.sendKeys(userN);
    }

    public void enterEmail() {
        this.email.clear();
        String userN = firstName.getAttribute("value") + randomString + "@example.com";
        this.email.sendKeys(userN);
    }

    public void uploadProfilePic() {
        this.chooseFileBtn.sendKeys("D:\\yamaha_yzfr1_2010_1.jpg");
    }

    public void enterAboutYourself(String description) {
        this.aboutYourself.clear();
        this.aboutYourself.sendKeys(description);
    }

    public void enterPassword(String pwd) {
        this.password.clear();
        this.confirmPassword.clear();
        this.password.sendKeys(pwd);

        Boolean passwordStrong = new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElement(passwordStrIndicator,"Strong"));
        if (passwordStrong) {
            this.confirmPassword.sendKeys(pwd);
        }
    }

    public void clickSubmit() {
        Boolean passwordStrong = new WebDriverWait(driver, 10).until(ExpectedConditions
                .textToBePresentInElement(passwordStrIndicator,"Strong"));
        if (passwordStrong) {
            this.submitButton.click();
        }

    }

}

