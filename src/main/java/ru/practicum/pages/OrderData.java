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
    private WebDriver driver;

    public OrderData(WebDriver driver){
        this.driver = driver;
    }

    // Локаторы в полях класса
    private static final By checkStatusButton = org.openqa.selenium.By.cssSelector(".Order_NextButton__1_rCA > button:nth-child(1)");
    private static final By colourChoice = By.cssSelector("label.Checkbox_Label__3wxSf:nth-child(2)");
    private static final By dropdownPlaceholder = By.cssSelector(".Dropdown-placeholder");
    private static final By dropdownOption = By.cssSelector("div.Dropdown-option:nth-child(2)");
    private static final By dateInput = By.cssSelector("input[placeholder='* Когда привезти самокат']");
    private static final By dateSecondPick = By.cssSelector(".react-datepicker__day--011");
    private static final By orderData = cssSelector(".Order_Header__BZXOb");
    private static final By yesButton = By.cssSelector("div.Order_Buttons__1xGrp:nth-child(2) > button:nth-child(2)");
    private static final By confirmationWindow = cssSelector(".Order_ModalHeader__3FDaJ");
    private static final By createOrderButton = By.cssSelector("#root > div > div.Order_Content__bmtHS > div.Order_Buttons__1xGrp > button:nth-child(2)");
    private static final By colourButton = By.cssSelector("label.Checkbox_Label__3wxSf:nth-child(4)");
    private static final By rentalPeriodDropdownPlaceholder = By.cssSelector(".Dropdown-placeholder");
    private static final By thirdDropdownOption = By.cssSelector("div.Dropdown-option:nth-child(3)");
    private static final By dateFirstPick = By.cssSelector(".react-datepicker__day--012");

    public void getAssuredTheOrderIsMade() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(checkStatusButton));
        Assert.assertTrue(driver.findElement(checkStatusButton).isDisplayed());
    }

    public void chooseAnotherColour() {
        driver.findElement(colourChoice).click();
    }

    public void chooseAnotherRentalPeriod() {
        driver.findElement(dropdownPlaceholder).click();
        driver.findElement(dropdownOption).click();
    }

    public void chooseAnotherDate() {
        driver.findElement(dateInput).click();
        driver.findElement(dateSecondPick).click();
    }

    public void confirmTheOrder() {
             new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(confirmationWindow));
        Assert.assertTrue(driver.findElement(confirmationWindow).isDisplayed());
        // Click Yes
        driver.findElement(yesButton).click();
    }

    public void clickCreateOrderButton() {
        driver.findElement(createOrderButton).click();
    }

    public void chooseColour() {
        driver.findElement(colourButton).click();
    }

    public void chooseRentalPeriod() {
        driver.findElement(rentalPeriodDropdownPlaceholder).click();
        driver.findElement(thirdDropdownOption).click();
    }

    public void chooseDate() {
        driver.findElement(dateInput).click();
        driver.findElement(dateFirstPick).click();
    }

    public void checkOrderDataWindowIsOpen() {
                new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(orderData));
        Assert.assertTrue(driver.findElement(orderData).isDisplayed());
    }
}
