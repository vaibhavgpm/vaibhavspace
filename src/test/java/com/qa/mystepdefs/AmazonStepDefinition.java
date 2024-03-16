package com.qa.mystepdefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonProductPage;

public class AmazonStepDefinition {

    private WebDriver driver;
    private AmazonHomePage homePage;
    private AmazonCartPage cartPage;
    private AmazonProductPage productPage;

    @Before
    public void setup(){
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        if(driver!=null){
            driver.quit();
        }
    }

      
    @Given("I am on the Amazon Home page")
    public void i_am_on_the_Amazon_Home_page() {
        driver.get("https://www.amazon.co.in");
        driver.manage().window().maximize();
        homePage = new AmazonHomePage(driver);
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }



    @When("I have entered product {string} and press enter")
    public void i_have_entered_product_and_press_enter(String product) {
        homePage.enterProduct(product);
       
    }
    
    @Then("I select and click first item of the list")
    public void I_select_and_click_first_item_of_the_list()
    {
    	  homePage.clickFirstProduct();
    	  
    	  productPage = new AmazonProductPage(driver);
    }
    
    @Then("I select and click second item of the list")
    public void I_select_and_click_second_item_of_the_list()
    {
    	  homePage.clickSecondProduct();
    	  
    	  productPage = new AmazonProductPage(driver);
    }
    
    
    @Then ("Add the item to cart by clicking on Add to Cart on Products details Page")
    public void Add_the_item_to_cart_by_clicking_on_Add_to_Cart_on_Products_details_Page()
    {
    	productPage.clickAddToCartonProductDetailsPage();
    	 cartPage = new AmazonCartPage(driver);
    }

    @Then("click on cart to open cart page")
    public void click_on_cart_to_open_cart_page() 
    {
    	cartPage.clickCartButton();
    }






    @Then("verify that item price and sub total price are same")
    public void verify_that_item_price_and_sub_total_price_are_same() {
       
    	String ip=cartPage.getItemPrice().trim();
    	System.out.println(ip);
    	
    	String tp=cartPage.getSubTotalPrice().trim();
    	System.out.println(tp);
    	
        Assert.assertEquals(ip,tp);
    }
    
    @Then("verify that item price and sub total price are calculated correctly")
    public void verify_that_item_price_and_sub_total_price_are_calculated_correctly()
    {
     	double ip=cartPage.getAllItemsPrice();
    	System.out.println(ip);
    	
    	String tp=cartPage.getSubTotalPrice().trim().replace(",","");
    	double db=Double.parseDouble(tp);
    	System.out.println(db);
    	
        Assert.assertEquals(ip,db);
    }
}

