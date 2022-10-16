package zavrsniProjekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.pages.ContactUsForm;
import zavrsniProjekat.pages.Home;
import zavrsniProjekat.pages.SignupForm;
import zavrsniProjekat.pages.SignupLogin;

import java.time.Duration;

public class ContactUs {

    private WebDriver wd;
    private Home home;
    private SignupLogin signupLogin;
    private SignupForm signupForm;

    private ContactUsForm contactUsForm;


    @BeforeMethod
    public void configure(){
        System.setProperty("webdriver.chrome.driver",
                "D:\\QA\\webdrivers\\chrome\\chromedriver.exe");


        wd = new ChromeDriver();
        home = new Home(wd);
        signupLogin = new SignupLogin(wd);
        contactUsForm = new ContactUsForm(wd);
        signupForm = new SignupForm(wd);

        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void contactUsForm_expectedPass(){
        home.clickContactUsBtn();
        Assert.assertEquals(contactUsForm.contactUsTitle(), "GET IN TOUCH", "The page title is not displayed properly");
        contactUsForm.enterName("John Doe");
        contactUsForm.enterEmail("na@na.com");
        contactUsForm.enterSubject("Review");
        contactUsForm.enterMessage("10/10 IGN");
        contactUsForm.uploadFile("C:\\Users\\Korisnik\\Downloads\\img1.jpg");
        contactUsForm.clickSubmit();
        wd.switchTo().alert().accept();
        Assert.assertEquals(contactUsForm.successfulSubmit(), "Success! Your details have been submitted successfully.", "The submit message has not been displayed properly");
        contactUsForm.clickHomeBtn();
        Assert.assertEquals( home.homeTitleFeaturedItems(), "FEATURES ITEMS", "Home didn't take you to the proper page");

    }

    @AfterMethod
    public void closeWD(){
        wd.quit();
    }
}
