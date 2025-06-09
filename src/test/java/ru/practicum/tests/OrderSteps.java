package ru.practicum.tests;

import ru.practicum.pages.MainPage;
import ru.practicum.pages.UserData;
import ru.practicum.pages.OrderData;

public class OrderSteps {
    private MainPage mainPage;
    private UserData userData;
    private OrderData orderData;

    public OrderSteps(MainPage mainPage, UserData userData, OrderData orderData) {
        this.mainPage = mainPage;
        this.userData = userData;
        this.orderData = orderData;
    }

    public void startOrderFromTopButton() {
        mainPage.openMainPage();
        mainPage.clickOrderButtonOnTheTopOfThePage();
    }

    public void startOrderFromMiddleButton() {
        mainPage.openMainPage();
        mainPage.scrollDownAndClickTheMiddleButton();
    }

    public void fillUserDetails(String name, String surname, String address, String station, String phone) {
        userData.fillUserName(name);
        userData.fillUserSurname(surname);
        userData.fillAddress(address);
        userData.chooseMetroStation(station);
        userData.fillPhoneNumber(phone);
           }

    public void confirmUserData() {
        orderData.checkOrderDataWindowIsOpen();
        userData.clickForwardButton();
            }
}
