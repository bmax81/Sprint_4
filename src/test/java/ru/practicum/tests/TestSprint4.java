package ru.practicum.tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.practicum.pages.MainPage;

import java.time.Duration;

@RunWith(Parameterized.class)
public class TestSprint4 {

    private static WebDriver driver; // общий драйвер для всего класса
    private static WebDriverWait wait; // общий wait

    private final String questionId;
    private final String answerSelector;
    private final String expectedAnswer;

    public TestSprint4(String questionId, String answerSelector, String expectedAnswer) {
        this.questionId = questionId;
        this.answerSelector = answerSelector;
        this.expectedAnswer = expectedAnswer;
    }

    @BeforeClass
    public static void setUp() {
        // Получаем драйвер один раз перед всеми тестами
        driver = DriverFactory.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public static void tearDown() {
        // Закрываем драйвер после всех тестов
        DriverFactory.quitDriver();
    }

    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"accordion__heading-0", "#accordion__panel-0 > p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"accordion__heading-1", "#accordion__panel-1 > p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"accordion__heading-2", "#accordion__panel-2 > p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"accordion__heading-3", "#accordion__panel-3 > p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"accordion__heading-4", "#accordion__panel-4 > p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"accordion__heading-5", "#accordion__panel-5 > p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"accordion__heading-6", "#accordion__panel-6 > p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"accordion__heading-7", "#accordion__panel-7 > p", "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
        };
    }

    @Test
    public void checkDropDownList() {
        MainPage mainPage = new MainPage(driver);

        MainPage.OpenMainPage();
        MainPage.ScrollToTheBottomOfThePage();
        MainPage.ClickTheQuestion(questionId);
        MainPage.CheckTheAnswer(answerSelector, expectedAnswer);

    }

}




