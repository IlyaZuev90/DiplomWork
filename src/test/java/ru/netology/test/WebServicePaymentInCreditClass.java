package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.WebServicePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServicePaymentInCreditClass {
    WebServicePage webServicePage = new WebServicePage();

    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterAll
    static void tearDownAll() {
        SelenideLogger.removeListener("allure");
    }

    @AfterEach
    void cleanDB() {
        SQLHelper.cleanDataBase();
    }

    @Test
    @DisplayName("2.Оплата тура в кредит по валидной банковской карте со статусом \"APPROVED\"")
    void testValidCardInCreditApproved() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("4.Оплата тура в кредит по валидной банковской карте со статусом \" DECLINED\"")
    void testValidCardInCreditDeclined() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberDeclined());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFailure();
        assertEquals("DECLINED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("11.Оплата тура по карте в кредит. Пустое поле «Номер карты»")
    void testEmptyCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();

        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();

    }

    @Test
    @DisplayName("12.Оплата тура по карте в кредит. Пустое поле «Месяц».")
    void testEmptyCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());

        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("13.Оплата тура по карте в кредит. Пустое поле «Год».")
    void testEmptyCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());

        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("14.Оплата тура по карте в кредит. Пустое поле «Владелец».")
    void testEmptyCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));

        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("15.Оплата тура по карте в кредит. Пустое поле «CVC/CVV».")
    void testEmptyCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());

        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("61.Оплата тура по карте в кредит. Заполнение поля «Номер карты» 15-ю цифрами.")
    void testWrongLowerQuantityOfDigitsInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getNumbers(15));
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("62.Оплата тура по карте в кредит. Заполнение поля «Номер карты» 17-ю цифрами.")
    void testWrongHigherQuantityOfDigitsInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getNumbers(17));
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFailure();
    }

    @Test
    @DisplayName("63.Оплата тура по карте в кредит. Заполнение поля «Номер карты» символами на латинице.")
    void testWrongCharsLatinInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getLatinChars());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("64.Оплата тура по карте в кредит. Заполнение поля «Номер карты» символами на кириллице.")
    void testWrongCharsCyrillicInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getCyrillicChars());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("65.Оплата тура по карте в кредит. Заполнение поля «Номер карты» иероглифами.")
    void testWrongCharsHieroglyphInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getHieroglyph());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("66.Оплата тура по карте в кредит. Заполнение поля «Номер карты» спецсимволами.")
    void testWrongSpecCharsInCardNumberFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getChar());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("67.Оплата тура по карте в кредит. Заполнение поля «Месяц» 1-й цифрой.")
    void testOneDigitInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getNumbers(1));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("68.Оплата тура по карте в кредит. Заполнение поля «Месяц» 3-мя цифрами.")
    void testThreeDigitsInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getInputChar("012"));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
    }

    @Test
    @DisplayName("69.Оплата тура по карте в кредит. Заполнение в поле «Месяц» несуществующего месяца.")
    void testNonExistentValueInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getInvalidMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("70.Оплата тура по карте в кредит. Заполнение в поле «Месяц» невалидного значения месяца.")
    void testInvalidValueInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonthBefore());
        webServicePage.setCardYear(DataHelper.getCurrentYear());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("71.Оплата тура по карте в кредит. Заполнение в поле «Месяц» двузначного числа, значение которого больше 12.")
    void testInvalidValueInCardMonthFieldTwoDigitsInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getNumbersBetween(12, 99));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("72.Оплата тура по карте в кредит. Заполнение поля «Месяц» символами на латинице.")
    void testLatinCharsInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getLatinChars());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("73.Оплата тура по карте в кредит. Заполнение поля «Месяц» символами на кириллице.")
    void testCyrillicCharsInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCyrillicChars());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("74.Оплата тура по карте в кредит. Заполнение поля «Месяц» иероглифами.")
    void testHieroglyphCharsInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getHieroglyph());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("75.Оплата тура по карте в кредит. Заполнение поля «Месяц» спецсимволами.")
    void testSpecCharsInCardMonthFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getChar());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("76.Оплата тура по карте в кредит. Заполнение поля «Год» 1-й цифрой.")
    void testOneDigitInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getNumbers(1));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("77.Оплата тура по карте в кредит. Заполнение поля «Год» 3-мя цифрами.")
    void testThreeDigitsInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getInputChar("024"));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageCardExpired();
    }

    @Test
    @DisplayName("78.Оплата тура по карте в кредит. Заполнение поля «Год» прошедшим годом.")
    void testLastYearInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearBefore());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageCardExpired();
    }

    @Test
    @DisplayName("79.Оплата тура по карте в кредит. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 5 лет.")
    void testFiveYearsAboveInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("80.Оплата тура по карте в кредит. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 6 лет.")
    void testSixYearsAboveInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(6));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("81.Оплата тура по карте в кредит. Заполнение поля «Год» символами на латинице.")
    void testLatinCharsInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getLatinChars());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("82.Оплата тура по карте в кредит. Заполнение поля «Год» символами на кириллице.")
    void testCyrillicCharsInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getCyrillicChars());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("83.Оплата тура по карте в кредит. Заполнение поля «Год» иероглифами.")
    void testHieroglyphCharsInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getHieroglyph());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("84.Оплата тура по карте в кредит. Заполнение поля «Год» спецсимволами.")
    void testSpecCharsInCardYearFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getChar());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("85.Оплата тура по карте в кредит. Заполнение поля «Владелец» 1-м символом латиницы.")
    void testOneLatinCharInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(String.valueOf(DataHelper.getRandomOneLatinChar()));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("86.Оплата тура по карте в кредит. Заполнение поля «Владелец» 1-й цифрой.")
    void testOneDigitInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getNumbers(1));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("87.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на кириллице.")
    void testCyrillicNameInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerCyrillic());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("88.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии, состоящих из одного символа на латинице каждый")
    void testFirstAndLastNamesOneLatinCharEachInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("I U"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("89.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через дефис.")
    void testDoubleLatinNameWithHyphenInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("90.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойные имя и фамилия через дефис.")
    void testDoubleLatinNameAndLastNameWithHyphenInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya Pushkina-Romanova"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("91.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя и двойная фамилия через дефис.")
    void testTripleLatinNameAndDoubleLastNameWithHyphenInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya-Jannet Pushkina-Romanova"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("92.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через пробел.")
    void testDoubleLatinNameWithSpaceInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna Mariya Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("93.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя через пробелы.")
    void testTripleLatinNameWithSpacesInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna Mariya Jannet Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("94.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице с использованием апострофа «’».")
    void testNameWithSpecCharInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara O’Hara"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("95.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на цифру.")
    void testNameWithDigitInTheEndOfCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara Conner0"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("96.Оплата тура по карте в кредит. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на спецсимвол.")
    void testNameWithSpecCharInTheEndOfCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara Conner@"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("97.Оплата тура по карте в кредит. Заполнение в поле «Владелец» одним спецсимволом.")
    void testSpecCharInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getChar());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("98.Оплата тура по карте в кредит. Заполнение в поле «Владелец» иероглифами.")
    void testHieroglyphInCardOwnerFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("亚历山大·普希金"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("99.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» нулями.")
    void testZerosInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getZero(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("100.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» 2-мя цифрами.")
    void testTwoDigitsInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(2));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("101.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» 4-х цифр.")
    void testFourDigitsInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(4));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfCredit());
    }

    @Test
    @DisplayName("102.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» латиницы.")
    void testLatinCharInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("wow"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("103.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» кириллицы.")
    void testCyrillicCharInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("ого"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("104.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» спецсимволов.")
    void testSpecCharInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("@#$"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("105.Оплата тура по карте в кредит. Заполнение в поле «CVC/CVV» иероглифов.")
    void testHieroglyphInCardCvcCvvFieldInCredit() {
        webServicePage.buyByCardInCredit();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("普希金"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

}
