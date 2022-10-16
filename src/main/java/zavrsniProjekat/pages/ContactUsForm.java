package zavrsniProjekat.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsForm {
    WebDriver wd;

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2")
    private WebElement getInTouchTitle;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[1]/input")
    private WebElement name;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[2]/input")
    private WebElement email;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[3]/input")
    private WebElement subject;

    @FindBy(xpath = "//*[@id=\"message\"]")
    private WebElement messageField;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[5]/input")
    private WebElement uploadFile;

    @FindBy(xpath = "//*[@id=\"contact-us-form\"]/div[6]/input")
    private WebElement submitBtn;

    @FindBy(xpath = "//*[@id=\"contact-page\"]/div[2]/div[1]/div/div[2]")
    private WebElement submittedPopup;

    @FindBy(xpath = "//*[@id=\"form-section\"]/a")
    private WebElement homeBtn;

    public ContactUsForm(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public String contactUsTitle(){
        return  getInTouchTitle.getText();
    }

    public void enterName(String testName){
        name.sendKeys(testName);
    }

    public void enterEmail(String testEmail){
        email.sendKeys(testEmail);
    }

    public void enterSubject(String testSubject){
        subject.sendKeys(testSubject);
    }

    public void enterMessage(String testMessage){
        messageField.sendKeys(testMessage);
    }

    public void uploadFile(String testImg){
        uploadFile.sendKeys(testImg);
    }

    public void clickSubmit(){
        submitBtn.click();
    }

    public String successfulSubmit(){
        return submittedPopup.getText();
    }

    public void clickHomeBtn(){
        homeBtn.click();
    }

}
