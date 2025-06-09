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

public class MainPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Локаторы элементов
    private static final By buttonOnTheTop = By.cssSelector(".Button_Button__ra12g");
    private static final By middleOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    private static final By finalQuestion = By.id("accordion__heading-7");

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
    }

    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    public void clickOrderButtonOnTheTopOfThePage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonOnTheTop)).click();
    }

    public void scrollDownAndClickTheMiddleButton() {
        WebElement middleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(middleOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", middleButton);
        middleButton.click();
    }

    public void checkTheAnswer(String answerSelector, String expectedAnswer) {
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(answerSelector)));
        String actualText = answer.getText();
        assertEquals(expectedAnswer, actualText);
    }

    public void clickQuestionByIndex(int index) {
        String questionId = getQuestionIdByIndex(index);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(questionId))).click();
    }

    public String getAnswerSelectorByIndex(int index) {
        return "#accordion__panel-" + index + " > p";
    }

    public String getQuestionIdByIndex(int index) {
        return "accordion__heading-" + index;
    }

    public void scrollToLastQuestion() {
        WebElement lastQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(finalQuestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastQuestion);
    }
}