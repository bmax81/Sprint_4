package ru.practicum.tests;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;
import ru.practicum.util.MainPageFAQData;

@RunWith(Parameterized.class)
public class ScooterMainPageFAQTest {

    @Rule
    public DriverFactory driverFactory = new DriverFactory();

    private WebDriver driver;
    private MainPage mainPage;

    // Параметры теста: id вопроса, селектор ответа, ожидаемый ответ
    private final String questionId;
    private final String answerSelector;
    private final String expectedAnswer;

    public ScooterMainPageFAQTest(String questionId, String answerSelector, String expectedAnswer) {
        this.questionId = questionId;
        this.answerSelector = answerSelector;
        this.expectedAnswer = expectedAnswer;
    }

    @Parameterized.Parameters(name = "Вопрос: {0}")
    public static Object[][] data() {
        return MainPageFAQData.FAQ_DATA; // Используем внешние данные
    }

    @Test
    public void checkDropDownList() throws InterruptedException {
        // Получение драйвера из фабрики для каждого теста
        driver = driverFactory.getDriver();

        // Создаем страницу с текущим драйвером
        mainPage = new MainPage(driver);

        mainPage.openMainPage();
        mainPage.scrollToTheBottomOfThePage();
        mainPage.clickTheQuestion(questionId);
        mainPage.checkTheAnswer(answerSelector, expectedAnswer);
    }
}




