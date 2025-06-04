package ru.practicum.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.pages.MainPage;
import ru.practicum.pages.OrderData;
import ru.practicum.pages.UserData;
import ru.practicum.util.EnvConfig;

import java.time.Duration;


public class OrderScooter {
    private static WebDriver driver; // общий драйвер для всего класса
    private static WebDriverWait wait; // общий wait

    @BeforeClass
    public static void setUp() {
        // Получаем драйвер один раз перед всеми тестами
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
    }

    @AfterClass
    public static void tearDown() {
        // Закрываем драйвер после всех тестов
        DriverFactory.quitDriver();
    }

    @Test
    public void fillOrderForm() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));

        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        OrderData orderData = new OrderData(driver);

        MainPage.OpenMainPage();
        MainPage.ClickOrderButtonOnTheTopOfThePage();
        // Fill user data
        UserData.FillUserName("Иван");
        UserData.FillUserSurname("Иванов");
        UserData.FillAddress("Доватора 12");
        UserData.ChooseMetroStation("Спортивная");
        UserData.FillPhoneNumber("89526524512");
        UserData.ClickForwardButton();
        OrderData.CheckOrderDataWindowIsOpen();
        //Fill order data
        OrderData.ChooseDate();
        OrderData.ChooseRentalPeriod();
        OrderData.ChooseColour();
        OrderData.ClickCreateOrderButton();
        OrderData.ConfirmTheOrder();
        OrderData.GetAssuredTheOrderIsMade();

    }

    @Test
    public void fillOrderForm2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));

        MainPage mainPage = new MainPage(driver);
        UserData userData = new UserData(driver);
        OrderData orderData = new OrderData(driver);

        MainPage.OpenMainPage();
        MainPage.ScrollDownAndClickTheSecondButton();
        // Fill user data
        UserData.FillUserName("Федя");
        UserData.FillUserSurname("Гусев");
        UserData.FillAddress("Русаковская 26");
        UserData.ChooseMetroStation("Сокольники");
        UserData.FillPhoneNumber("89632147559");
        UserData.ClickForwardButton();
        OrderData.CheckOrderDataWindowIsOpen();
        //Fill order data
        OrderData.ChooseAnotherDate();
        OrderData.ChooseAnotherRentalPeriod();
        OrderData.ChooseAnotherColour();
        OrderData.ClickCreateOrderButton();
        OrderData.ConfirmTheOrder();
        OrderData.GetAssuredTheOrderIsMade();
    }
}




