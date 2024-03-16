package pages;


import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonHomePage {

    private WebDriver driver;

    // Locators
    private By searchInputLocator = By.xpath("//*[@id='twotabsearchtextbox']");
    private By firstProductLocator = By.xpath("//div[@data-index='3']");
    private By secondProductLocator = By.xpath("//div[@data-index='4']");

    // Constructor
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void enterProduct(String product) {
        WebElement productInput = driver.findElement(searchInputLocator);
        productInput.sendKeys(product);
        productInput.sendKeys(Keys.RETURN);
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }



    public void clickFirstProduct() {
        WebElement firstproduct = driver.findElement(firstProductLocator);
        String parentWindow= driver.getWindowHandle();
    
        firstproduct.click();
        try {
   			Thread.sleep(5000);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        
        Set <String> allWindows = driver.getWindowHandles();
        for(String curWindow : allWindows){
            driver.switchTo().window(curWindow);
        }
    }


    public void clickSecondProduct() {
        WebElement secondproduct = driver.findElement(secondProductLocator);
        String parentWindow= driver.getWindowHandle();
    
        secondproduct.click();
        try {
   			Thread.sleep(5000);
   		} catch (InterruptedException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   		}
        
        Set <String> allWindows = driver.getWindowHandles();
        for(String curWindow : allWindows){
            driver.switchTo().window(curWindow);
        }
    }
   

}
