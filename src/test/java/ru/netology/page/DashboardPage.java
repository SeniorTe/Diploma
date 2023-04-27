package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class DashboardPage {
    private final SelenideElement buyButton = $$("button").find(exactText("Купить"));
    private final SelenideElement buyInCreditButton = $$("button").find(exactText("Купить в кредит"));
    private final SelenideElement payCard = $$("h3").find(text("Оплата по карте"));
    private final SelenideElement payCredit = $$("h3").find(text("Кредит по данным карты"));

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