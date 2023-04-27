package ru.netology.page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PurchasePage {

    private final SelenideElement cardNumberForm = $("[placeholder='0000 0000 0000 0000']");
    private final SelenideElement monthForm = $("[placeholder='08']");
    private final SelenideElement yearForm = $("[placeholder='22']");
    private final SelenideElement cardOwnerForm = $$("[class='input__control']").get(3);
    private final SelenideElement CVCCodeForm = $("[placeholder='999']");
    private final SelenideElement buttonContinue = $(byText("Продолжить"));
    private final SelenideElement approvedNotification = $(byText("Операция одобрена Банком."));
    private final SelenideElement declinedNotification = $(byText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement errorMessageByEmpty = $(byText("Поле обязательно для заполнения"));
    private final SelenideElement errorMessageByUnCorrectFormat = $(byText("Неверный формат"));
    private final SelenideElement errorMessageByUnValidMonth = $(byText("Неверно указан срок действия карты"));
    private final SelenideElement errorMessageByUnValidYear = $(byText("Истёк срок действия карты"));

    public void fillingForm(String cardNumber, String month, String year, String cardOwner, String CVCCode) {
        cardNumberForm.setValue(cardNumber);
        monthForm.setValue(month);
        yearForm.setValue(year);
        cardOwnerForm.setValue(cardOwner);
        CVCCodeForm.setValue(CVCCode);
        buttonContinue.click();
        new PurchasePage();
    }

    public void messageApproved() {
        approvedNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageDeclined() {
        declinedNotification.shouldBe(Condition.visible, Duration.ofSeconds(15));
    }

    public void messageErrorByEmpty() {
        errorMessageByEmpty.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void messageErrorByUnCorrectFormat() {
        errorMessageByUnCorrectFormat.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void messageErrorByUnValidMonth() {
        errorMessageByUnValidMonth.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }

    public void messageErrorByUnValidYear() {
        errorMessageByUnValidYear.shouldBe(Condition.visible, Duration.ofSeconds(5));
    }
}