package ru.practicum.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.util.EnvConfig;

import java.time.Duration;

import static org.openqa.selenium.By.cssSelector;

public class OrderData {

    public OrderData(WebDriver driver){
        this.driver = driver;
    }

    private static WebDriver driver;

    public static void GetAssuredTheOrderIsMade() {
        By element2 = cssSelector(".Order_NextButton__1_rCA > button:nth-child(1)");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(element2));
        Assert.assertTrue(driver.findElement(element2).isDisplayed());
    }

    public static void ChooseAnotherColour() {
        driver.findElement(By.cssSelector("label.Checkbox_Label__3wxSf:nth-child(2)")).click();
    }

    public static void ChooseAnotherRentalPeriod() {
        driver.findElement(By.cssSelector(".Dropdown-placeholder")).click();
        driver.findElement(By.cssSelector("div.Dropdown-option:nth-child(2)")).click();
    }

    public static void ChooseAnotherDate() {
        driver.findElement(By.cssSelector("input[placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--011")).click();
    }

    public static void ConfirmTheOrder() {
        By element1 = cssSelector(".Order_ModalHeader__3FDaJ");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(element1));
        Assert.assertTrue(driver.findElement(element1).isDisplayed());
        // Click Yes
        driver.findElement(By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)")).click();
    }

    public static void ClickCreateOrderButton() {
        driver.findElement(By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)")).click();
    }

    public static void ChooseColour() {
        driver.findElement(By.cssSelector("label.Checkbox_Label__3wxSf:nth-child(4)")).click();
    }

    public static void ChooseRentalPeriod() {
        driver.findElement(By.cssSelector(".Dropdown-placeholder")).click();
        driver.findElement(By.cssSelector("div.Dropdown-option:nth-child(3)")).click();
    }

    public static void ChooseDate() {
        driver.findElement(By.cssSelector("input[placeholder='* Когда привезти самокат']")).click();
        driver.findElement(By.cssSelector(".react-datepicker__day--012")).click();
    }

    public static void CheckOrderDataWindowIsOpen() {
        By element = cssSelector(".Order_Header__BZXOb");
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(element));
        Assert.assertTrue(driver.findElement(element).isDisplayed());
    }
}
