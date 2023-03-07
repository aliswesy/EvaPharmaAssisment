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
    static String email = "tomsmith@teml.net";
    static String password = "AA0123456789BB--";
    static String firstName = "tom";
    static String LastName = "smith";
    static String phone = "1012345678";

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

        //Create password
        registerPage.passwordInput(driver).sendKeys(password);
        registerPage.confirmPasswordInput(driver).sendKeys(password);
        Thread.sleep(1_000);
        registerPage.continueBtnPassword(driver).click();

        //Input Name And Phone number
        registerPage.firstNameInput(driver).sendKeys(firstName);
        registerPage.lastNameInput(driver).sendKeys(LastName);
        registerPage.phoneInput(driver).sendKeys(phone);
        Thread.sleep(1_000);
        registerPage.continueBtnNameAndPhone(driver).click();


        //Select gender and Date of Birth
        Thread.sleep(1_000);
        registerPage.genderDropDown(driver).click();
        registerPage.genderSelect(driver).click();

        registerPage.dateOfBirth(driver).click();
        registerPage.dateOfBirth(driver).sendKeys("10");
        registerPage.dateOfBirth(driver).sendKeys("9");
        registerPage.dateOfBirth(driver).sendKeys(Keys.ARROW_RIGHT);
        registerPage.dateOfBirth(driver).sendKeys("1995");
        registerPage.acceptTC(driver).click();
        Thread.sleep(1_000);
        registerPage.continueBtnGender(driver).click();

    }

    @AfterTest
    public static void CloseBrowser() throws InterruptedException {
        Thread.sleep(3_000);
        driver.quit();
    }
}
