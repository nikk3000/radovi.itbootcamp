package zavrsniProjekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ViewCart {

    WebDriver wd;

    @FindBy(xpath = "//*[@id=\"cart_info_table\"]/tbody")
    private WebElement cartTableBody;

    @FindBy(xpath = "//*[@id=\"product-1\"]/td[6]/a")
    private WebElement deleteFirstItemBtn;

    public ViewCart(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public int countTheNumberOfRows(){
        WebDriverWait w = new WebDriverWait(wd, 4);
        w.until(ExpectedConditions.visibilityOf(cartTableBody));
        List<WebElement> rows = cartTableBody.findElements(By.tagName("tr"));
        return rows.size();
    }

    public void deleteFirstItem(){
        deleteFirstItemBtn.click();
    }








}
