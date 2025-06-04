package ru.practicum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.util.EnvConfig;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.By.cssSelector;

public class MainPage {
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private static WebDriver driver;

    public static void OpenMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public static void ClickOrderButtonOnTheTopOfThePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(cssSelector(".Button_Button__ra12g"))).click();
    }

    public static void ScrollDownAndClickTheSecondButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement secondButton = driver.findElement(By.xpath("/html/body/div/div/div[1]/div[4]/div[2]/div[5]/button"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", secondButton);

        // Click order button in the bottom of the page
        secondButton.click();
    }

    public static void CheckTheAnswer(String answerSelector, String expectedAnswer) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(answerSelector)));
        String actualText = answer.getText();
        assertEquals(expectedAnswer, actualText);
    }

    public static void ClickTheQuestion(String questionId) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(By.id(questionId)));
        question.click();
    }

    public static void ScrollToTheBottomOfThePage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
        WebElement lastQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-7")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastQuestion);
    }
}
