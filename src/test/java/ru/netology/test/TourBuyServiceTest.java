package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import lombok.val;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataHelper;
import ru.netology.data.Requests;
import ru.netology.page.DashboardPage;
import lombok.SneakyThrows;
import ru.netology.page.PurchasePage;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TourBuyServiceTest {

    DashboardPage dashboardPage = new DashboardPage();

    @BeforeEach
    void setup() {
        open("http://localhost:8080");
    }

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
        Requests.clearDataBase();
    }

    @Test
    @SneakyThrows
    void shouldPayApprovedCard() {

        var cardNumber = DataHelper.getApprovedCardNumber();
        var month = DataHelper.getValidMonths();
        var year = DataHelper.getValidYear();
        var cardOwner = DataHelper.getValidOwnerCard();
        var code = DataHelper.getValidCvcCode();
        var payPage = dashboardPage.payByCard();
        payPage.fillingForm(cardNumber, month, year, cardOwner, code);
        payPage.messageApproved();
        assertEquals("APPROVED", Requests.getPaymentGateStatus());

    }
}
