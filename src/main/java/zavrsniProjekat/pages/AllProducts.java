package zavrsniProjekat.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class AllProducts {

    private WebDriver wd;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[2]/div/h2")
    WebElement productsTitle;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/h2")
    WebElement categoryTitle;

    @FindBy(xpath = "//*[@id=\"accordian\"]")
    WebElement categoryBox;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[2]/h2")
    WebElement brandsTitle;

    @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[2]/div")
    WebElement brandsBox;








    public AllProducts(WebDriver wd) {
        this.wd = wd;
        PageFactory.initElements(this.wd, this);
    }

    public String productsTitle(){
        return productsTitle.getText();
    }

    public String categoryTitle(){
        return categoryTitle.getText();
    }

    public String productCategories(){
        return categoryBox.getText();
    }

    public void productCategoriesCheck(){
        ArrayList<String> categories = new ArrayList<>();
        categories.add("WOMEN");
        categories.add("MEN");
        categories.add("KIDS");
        for(String s : categories){
            assert (productCategories().contains(s));
        }
    }

    public String brandsTitle(){
        return brandsTitle.getText();
    }

    public String brandsCategories(){
        new Actions(wd).moveToElement(brandsBox);
        return brandsBox.getText();
    }

    public void productBrandsCheck(){
        ArrayList<String> brands = new ArrayList<>();
        brands.add("POLO");
        brands.add("H&M");
        brands.add("MADAME");
        brands.add("MAST & HARBOUR");
        brands.add("BABYHUG");
        brands.add("ALLEN SOLLY JUNIOR");
        brands.add("KOOKIE KIDS");
        brands.add("BIBA");
        for(String s : brands){
            assert (brandsCategories().contains(s));
        }
    }


    public int allProductsOnPageCount(){
       return wd.findElements(By.className("col-sm-4")).size();
    }


    }

