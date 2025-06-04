package ru.practicum.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.practicum.util.EnvConfig;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    // Получение драйвера (создает при необходимости)
    public static WebDriver getDriver() {
           initDriver();
           return driver;
    }

    // Инициализация драйвера
    private static void initDriver() {
        String browser = System.getProperty("browser", "chrome");
        if ("firefox".equalsIgnoreCase(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(EnvConfig.IMPLICITY_TIMEOUT));
        driver.manage().window().maximize();
    }

    // Закрытие драйвера
    public static void quitDriver() {
            driver.quit();
    }
}
