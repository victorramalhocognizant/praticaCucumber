package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    private WebDriver driver;
    private String searchBar = "//*[@id=\"APjFqb\"]";

    public GoogleHomePage(WebDriver driver){
        this.driver = driver;
    }
    
    public void open(){
        driver.get("https://www.google.com");
    }

    public void search(String keyword){
        driver.findElement(By.xpath(searchBar)).sendKeys(keyword);
        driver.findElement(By.xpath(searchBar)).sendKeys(Keys.ENTER);
    }

    public String getTitle(){
        return driver.getTitle();
    }
}
