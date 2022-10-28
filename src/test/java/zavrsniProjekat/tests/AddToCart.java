package zavrsniProjekat.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import zavrsniProjekat.base.Base;

public class AddToCart extends Base {

    @BeforeMethod
    public void configure(){
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

}
