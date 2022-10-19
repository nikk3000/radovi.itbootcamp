package zavrsniProjekat.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.pages.*;
import java.time.Duration;


public class AllProducts {
        private WebDriver wd;
        private Home home;

        private ProductDetails productDetails;

        private zavrsniProjekat.pages.AllProducts allProductsPage;


        @BeforeMethod
        public void configure(){
            System.setProperty("webdriver.chrome.driver",
                    "D:\\QA\\webdrivers\\chrome\\chromedriver.exe");


            wd = new ChromeDriver();
            home = new Home(wd);
            productDetails = new ProductDetails(wd);
            allProductsPage = new zavrsniProjekat.pages.AllProducts(wd);

            wd.get("https://www.automationexercise.com/");
            wd.manage().window().maximize();
            wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        }

        @Test
        public void allProductsPage_expectedPass(){

            home.clickProductsBtn();
            Assert.assertEquals(allProductsPage.productsTitle(), "ALL PRODUCTS", "Incorrect title is displayed");
            allProductsPage.productCategoriesCheck();
            Assert.assertEquals(allProductsPage.categoryTitle(), "CATEGORY", "Category title is missing");
            Assert.assertEquals(allProductsPage.brandsTitle(), "BRANDS", "Brands title is missing");
            allProductsPage.productBrandsCheck();
            System.out.println("The number of products displayed is: " + allProductsPage.allProductsOnPageCount());

            }

        @Test
        public void viewProduct_expectedPass() {
            home.scrollToItem(2);
            String productName = home.getItemName(2);
            home.clickViewProductBtn(2);
            Assert.assertEquals(productName, productDetails.getProductName());
        }

        @Test
        public void reviewProduct_expectedPass(){
            viewProduct_expectedPass();
            productDetails.enterRevieweeName("John Doe");
            productDetails.enterRevieweeEmail("na@na.com");
            productDetails.enterReviewTxt("10/10 IGN");
            productDetails.clickSubmitReview();
            Assert.assertTrue(productDetails.getReviewSuccessAlert().equals("Thank you for your review."));

        }

        @AfterMethod
        public void closeWD(){
        wd.quit();
    }
}
