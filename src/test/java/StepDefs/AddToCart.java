package StepDefs;

import Pages.MainPage;
import Pages.RegisterPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCart {


    static String email = "";
    static String password = "";

    static WebDriver driver = new ChromeDriver();
    static MainPage mainPage = new MainPage();
    static RegisterPage registerPage = new RegisterPage();

    @BeforeTest
    public static void OpenBrowser() {
        String chrome_path = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chrome_path);
        driver.manage().window().maximize();
        driver.get("https://www.jumia.com.eg/");
    }

    @Test
    public static void AddItemsToCart() throws InterruptedException {
        //Close newsletter popup
        Thread.sleep(2_000);
        mainPage.closePopup(driver);

        //go to login page
        mainPage.accountMenu(driver).click();
        mainPage.signInButton(driver).click();

        //login with created user
        registerPage.emailInput(driver).sendKeys(email);
        registerPage.continueBtn(driver).click();
        registerPage.passwordInput(driver).sendKeys(password);
        registerPage.passwordInput(driver).sendKeys(Keys.RETURN);

        //go to shirts & Select 2 items
        Thread.sleep(2_000);
        mainPage.fashionMenuHover(driver);
        Thread.sleep(1_000);
        mainPage.shirtsCategoryClick(driver);

        Thread.sleep(2_000);
        mainPage.itemAddToCartBtn(driver, 1);

    }

    @AfterTest
    public static void CloseBrowser() throws InterruptedException {
        Thread.sleep(3_000);
        driver.quit();
    }
}
