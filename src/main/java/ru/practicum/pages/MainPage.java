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
    public static final String firstQuestion = "accordion__heading-0";
    public static final String secondQuestion = "accordion__heading-1";
    public static final String thirdQuestion = "accordion__heading-2";
    public static final String forthQuestion = "accordion__heading-3";
    public static final String fifthQuestion = "accordion__heading-4";
    public static final String sixthQuestion = "accordion__heading-5";
    public static final String seventhQuestion = "accordion__heading-6";
    public static final String eighthQuestion = "accordion__heading-7";
    public static final String firstAnswer = "#accordion__panel-0 > p";
    public static final String secondAnswer = "#accordion__panel-1 > p";
    public static final String thirdAnswer = "#accordion__panel-2 > p";
    public static final String fourthAnswer = "#accordion__panel-3 > p";
    public static final String fifthAnswer = "#accordion__panel-4 > p";
    public static final String sixthAnswer = "#accordion__panel-5 > p";
    public static final String seventhAnswer = "#accordion__panel-6 > p";
    public static final String eighthAnswer = "#accordion__panel-7 > p";

    // Конструктор
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.EXPLICITY_TIMEOUT));
    }

    // Открытие главной страницы
    public void openMainPage() {
        driver.get(EnvConfig.BASE_URL);
    }

    // Нажатие кнопки "Заказать" вверху страницы
    public void clickOrderButtonOnTheTopOfThePage() {
        wait.until(ExpectedConditions.elementToBeClickable(buttonOnTheTop)).click();
    }

    // Прокрутка вниз и нажатие средней кнопки заказа
    public void scrollDownAndClickTheMiddleButton() {
        WebElement middleButton = wait.until(ExpectedConditions.visibilityOfElementLocated(middleOrderButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", middleButton);
        middleButton.click();
    }

    // Проверка текста ответа по селектору
    public void checkTheAnswer(String answerSelector, String expectedAnswer) {
        WebElement answer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(answerSelector)));
        String actualText = answer.getText();
        assertEquals(expectedAnswer, actualText);
    }

    // Нажатие на вопрос по id
    public void clickTheQuestion(String questionId) {
        WebElement question = wait.until(ExpectedConditions.elementToBeClickable(By.id(questionId)));
        question.click();
    }

    // Прокрутка до последнего вопроса
    public void scrollToTheBottomOfThePage() {
        WebElement lastQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(finalQuestion));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", lastQuestion);
    }
}