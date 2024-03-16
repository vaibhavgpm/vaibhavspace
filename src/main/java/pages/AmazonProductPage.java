package pages;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonProductPage {

    private WebDriver driver;

    // Locators
    
  
    private By AddToCartButtonLocator = By.xpath("//input[@id='add-to-cart-button']");


    // Constructor
    public AmazonProductPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    


    public void clickAddToCartonProductDetailsPage() {
    	
        WebElement AddToCartButton = driver.findElement(AddToCartButtonLocator);
        AddToCartButton.click();
        
        try {
   			Thread.sleep(10000);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
    }

}
