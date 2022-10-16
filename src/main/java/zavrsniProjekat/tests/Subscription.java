package zavrsniProjekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.pages.Home;


import java.time.Duration;

public class Subscription {

    private WebDriver wd;
    private Home home;


    @BeforeMethod
    public void configure() {
        System.setProperty("webdriver.chrome.driver",
                "D:\\QA\\webdrivers\\chrome\\chromedriver.exe");


        wd = new ChromeDriver();
        home = new Home(wd);


        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @Test
    public void subscriptionOnHome_expectedPass(){
        home.scrollToTheBottomOfThePage();
        assert (home.subscriptionTitle().contains("SUBSCRIPTION"));
        home.enterSubscriptionEmail("na@na.com");
        home.clickSubscriptionBtn();
        assert (home.subscriptionConfirmation().contains("You have been successfully subscribed!"));

    }

    @AfterMethod
    public void closeWD(){
        wd.quit();
    }

}
