package zavrsniProjekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.pages.Home;
import zavrsniProjekat.pages.SignupForm;
import zavrsniProjekat.pages.SignupLogin;
import java.time.Duration;

public class SignupAndLogin {

    private WebDriver wd;
    private Home home;
    private SignupLogin signupLogin;
    private SignupForm signupForm;


    @BeforeMethod
    public void configure(){
        System.setProperty("webdriver.chrome.driver",
               "D:\\QA\\webdrivers\\chrome\\chromedriver.exe");


        wd = new ChromeDriver();
        home = new Home(wd);
        signupLogin = new SignupLogin(wd);
        signupForm = new SignupForm(wd);

        wd.get("https://www.automationexercise.com/");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    }

    @Test
    public void createNewUser_expectedPass(){

        home.clickSignupLogin();
        Assert.assertEquals(signupLogin.confirmSignupTitle(), "new user signup!", "Signup title not displayed");
        signupLogin.enterSignupName("John Doe");
        signupLogin.enterSignupEmail("na77@na.com");
        signupLogin.clickSignup();
        Assert.assertEquals(signupForm.getSignupTitle(),"enter account information", "Signup form page title not displayed");
        signupForm.titleChoiceMr();
        signupForm.enterPassword("test_pass2");
        signupForm.setDobDay(1);
        signupForm.setDobMonth("January");
        signupForm.setDobYear(2001);
        signupForm.checkNewsletter();
        signupForm.checkPromotions();
        signupForm.enterFirstName("John");
        signupForm.enterLastName("Doe");
        signupForm.enterCompany("Evil Corp");
        signupForm.enterRequiredAddress("The biggest Blvd 9b");
        signupForm.enterAddress2("Random St 15");
        signupForm.setCountry("United States");
        signupForm.enterState("NY");
        signupForm.enterCity("NYC");
        signupForm.enterZipcode("10010");
        signupForm.enterMobileNo("0123456789");
        signupForm.clickCreateAccount();
        Assert.assertEquals(signupForm.getAccountCreatedTitle(), "account created!", "Account created title not displayed");
        signupForm.clickContinueBtn();
        assert (home.accountNameDisplay().contains("John Doe"));

    }

    @Test
    public void loginExistingUser_expectedPass(){

        home.clickSignupLogin();
        Assert.assertEquals (signupLogin.confirmLoginTitle(), "login to your account");
        signupLogin.enterLoginEmail("na17@na.com");
        signupLogin.enterLoginPassword("test_pass2");
        signupLogin.clickLogin();
        assert (home.accountNameDisplay().contains("John Doe"));
        home.clickLogoutBtn();
        Assert.assertEquals(signupLogin.confirmLoginTitle(), "login to your account");

    }

    @Test
    public void incorrectLoginCredentials_expectedFail () {

        home.clickSignupLogin();
        Assert.assertEquals(signupLogin.confirmLoginTitle(), "Login to your account", "The login banner is not displayed");
        signupLogin.enterLoginEmail("na@na.com");
        signupLogin.enterLoginPassword("test_pass2");
        signupLogin.clickLogin();
        Assert.assertTrue(signupLogin.incorrectLoginFlag().equals("Your email or password is incorrect!"), "The incorrect login creds popup is not displayed" );

    }

    @Test
    public void creatingANewAccountWithAnExistingEmail_expectedFail(){

        home.clickSignupLogin();
        Assert.assertEquals(signupLogin.confirmSignupTitle(), "New User Signup!", "The signup title is not displayed properly");
        signupLogin.enterSignupName("John Doe");
        signupLogin.enterSignupEmail("na9@na.com");
        signupLogin.clickSignup();
        Assert.assertEquals(signupLogin.incorrectSignupFlag(), "Email Address already exist!", "The incorrect signup flag is not displayed");

    }


    @AfterMethod
    public void closeWD(){
        wd.quit();
    }
}
