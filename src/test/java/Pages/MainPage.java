package Pages;

import StepDefs.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

//    WebDriver driver = Login.driver;


    public void closePopup(WebDriver driver){
        driver.findElement(By.cssSelector("button[aria-label=\"newsletter_popup_close-cta\"]")).click();
    }

    public WebElement accountMenu(WebDriver driver){
        return driver.findElement(By.cssSelector("label[for=\"dpdw-login\"]"));
    }

    public WebElement signInButton(WebDriver driver){
        String link = "btn _prim -fw _md";
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 ->  driver.findElement(By.cssSelector("a[class=\"" + link + "\"]")));
    }

    public void fashionMenuHover(WebDriver driver){
        WebElement fashionMenu = driver.findElement(By.cssSelector("a[href=\"/category-fashion-by-jumia/\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(fashionMenu).perform();
    }

    public void shirtsCategoryClick(WebDriver driver){
        WebElement shirt = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"/mens-casual-button-down-shirts/\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(shirt).perform();
        shirt.click();
    }

    public void itemAddToCartBtn(WebDriver driver, int num){
        String classname = "prd _fb col c-prd";
        List<WebElement> items = driver.findElements(By.cssSelector("article[class=\"" + classname + "\"]"));
        WebElement item = items.get(num);
        Actions actions = new Actions(driver);
        actions.moveToElement(item).perform();
        WebElement addToCartBtn = item.findElement(By.cssSelector("button[type=\"button\"]"));
//        System.out.println(addToCartBtn.getText());

//        String link = "href=\"/clove-hitch-viyella-wool-plaid-shirt-33837140.html\"";
//        String btn = "class=\"add btn _prim -pea _md\"";
//        WebElement item = driver.findElement(By.cssSelector("a[" + link + "]"));
        item.click();
//        actions.moveToElement(item,500,1400).perform();
////        actions.moveByOffset(30,20);
//        System.out.println(item.findElement(By.cssSelector("button[type=\"button\"]")));

    }
}
