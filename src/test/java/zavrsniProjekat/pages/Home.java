package zavrsniProjekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import zavrsniProjekat.base.Base;


public class Home extends Base {
        private Actions action;

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
        private WebElement signupLoginBtn;

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]")
        private WebElement accountLoginDisplay;

        @FindBy(xpath = "//button [text() = 'Delete]")
        private WebElement deleteAccountBtn;

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")
        private WebElement logoutBtn;

        @FindBy(css = ".fa.fa-envelope")
        private WebElement contactUsBtn;

        @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div[1]/h2")
        private WebElement homeTitleFeatured;

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a")
        private WebElement productsBtn;

        @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
        private WebElement cartBtn;

        @FindBy(id = "susbscribe_email")
        private WebElement subscriptionField;

        @FindBy(id = "subscribe")
        private WebElement subscriptionBtn;

        @FindBy(id = "footer")
        private WebElement footer;

        @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[1]")
        private WebElement addedToCartTitle;

        @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[3]/button")
        private WebElement continueShoppingBtn;

        @FindBy(xpath = "//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a")
        private WebElement viewCartBtn;



        public Home() {
                PageFactory.initElements(wd, this);
                action = new Actions(wd);
        }

        public void clickSignupLogin(){
                signupLoginBtn.click();
        }

        public String accountNameDisplay(){
                return accountLoginDisplay.getText();
        }

        public void clickDeleteAccountBtn(){
                deleteAccountBtn.click();
        }

        public void clickLogoutBtn(){
                logoutBtn.click();
        }

        public void clickContactUsBtn(){ contactUsBtn.click();}

        public String homeTitleFeaturedItems(){
                return homeTitleFeatured.getText();
        }

        public void clickProductsBtn(){
                productsBtn.click();
        }

        public void clickCartBtn(){
                cartBtn.click();
        }

        public void scrollToTheBottomOfThePage(){
                ((JavascriptExecutor) wd)
                        .executeScript("window.scrollTo(0, document.body.scrollHeight)");
        }

        public String subscriptionTitle(){
                return footer.getText();
        }

        public void enterSubscriptionEmail(String testEmail){
                subscriptionField.sendKeys(testEmail);
        }

        public void clickSubscriptionBtn(){
                subscriptionBtn.click();
        }

        public String subscriptionConfirmation(){
               return footer.getText();
        }

        public void clickViewCartAfterAddingItem() {
                waitForElementClickability(viewCartBtn);
        }

        public void clickContinueShopping(){
                continueShoppingBtn.click();
        }

        public String addedToCartTitle(){
                waitForElementVisibility(addedToCartTitle);
                return addedToCartTitle.getText();
        }

        private WebElement getItem(int itemNo) {
                if (itemNo < 2 || itemNo > 35) {
                        throw new IllegalArgumentException(String.format("The dress number %d is not available", itemNo));
                }
                return wd.findElement(By.xpath("/html[1]/body[1]/section[2]/div[1]/div[1]/div[2]/div[1]/div[" + itemNo + "]"));
        }

        public void scrollToItem(int itemNo) {
                scrollToElement(getItem(itemNo));

        }
        public void hoverOverItem(int itemNo) {
                Actions actions = new Actions(wd);
                actions.moveToElement(getItem(itemNo)).perform();
        }

        //region addToCart
        private WebElement addItemToCartBtn(int itemNo){
                if (itemNo < 2 || itemNo > 35) {
                        throw new IllegalArgumentException(String.format("The dress number %d is not available", itemNo));
                }
                return wd.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div["+ itemNo +"]/div/div[1]/div[2]/div/a/i"));
        }

        public void addItemToCart(int itemNo) {
                waitForElementClickability(addItemToCartBtn(itemNo));
        }
        //endregion addtoCart


        //region getItemName
        public String getItemName(int itemNo) {
                if (itemNo < 2 || itemNo > 35) {
                        throw new IllegalArgumentException(String.format("The dress number %d is not available", itemNo));
                }
                return wd.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div["+ itemNo +"]/div/div[1]/div[1]/p")).getText();
        }

        //endregion getItemName


        //region viewProductBtn

        public void clickViewProductBtn(int itemNo) {
                if (itemNo < 2 || itemNo > 35) {
                        throw new IllegalArgumentException(String.format("The dress number %d is not available", itemNo));
                }
                wd.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[" + itemNo + "]/div/div[2]/ul/li/a")).click();
        }

        //endregion viewProductBtn




}
