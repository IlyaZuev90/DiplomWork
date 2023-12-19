package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class WebServicePage {


    private final SelenideElement buttonBuyByCard = $$(".button__text").find(exactText("Купить"));
    private final SelenideElement buttonBuyByCardInCredit = $$(".button__text").find(exactText("Купить в кредит"));
    private final SelenideElement fieldCardNumber = $$(".input__inner").findBy(text("Номер карты")).$(".input__control");
    private final SelenideElement fieldMonth = $$(".input__inner").findBy(text("Месяц")).$(".input__control");
    private final SelenideElement fieldYear = $$(".input__inner").findBy(text("Год")).$(".input__control");
    private final SelenideElement fieldCardOwner = $$(".input__inner").findBy(text("Владелец")).$(".input__control");
    private final SelenideElement fieldCvcCvv = $$(".input__inner").findBy(text("CVC/CVV")).$(".input__control");

    private final SelenideElement payByCard = $$(".heading").find(exactText("Оплата по карте"));
    private final SelenideElement payByCardInCredit = $$(".heading").find(exactText("Кредит по данным карты"));
    private final SelenideElement messageSuccess = $$(".notification__content").find(exactText("Операция одобрена Банком."));
    private final SelenideElement messageFailure = $$(".notification__content").find(exactText("Ошибка! Банк отказал в проведении операции."));
    private final SelenideElement continueButton = $$(".button__content").find(text("Продолжить"));
    private final SelenideElement validationCardExpired = $$("span.input__sub").find(exactText("Истёк срок действия карты"));
    private final SelenideElement validationCardExpirationDateInvalid = $$("span.input__sub").find(exactText("Неверно указан срок действия карты"));
    private final SelenideElement validationFormatIncorrect = $$("span.input__sub").find(exactText("Неверный формат"));
    private final SelenideElement validationRequiredField = $$(".input__inner span.input__sub").find(exactText("Поле обязательно для заполнения"));


    public void buyByCard() {
        open("http://localhost:8080/");
        buttonBuyByCard.click();
        payByCard.shouldBe(visible);

    }

    public void buyByCardInCredit() {
        open("http://localhost:8080/");
        buttonBuyByCardInCredit.click();
        payByCardInCredit.shouldBe(visible);
    }


    public void setCardNumber(String number) {
        fieldCardNumber.setValue(number);
    }


    public void setCardMonth(String month) {
        fieldMonth.setValue(month);
    }


    public void setCardYear(String year) {
        fieldYear.setValue(year);
    }


    public void setCardOwner(String owner) {
        fieldCardOwner.setValue(owner);
    }


    public void setCardCVV(String cvc) {
        fieldCvcCvv.setValue(cvc);
    }


    public void clickContinueButton() {
        continueButton.click();
    }

    public void messageSuccess() {
        messageSuccess.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void messageFailure() {
        messageFailure.shouldBe(visible, Duration.ofSeconds(15));
    }

    public void messageFormatIncorrect() {
        validationFormatIncorrect.shouldBe(visible);
    }

    public void messageRequiredField() {
        validationRequiredField.shouldBe(visible);
    }

    public void messageInvalidDate() {
        validationCardExpirationDateInvalid.shouldBe(visible);
    }

    public void messageCardExpired() {
        validationCardExpired.shouldBe(visible);
    }
}
