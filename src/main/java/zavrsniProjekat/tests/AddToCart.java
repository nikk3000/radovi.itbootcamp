package zavrsniProjekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.pages.AllProducts;
import zavrsniProjekat.pages.Home;
import zavrsniProjekat.pages.ViewCart;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddToCart {

    private WebDriver wd;
    private Home home;

    private ViewCart viewCart;


    private AllProducts allProducts;


    @BeforeMethod
    public void configure(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\QA\\webdrivers\\chrome\\chromedriver.exe");


        wd = new ChromeDriver();
        home = new Home(wd);
        viewCart = new ViewCart(wd);
        allProducts = new AllProducts(wd);

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();
    }

    @Test
    public void addMultipleItemsIntoCart_expectedPass(){

        home.scrollToItem(2);
        home.hoverOverItem(2);
        home.addItemToCart(2);
        Assert.assertEquals(home.addedToCartTitle(), "Your product has been added to cart.", "Added to cart has not been displayed");
        home.clickContinueShopping();
        home.scrollToItem(3);
        home.hoverOverItem(3);
        home.addItemToCart(3);
        Assert.assertEquals(home.addedToCartTitle(), "Your product has been added to cart.", "Added to cart has not been displayed");
        home.clickViewCartAfterAddingItem();
        Assert.assertEquals(viewCart.countTheNumberOfRows(), 2, "The number of rows do not match the number of items");
    }

    @Test
    public void deleteItemFromCart_expectedPass() throws InterruptedException {

        addMultipleItemsIntoCart_expectedPass();
        viewCart.deleteFirstItem();
        Thread.sleep(3000); //no other wait solution worked. had to wait until the page reloads
        Assert.assertEquals(viewCart.countTheNumberOfRows(), 1, "The number of rows do not match the number of items");

    }


    @AfterMethod
    public void closeWD(){
        wd.quit();
    }
}
