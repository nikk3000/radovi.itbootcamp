package zavrsniProjekat.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.base.Base;

public class ContactUs extends Base {

    @BeforeMethod
    public void configure(){
        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();

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

}
