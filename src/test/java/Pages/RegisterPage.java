package Pages;

import StepDefs.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    MainPage mainPage = new MainPage();

    public WebElement emailInput(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.name("email")));
    }

    public WebElement continueBtn(WebDriver driver){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public WebElement continueBtnPassword(WebDriver driver){
        String className = "mdc-button mdc-button--touch mdc-button--raised to-personal-details mdc-ripple-upgraded";
        return mainPage.classWebElement(driver, "button", className);
    }

    public WebElement continueBtnNameAndPhone(WebDriver driver){
        String className = "mdc-button mdc-button--touch mdc-button--raised to-personal-details-part-2 mdc-ripple-upgraded";
        return mainPage.classWebElement(driver, "button", className);
    }

    public WebElement continueBtnGender(WebDriver driver){
        String className = "mdc-button mdc-button--touch mdc-button--raised to-verification-code create-account-button mdc-ripple-upgraded";
        return mainPage.classWebElement(driver, "button", className);
    }

    public WebElement passwordInput(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.name("password")));
    }

    public WebElement confirmPasswordInput(WebDriver driver){
        return driver.findElement(By.cssSelector("input[aria-labelledby=\"confirm-password\"]"));
    }

    public WebElement firstNameInput(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.id("input_first_name")));
    }

    public WebElement lastNameInput(WebDriver driver){
        return driver.findElement(By.id("input_last_name"));
    }

    public WebElement phoneInput(WebDriver driver){
        return driver.findElement(By.name("phone[number]"));
    }

    public WebElement genderDropDown(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.id("gender")));
    }

    public WebElement genderSelect(WebDriver driver){
        return driver.findElement(By.cssSelector("li[data-value=\"M\"]"));
    }

    public WebElement dateOfBirth(WebDriver driver){
        return driver.findElement(By.id("input_birth_date"));
    }

    public WebElement acceptTC(WebDriver driver){
        return driver.findElement(By.id("acceptTC"));
    }
}
