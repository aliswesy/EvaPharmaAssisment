package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    public void closePopup(WebDriver driver) {
        driver.findElement(By.cssSelector("button[aria-label=\"newsletter_popup_close-cta\"]")).click();
    }

    public WebElement accountMenu(WebDriver driver) {
        return driver.findElement(By.cssSelector("label[for=\"dpdw-login\"]"));
    }

    public WebElement signInButton(WebDriver driver) {
//        String link = "btn _prim -fw _md";
//        return new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(driver1 ->  driver.findElement(By.cssSelector("a[class=\"" + link + "\"]")));
        return classWebElement(driver, "a", "btn _prim -fw _md");
    }

    public void fashionMenuHover(WebDriver driver) {
        WebElement fashionMenu = driver.findElement(By.cssSelector("a[href=\"/category-fashion-by-jumia/\"]"));
        Actions action = new Actions(driver);
        action.moveToElement(fashionMenu).perform();
    }

    public void shirtsCategoryClick(WebDriver driver) {
        WebElement shirt = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href=\"/mens-casual-button-down-shirts/\"]")));
        Actions action = new Actions(driver);
        action.moveToElement(shirt).perform();
        shirt.click();
    }

    /*
    public void itemAddToCartBtn(WebDriver driver, int num){
        String classname = "prd _fb col c-prd";
        List<WebElement> items = driver.findElements(By.cssSelector("article[class=\"" + classname + "\"]"));
        WebElement item = items.get(num);
        Actions actions = new Actions(driver);
        actions.moveToElement(item).perform();
        WebElement addToCartBtn = item.findElement(By.cssSelector("button[type=\"button\"]"));
        System.out.println(addToCartBtn.getText());

        String link = "href=\"/clove-hitch-viyella-wool-plaid-shirt-33837140.html\"";
        String btn = "class=\"add btn _prim -pea _md\"";
        WebElement item = driver.findElement(By.cssSelector("a[" + link + "]"));
        item.click();
        actions.moveToElement(item,500,1400).perform();
        actions.moveByOffset(30,20);
        System.out.println(item.findElement(By.cssSelector("button[type=\"button\"]")));

    }
    */
    public WebElement SelectItem(WebDriver driver, int num) {
        WebElement item = classWebElements(driver, "div", "itm col").get(num);
        return item;
    }

    public WebElement itemAddToCartBtn(WebDriver driver) {
        WebElement btn = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.id("add-to-cart")));

        Actions actions = new Actions(driver);
        actions.scrollToElement(btn).perform();

        return btn;
    }

    public WebElement test(WebDriver driver) {
        return driver.findElement(By.id("fi-simpleSku-0"));
    }

    public WebElement selectVariationAddBtn(WebDriver driver) {
        List<WebElement> items = classWebElements(driver, "div", "-df -i-ctr -j-bet -pvs");
        WebElement addBtn = null;
        Actions actions = new Actions(driver);

        for (WebElement item :
                items) {
            if (item.getText().contains("In stock")) {
                addBtn = item.findElement(By.cssSelector("button[value=\"in\"]"));
                actions.scrollToElement(addBtn).perform();
            }
        }
        return addBtn;
    }

    public WebElement shoppingCartBtn(WebDriver driver) {
        return driver.findElement(By.cssSelector("a[href=\"/cart/\"]"));
    }

    public WebElement increaseAmountBtn(WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.cssSelector("button[value=\"in\"]")));
    }

    public WebElement itemsCount(WebDriver driver) {
        return classWebElement(driver, "span", "-w-32 -mas -m -fs14 -tac -lh-1");
    }

    public int itemsPrice(WebDriver driver) {
        int finalPrice = 0;
        List<WebElement> items = classWebElements(driver, "article", "prd _cl");
        for (WebElement item :
                items) {
            String text = item.findElement(By.cssSelector("div[class=\"prc\"]")).getText();
            int price = Integer.parseInt(text.replaceAll("[^0-9]", ""))
                    + Integer.parseInt(itemsCount(driver).getText());
            finalPrice += price;
        }

        return finalPrice;
    }

    public int subTotal(WebDriver driver) {
        return Integer.parseInt(classWebElement(driver, "p", "-fs20 -plm -tar")
                .getText().replaceAll("[^0-9]", ""));
    }


    /**
     * use this to return a list of elements using (Css Selector) through the "Class" attribute.
     *
     * @param tagName   the tag of the element
     * @param className the value in the class attribute
     * @return a list of elements
     */
    public List<WebElement> classWebElements(WebDriver driver, String tagName, String className) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElements(By.cssSelector(tagName + "[class=\"" + className + "\"]")));
    }

    /**
     * use this to return an element using (Css Selector) through the "Class" attribute.
     *
     * @param tagName   the tag of the element
     * @param className the value in the class attribute
     * @return an element
     */
    public WebElement classWebElement(WebDriver driver, String tagName, String className) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.cssSelector(tagName + "[class=\"" + className + "\"]")));
    }
}
