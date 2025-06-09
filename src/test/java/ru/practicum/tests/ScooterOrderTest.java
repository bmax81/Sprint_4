package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.OrderData;
import ru.practicum.pages.UserData;
import ru.practicum.util.EnvConfig;

import java.time.Duration;


public class ScooterOrderTest {
    private WebDriver driver; // общий драйвер для всего класса

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    @Test
    public void orderFromButtonOnTopOfPage() throws InterruptedException {
        driver = driverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));

        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        OrderData orderData = new OrderData(driver);
        OrderSteps steps = new OrderSteps(mainPage, userData, orderData);

        steps.startOrderFromTopButton();
        // Fill user data
        steps.fillUserDetails("Иван", "Иванов", "Доватора 12", "Спортивная", "89526524512");
        steps.confirmUserData();
        //Fill order data
        orderData.chooseDate();
        orderData.chooseRentalPeriod();
        orderData.chooseColour();
        orderData.clickCreateOrderButton();
        orderData.confirmTheOrder();
        orderData.getAssuredTheOrderIsMade();

    }

    @Test
    public void orderFromButtonInMiddleOfPage() throws InterruptedException {
        driver = driverFactory.getDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        OrderData orderData = new OrderData(driver);
        OrderSteps steps = new OrderSteps(mainPage, userData, orderData);

        steps.startOrderFromMiddleButton();
        // Fill user data
        steps.fillUserDetails("Федя", "Гусев", "Русаковская 26", "Сокольники", "89632147559");
        steps.confirmUserData();
        //Fill order data
        orderData.chooseAnotherDate();
        orderData.chooseAnotherRentalPeriod();
        orderData.chooseAnotherColour();
        orderData.clickCreateOrderButton();
        orderData.confirmTheOrder();
        orderData.getAssuredTheOrderIsMade();
    }
}




