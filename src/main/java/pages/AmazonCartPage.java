package pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonCartPage {

    private WebDriver driver;

 
    private By CartButtonLocator = By.xpath("//*[@id='attach-sidesheet-view-cart-button']//input");

    private By itemPriceLocator = By.xpath("//*[@class='sc-badge-price-to-pay']");
  
    private By SubTotalPriceLocator = By.xpath("//*[@id='sc-subtotal-amount-activecart']");
    
    

    // Constructor
    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
    }





    public void clickCartButton()
    {
    	WebElement CartButton = driver.findElement(CartButtonLocator);
    	CartButton.click();
    }




    public String getItemPrice(){
        String itemPrice = driver.findElement(itemPriceLocator).getText();
        System.out.println(itemPrice);
       return itemPrice;
    }
    
    public String getSubTotalPrice(){
        String SubTotalPrice = driver.findElement(SubTotalPriceLocator).getText();
        System.out.println(SubTotalPrice);
       return SubTotalPrice;
    }

    public double getAllItemsPrice(){
        List <WebElement> itemPrice = driver.findElements(itemPriceLocator);
        ArrayList <String> price = new ArrayList <String> ();
        
        for (WebElement e : itemPrice)
        {
        	price.add(e.getText());
        	
        }
        System.out.println(price);
        
        String p1=price.get(0).trim().replace(",","");
        String p2=price.get(1).trim().replace(",","");        
        
        System.out.println(p1);
        System.out.println(p2);
        
        double num1 = Double.parseDouble(p1);
        double num2 = Double.parseDouble(p2);
        
        
        System.out.println(num1);
        System.out.println(num2);
        
       double totalprice=num1+num2;
       System.out.println(totalprice);
        
       return totalprice;
    }

}
