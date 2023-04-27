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
import static org.junit.jupiter.api.Assertions.assertNull;

public class TourBuyServiceDebitCardNegativeTest {

    DashboardPage dashboardPage = new DashboardPage();
    String approvedCardNumber = DataHelper.getApprovedCardNumber();
    String randomCardNumber = DataHelper.getRandomCardNumber();
    String validMonths = DataHelper.getValidMonths();
    String validYear = DataHelper.getValidYear();
    String validOwnerCard = DataHelper.getValidOwnerCard();
    String validCvcCode = DataHelper.getValidCvcCode();

    String unValidMonths = DataHelper.getUnValidMonths();
    String unValidYear = DataHelper.getUnValidYear();
    String arabicOwnerCard = DataHelper.getArabicOwnerCard();
    String outsideOwnerCard = DataHelper.getOutsideOwnerCard();
    String unValidCvcCode = DataHelper.getUnValidCvcCode();
    String unValidMonthsOutside = DataHelper.getUnValidMonthsOutside();
    String zero = "000";
    String empty = " ";

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
    void shouldErrorMessageByCardNumberNotRegisterCard() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(randomCardNumber, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageDeclined();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByEmptyCardNumber() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(empty, validMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByEmpty();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByEmptyMonth() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, empty, validYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByEmpty();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByEmptyYear() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, empty, validOwnerCard, validCvcCode);
        payPage.messageErrorByEmpty();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByEmptyOwner() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, empty, validCvcCode);
        payPage.messageErrorByEmpty();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByEmptyCvc() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, validOwnerCard, empty);
        payPage.messageErrorByEmpty();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidMonthBefore() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, unValidMonths, validYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByUnValidMonth();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidMonthZero() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, zero, validYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidMonthOutside() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, unValidMonthsOutside, validYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByUnValidMonth();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidYear() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, unValidYear, validOwnerCard, validCvcCode);
        payPage.messageErrorByUnValidYear();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidYearZero() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, zero, validOwnerCard, validCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByNumberOwner() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, approvedCardNumber, validCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByArabicOwner() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, arabicOwnerCard, validCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByOutsideOwner() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, outsideOwnerCard, validCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidCVCCode() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, validOwnerCard, unValidCvcCode);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }

    @Test
    @SneakyThrows
    void shouldErrorMessageByUnValidCVCCodeZero() {
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(approvedCardNumber, validMonths, validYear, validOwnerCard, zero);
        payPage.messageErrorByUnCorrectFormat();
        assertNull(Requests.getPaymentGateStatus());
    }
}