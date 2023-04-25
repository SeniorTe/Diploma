package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchasePage {

    private SelenideElement cardNumberForm = $("[placeholder='0000 0000 0000 0000']");
    private SelenideElement monthForm = $("[placeholder='08']");
    private SelenideElement yearForm = $("[placeholder='22']");
    private SelenideElement cardOwnerForm = $$("[class='input__control']").get(3);
    private SelenideElement CVCCodeForm = $("[placeholder='999']");
    private SelenideElement buttonContinue = $(byText("Продолжить"));
    private SelenideElement approvedNotification = $(byText("Операция одобрена Банком."));
    private SelenideElement declinedNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private SelenideElement errorMessageByEmpty = $(byText("Поле обязательно для заполнения"));
    private SelenideElement incorrectCardNumber = $(byText("Номер карты указан неверно"));
    private SelenideElement incorrectMonth = $(byText("Месяц указан неверно"));
    private SelenideElement incorrectYear = $(byText("Год указан неверно"));
    private SelenideElement incorrectOwner = $(byText("Имя владельца указано неверно"));
    private SelenideElement incorrectCVCCode = $(byText("CVC код указан неверно"));


    public PurchasePage fillingForm(String cardNumber, String month, String year, String cardOwner, String CVCCode) {
        cardNumberForm.setValue(cardNumber);
        monthForm.setValue(month);
        yearForm.setValue(year);
        cardOwnerForm.setValue(cardOwner);
        CVCCodeForm.setValue(CVCCode);
        buttonContinue.click();
        return new PurchasePage();
    }

    public void messageApproved() {
        approvedNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageDeclined() {
        declinedNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageErrorByEmpty() {
        errorMessageByEmpty.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectCardNumber() {
        incorrectCardNumber.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectMonth() {
        incorrectMonth.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectYear() {
        incorrectYear.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectOwner() {
        incorrectOwner.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageIncorrectCVCCode() {
        incorrectCVCCode.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }


}
