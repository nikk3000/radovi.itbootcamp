package zavrsniProjekat.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import zavrsniProjekat.pages.*;

import java.time.Duration;

public class Base {

    public static WebDriver wd;

    public static AllProducts allProducts;

    public static ContactUsForm contactUsForm;

    public static Home home;

    public static ProductDetails productDetails;

    public static SignupForm signupForm;

    public static SignupLogin signupLogin;

    public static ViewCart viewCart;

    public static WebDriverWait wait;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        wd = new ChromeDriver();
        allProducts = new AllProducts();
        contactUsForm = new ContactUsForm();
        home = new Home();
        productDetails = new ProductDetails();
        signupForm = new SignupForm();
        signupLogin = new SignupLogin();
        viewCart = new ViewCart();
        wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void mopUp(){
        wd.close();
        wd.quit();
    }

    public void scrollToElement(WebElement element){
        ((JavascriptExecutor)wd).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void waitForElementVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }



}
