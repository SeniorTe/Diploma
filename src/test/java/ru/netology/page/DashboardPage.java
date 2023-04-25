package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private SelenideElement buyInCreditButton = $$("button").find(exactText("Купить в кредит"));
    private SelenideElement payCard = $$("h3").find(text("Оплата по карте"));
    private SelenideElement payCredit = $$("h3").find(text("Кредит по данным карты"));

    public PurchasePage payByCard() {
        buyButton.click();
        payCard.shouldBe(visible);
        return new PurchasePage();
    }

    public PurchasePage payByCredit() {
        buyInCreditButton.click();
        payCredit.shouldBe(visible);
        return new PurchasePage();
    }
}