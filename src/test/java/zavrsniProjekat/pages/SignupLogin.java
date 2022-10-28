package zavrsniProjekat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import zavrsniProjekat.base.Base;


public class SignupLogin extends Base {

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/h2")
    WebElement signupFormTitle;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")
    WebElement signupNameField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")
    WebElement signupEmailField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/button")
    WebElement signupBtn;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/h2")
    WebElement loginFormTitle;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")
    WebElement loginEmailField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")
    WebElement loginPasswordField;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/button")
    WebElement loginBtn;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    WebElement incorrectLoginFlag;

    @FindBy(xpath = "//*[@id=\"form\"]/div/div/div[3]/div/form/p")
    WebElement incorrectSignupFlag;

    public SignupLogin() {
        PageFactory.initElements(wd, this);

    }

    public String confirmSignupTitle(){
        return  signupFormTitle.getText();
    }

    public void enterSignupName(String testName){
        signupNameField.sendKeys(testName);
    }

    public void enterSignupEmail(String testEmail){
        signupEmailField.sendKeys(testEmail);
    }

    public void clickSignup(){
        signupBtn.click();
    }

    public String confirmLoginTitle(){
        return loginFormTitle.getText();
    }

    public void enterLoginEmail(String testEmail){
        loginEmailField.sendKeys(testEmail);
    }

    public void enterLoginPassword(String testPassword){
        loginPasswordField.sendKeys(testPassword);
    }

    public void clickLogin(){ loginBtn.click();}

    public String incorrectLoginFlag(){
        return incorrectLoginFlag.getText();
    }

    public String incorrectSignupFlag() {return incorrectSignupFlag.getText();}


}



