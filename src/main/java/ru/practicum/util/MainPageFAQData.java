package ru.practicum.util;


import org.openqa.selenium.WebDriver;
import ru.practicum.pages.MainPage;

public class MainPageFAQData {
    private WebDriver driver;

    public MainPageFAQData(WebDriver driver) {
        this.driver = driver;
    }

    private MainPage mainPage;
    public static final Object[][] FAQ_DATA = {

            {MainPage.firstQuestion, MainPage.firstAnswer, "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
            {MainPage.secondQuestion, MainPage.secondAnswer, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
            {MainPage.thirdQuestion, MainPage.thirdAnswer, "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
            {MainPage.forthQuestion, MainPage.fourthAnswer, "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
            {MainPage.fifthQuestion, MainPage.fifthAnswer, "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
            {MainPage.sixthQuestion, MainPage.sixthAnswer, "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
            {MainPage.seventhQuestion, MainPage.seventhAnswer, "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
            {MainPage.eighthQuestion, MainPage.eighthAnswer, "Да, обязательно. Всем самокатов! И Москве, и Московской области."}
    };
}



