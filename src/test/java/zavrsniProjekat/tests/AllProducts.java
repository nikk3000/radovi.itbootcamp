package zavrsniProjekat.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.base.Base;


public class AllProducts extends Base {

        @BeforeMethod
        public void configure(){
            wd.get("https://www.automationexercise.com/");
            wd.manage().window().maximize();

        }

        @Test
        public void allProductsPage_expectedPass(){

            home.clickProductsBtn();
            Assert.assertEquals(allProducts.productsTitle(), "ALL PRODUCTS", "Incorrect title is displayed");
            allProducts.productCategoriesCheck();
            Assert.assertEquals(allProducts.categoryTitle(), "CATEGORY", "Category title is missing");
            Assert.assertEquals(allProducts.brandsTitle(), "BRANDS", "Brands title is missing");
            allProducts.productBrandsCheck();
            System.out.println("The number of products displayed is: " + allProducts.allProductsOnPageCount());

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

}
