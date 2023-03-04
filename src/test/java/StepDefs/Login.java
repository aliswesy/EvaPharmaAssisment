package StepDefs;

import Pages.MainPage;
import Pages.RegisterPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login {
    static String email = "";
    static String password = "";
    static String firstName = "";
    static String LastName = "";
    static String phone = "";

    public static WebDriver driver = new ChromeDriver();
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
    public static void login() throws InterruptedException {
        //Close newsletter popup
        Thread.sleep(2_000);
        mainPage.closePopup(driver);

        //got to register page
        mainPage.accountMenu(driver).click();
        mainPage.signInButton(driver).click();

        //Register new user
        registerPage.emailInput(driver).sendKeys(email);
        registerPage.continueBtn(driver).click();

        registerPage.passwordInput(driver).sendKeys(password);
        registerPage.confirmPasswordInput(driver).sendKeys(password);
        registerPage.continueBtn2(driver).click();

        registerPage.firstNameInput(driver).sendKeys(firstName);
        registerPage.lastNameInput(driver).sendKeys(LastName);
        registerPage.phoneInput(driver).sendKeys(phone);
    }

    @AfterTest
    public static void CloseBrowser() throws InterruptedException {
        Thread.sleep(3_000);
        driver.quit();
    }
}
