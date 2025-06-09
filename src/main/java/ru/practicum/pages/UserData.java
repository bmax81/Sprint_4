package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.util.EnvConfig;

import java.time.Duration;

public class UserData {
    private WebDriver driver;
    public UserData(WebDriver driver){
        this.driver = driver;
    }

    // Локаторы как поля класса
    private By forwardButton = By.cssSelector(".Button_Middle__1CSJM");
    private By phoneNumberInput = By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']");
    private By metroStationInput = By.xpath("//input[contains(@class, 'select-search__input')]");
    private By metroStationOption(String stationName) {
        return By.xpath("//div[text()='" + stationName + "']");
    }
    private By addressInput = By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']");
    private By surnameInput = By.cssSelector("input[placeholder='* Фамилия']");
    private By nameInput = By.cssSelector("input[placeholder='* Имя']");

    public void clickForwardButton() {
        driver.findElement(forwardButton).click();
    }

    public void fillPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void chooseMetroStation(String stationName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(metroStationInput));
        inputField.clear(); // очистить поле, если нужно
        inputField.sendKeys(stationName);
        WebElement stationOption = wait.until(ExpectedConditions.elementToBeClickable(metroStationOption(stationName)));
        stationOption.click();
    }

    public void fillAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void fillUserSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void fillUserName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }
}
