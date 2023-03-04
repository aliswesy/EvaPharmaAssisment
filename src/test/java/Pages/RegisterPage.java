package Pages;

import StepDefs.Login;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
//    WebDriver driver = Login.driver;

    public WebElement emailInput(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver1 -> driver.findElement(By.name("email")));
    }

    public WebElement continueBtn(WebDriver driver){
        return driver.findElement(By.cssSelector("button[type=\"submit\"]"));
    }

    public WebElement continueBtn2(WebDriver driver){
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[type=\"button\"]"))));
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


}
