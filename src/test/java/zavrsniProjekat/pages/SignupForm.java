package zavrsniProjekat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import zavrsniProjekat.base.Base;

public class SignupForm extends Base {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/h2/b")
    private WebElement signupTitle;

    @FindBy(xpath = "//*[@id=\"id_gender1\"]")
    private WebElement mrRadio;

    @FindBy(xpath = "//*[@id=\"id_gender2\"]")
    private WebElement mrsRadio;

    @FindBy(xpath = "//*[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"days\"]")
    private WebElement dobDay;

    @FindBy(xpath = "//*[@id=\"months\"]")
    private WebElement dobMonth;

    @FindBy(xpath = "//*[@id=\"years\"]")
    private WebElement dobYear;

    @FindBy(xpath = "//*[@id=\"newsletter\"]")
    private WebElement newsletterCheck;

    @FindBy(xpath = "//*[@id=\"optin\"]")
    private WebElement promotionsCheck;

    @FindBy(xpath = "//*[@id=\"first_name\"]")
    private WebElement firstName;

    @FindBy(xpath = "//*[@id=\"last_name\"]")
    private WebElement lastName;

    @FindBy(xpath = "//*[@id=\"company\"]")
    private WebElement company;

    @FindBy(xpath = "//*[@id=\"address1\"]")
    private WebElement addressRequired;

    @FindBy(xpath = "//*[@id=\"address2\"]")
    private WebElement address2;

    @FindBy(xpath = "//*[@id=\"country\"]")
    private WebElement country;

    @FindBy(xpath = "//*[@id=\"state\"]")
    private WebElement state;

    @FindBy(xpath = "//*[@id=\"city\"]")
    private WebElement city;


    @FindBy(xpath = "//*[@id=\"zipcode\"]")
    private WebElement zipcode;

    @FindBy(xpath = "//*[@id=\"mobile_number\"]")
    private WebElement mobileNo;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/form/button")
    private WebElement createAccountBtn;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/h2/b")
    WebElement accountCreatedTitle;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div/div/a")
    WebElement continueBtn;

    public SignupForm() {
        PageFactory.initElements(wd, this);

    }

    public String getSignupTitle(){
        return signupTitle.getText().toLowerCase();
    }

    public void titleChoiceMr(){
        mrRadio.click();
    }

    public void enterPassword(String testPassword){
        new Actions(wd).moveToElement(password);
        password.sendKeys(testPassword);
    }

    public void setDobDay(int testDobDay){
        Select drpDobDay = new Select(dobDay);
        drpDobDay.selectByVisibleText(String.valueOf(testDobDay));
    }

    public void setDobMonth(String testDobMonth){
        Select drpDobMonth = new Select(dobMonth);
        drpDobMonth.selectByVisibleText(testDobMonth);
    }

    public void setDobYear(int testDobYear){
        Select drpDobYear = new Select(dobYear);
        drpDobYear.selectByVisibleText(String.valueOf(testDobYear));
    }

    public void checkNewsletter(){
        newsletterCheck.click();
    }

    public void checkPromotions(){
        promotionsCheck.click();
    }

    public void enterFirstName(String testFirstName){
        new Actions(wd).moveToElement(firstName);
        firstName.sendKeys(testFirstName);
    }

    public void enterLastName(String testLastName){
        lastName.sendKeys(testLastName);
    }

    public void enterCompany(String testCompany){
        company.sendKeys(testCompany);
    }

    public void enterRequiredAddress(String testAddressRequired){
        addressRequired.sendKeys(testAddressRequired);
    }

    public void enterAddress2(String testAddress2){
        address2.sendKeys(testAddress2);
    }

    public void setCountry(String testCountry){
        Select drpCountry = new Select(country);
        drpCountry.selectByVisibleText(testCountry);
    }

    public void enterState(String testState){
        state.sendKeys(testState);
    }

    public void enterCity(String testCity){
        new Actions(wd).moveToElement(city);
        city.sendKeys(testCity);
    }

    public void enterZipcode(String testZipcode){
        zipcode.sendKeys(testZipcode);
    }

    public void enterMobileNo(String testMobileNo){
        mobileNo.sendKeys(testMobileNo);
    }

    public void clickCreateAccount(){
        createAccountBtn.click();
    }

    public String getAccountCreatedTitle(){
        return accountCreatedTitle.getText().toLowerCase();
    }

    public void clickContinueBtn(){
        continueBtn.click();
    }


}
