package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;

import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.Requests;
import ru.netology.page.DashboardPage;
import lombok.SneakyThrows;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TourBuyServicePositiveTest {

    DashboardPage dashboardPage = new DashboardPage();
    String approvedCardNumber = DataHelper.getApprovedCardNumber();
    String declinedCardNumber = DataHelper.getDeclinedCardNumber();
    String validMonths = DataHelper.getValidMonths();
    String validYear = DataHelper.getValidYear();
    String validOwnerCard = DataHelper.getValidOwnerCard();
    String validCvcCode = DataHelper.getValidCvcCode();

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void downAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void down() {
        Requests.clearDataBase();
    }


    @Test
    @SneakyThrows
    void shouldPayApprovedCardPositive() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageApproved();
        assertEquals("APPROVED", Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldPayApprovedCreditCardPositive() {
        var payPage = dashboardPage.payByCredit();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageApproved();
        assertEquals("APPROVED", Requests.getCreditGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldPayDeclinedCardPositive() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(declinedCardNumber, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageDeclined();
        assertEquals("DECLINED", Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldPayDeclinedCreditCardPositive() {
        var payPage = dashboardPage.payByCredit();
        payPage.fillingForm(declinedCardNumber, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageDeclined();
        assertEquals("DECLINED", Requests.getCreditGateStatus());
    }
}