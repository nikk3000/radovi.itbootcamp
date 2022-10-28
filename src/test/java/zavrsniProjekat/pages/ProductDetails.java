package zavrsniProjekat.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zavrsniProjekat.base.Base;

public class ProductDetails extends Base {

    @FindBy(xpath = "/html/body/section/div/div/div[2]/div[2]/div[2]/div/h2")
    private WebElement productName;

    @FindBy(xpath = "//*[@id=\"name\"]")
    private WebElement reviewName;

    @FindBy(xpath = "//*[@id=\"email\"]")
    private WebElement reviewEmail;

    @FindBy(xpath = "//*[@id=\"review\"]")
    private WebElement reviewBody;

    @FindBy(xpath = "//*[@id=\"button-review\"]")
    private WebElement submitReviewBtn;

    @FindBy(xpath = "//*[@id=\"review-section\"]/div/div")
    private WebElement reviewSuccessAlert;



    public ProductDetails() {
        PageFactory.initElements(wd, this);
    }

    public String getProductName(){
        return productName.getText();
    }

    public void enterRevieweeName(String testName){
        reviewName.sendKeys(testName);
    }

    public void enterRevieweeEmail(String testEmail){
        reviewEmail.sendKeys(testEmail);
    }

    public void enterReviewTxt(String testReviewTxt){
        reviewBody.sendKeys(testReviewTxt);
    }

    public void clickSubmitReview(){
        ((JavascriptExecutor) wd)
                .executeScript("arguments[0].scrollIntoView(true)", submitReviewBtn);
        submitReviewBtn.click();
    }

    public String getReviewSuccessAlert(){
        WebDriverWait w = new WebDriverWait(wd, 10);
        w.until(ExpectedConditions.visibilityOf(reviewSuccessAlert));
        return reviewSuccessAlert.getText();
    }


}
