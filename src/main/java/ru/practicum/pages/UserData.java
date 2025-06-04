package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.util.EnvConfig;

import java.time.Duration;

public class UserData {

    public UserData(WebDriver driver){
        this.driver = driver;
    }

    private static WebDriver driver;


    public static void ClickForwardButton() {
        driver.findElement(By.cssSelector(".Button_Middle__1CSJM")).click();
    }

    public static void FillPhoneNumber(String phoneNumber) {
        driver.findElement(By.cssSelector("input[placeholder='* Телефон: на него позвонит курьер']")).sendKeys(phoneNumber);
    }

    public static void ChooseMetroStation(String stationName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement inputField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@class, 'select-search__input')]")));
        inputField.clear(); // очистить поле, если нужно
        inputField.sendKeys(stationName);
        WebElement stationOption = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[text()='" + stationName + "']")));
        stationOption.click();
    }

    public static void FillAddress(String address) {
        driver.findElement(By.cssSelector("input[placeholder='* Адрес: куда привезти заказ']")).sendKeys(address);
    }

    public static void FillUserSurname(String surname) {
        driver.findElement(By.cssSelector("input[placeholder='* Фамилия']")).sendKeys(surname);
    }

    public static void FillUserName(String name) {
        driver.findElement(By.cssSelector("input[placeholder='* Имя']")).sendKeys(name);
    }
}
