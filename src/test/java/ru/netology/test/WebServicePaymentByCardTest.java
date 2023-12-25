package ru.netology.test;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import ru.netology.data.DataHelper;
import ru.netology.data.SQLHelper;
import ru.netology.page.WebServicePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebServicePaymentByCardTest {
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
    @DisplayName("1.Оплата тура по валидной банковской карте со статусом \"APPROVED\"")
    void testValidCardApproved() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }


    @Test
    @DisplayName("3.Оплата тура по валидной банковской карте со статусом \"DECLINED\"")
    void testValidCardDeclined() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberDeclined());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFailure();
        assertEquals("DECLINED", SQLHelper.getStatusOfPayment());
    }


    @Test
    @DisplayName("5.Оплата тура по карте. Пустые поля формы.")
    void testEmptyForm() {
        webServicePage.buyByCard();

        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("6.Оплата тура по карте. Пустое поле «Номер карты»")
    void testEmptyCardNumberField() {
        webServicePage.buyByCard();

        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();

    }

    @Test
    @DisplayName("7.Оплата тура по карте. Пустое поле «Месяц».")
    void testEmptyCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());

        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("8.Оплата тура по карте. Пустое поле «Год».")
    void testEmptyCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());

        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("9.Оплата тура по карте. Пустое поле «Владелец».")
    void testEmptyCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));

        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("10.Оплата тура по карте. Пустое поле «CVC/CVV».")
    void testEmptyCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());

        webServicePage.clickContinueButton();
        webServicePage.messageRequiredField();
    }

    @Test
    @DisplayName("16.Оплата тура по карте. Заполнение поля «Номер карты» 15-ю цифрами.")
    void testWrongLowerQuantityOfDigitsInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getNumbers(15));
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("17.Оплата тура по карте. Заполнение поля «Номер карты» 17-ю цифрами.")
    void testWrongHigherQuantityOfDigitsInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getNumbers(17));
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFailure();
    }

    @Test
    @DisplayName("18.Оплата тура по карте. Заполнение поля «Номер карты» символами на латинице.")
    void testWrongCharsLatinInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getLatinChars());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("19.Оплата тура по карте. Заполнение поля «Номер карты» символами на кириллице.")
    void testWrongCharsCyrillicInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getCyrillicChars());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("20.Оплата тура по карте. Заполнение поля «Номер карты» иероглифами.")
    void testWrongCharsHieroglyphInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getHieroglyph());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("21.Оплата тура по карте. Заполнение поля «Номер карты» спецсимволами.")
    void testWrongSpecCharsInCardNumberField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getChar());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("22.Оплата тура по карте. Заполнение поля «Месяц» 1-й цифрой.")
    void testOneDigitInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getNumbers(1));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("23.Оплата тура по карте. Заполнение поля «Месяц» 3-мя цифрами.")
    void testThreeDigitsInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getInputChar("012"));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
    }

    @Test
    @DisplayName("24.Оплата тура по карте. Заполнение в поле «Месяц» несуществующего месяца.")
    void testNonExistentValueInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getInvalidMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("25.Оплата тура по карте. Заполнение в поле «Месяц» невалидного значения месяца.")
    void testInvalidValueInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonthBefore());
        webServicePage.setCardYear(DataHelper.getCurrentYear());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("26.Оплата тура по карте. Заполнение в поле «Месяц» двузначного числа, значение которого больше 12.")
    void testInvalidValueInCardMonthFieldTwoDigits() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getNumbersBetween(12, 99));
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("27.Оплата тура по карте. Заполнение поля «Месяц» символами на латинице.")
    void testLatinCharsInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getLatinChars());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("28.Оплата тура по карте. Заполнение поля «Месяц» символами на кириллице.")
    void testCyrillicCharsInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCyrillicChars());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("29.Оплата тура по карте. Заполнение поля «Месяц» иероглифами.")
    void testHieroglyphCharsInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getHieroglyph());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("30.Оплата тура по карте. Заполнение поля «Месяц» спецсимволами.")
    void testSpecCharsInCardMonthField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getChar());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("31.Оплата тура по карте. Заполнение поля «Год» 1-й цифрой.")
    void testOneDigitInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getNumbers(1));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("32.Оплата тура по карте. Заполнение поля «Год» 3-мя цифрами.")
    void testThreeDigitsInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getInputChar("024"));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageCardExpired();
    }

    @Test
    @DisplayName("33.Оплата тура по карте. Заполнение поля «Год» прошедшим годом.")
    void testLastYearInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearBefore());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageCardExpired();
    }

    @Test
    @DisplayName("34.Оплата тура по карте. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 5 лет.")
    void testFiveYearsAboveInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("35.Оплата тура по карте. Заполнение в поле «Год» двузначного числа, значение которого больше текущего года на 6 лет.")
    void testSixYearsAboveInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(6));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageInvalidDate();
    }

    @Test
    @DisplayName("36.Оплата тура по карте. Заполнение поля «Год» символами на латинице.")
    void testLatinCharsInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getLatinChars());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("37.Оплата тура по карте. Заполнение поля «Год» символами на кириллице.")
    void testCyrillicCharsInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getCyrillicChars());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("38.Оплата тура по карте. Заполнение поля «Год» иероглифами.")
    void testHieroglyphCharsInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getHieroglyph());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("39.Оплата тура по карте. Заполнение поля «Год» спецсимволами.")
    void testSpecCharsInCardYearField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getChar());
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("40.Оплата тура по карте. Заполнение поля «Владелец» 1-м символом латиницы.")
    void testOneLatinCharInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(String.valueOf(DataHelper.getRandomOneLatinChar()));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("41.Оплата тура по карте. Заполнение поля «Владелец» 1-й цифрой.")
    void testOneDigitInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getNumbers(1));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("42.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на кириллице.")
    void testCyrillicNameInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerCyrillic());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("43.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии, состоящих из одного символа на латинице каждый")
    void testFirstAndLastNamesOneLatinCharEachInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("I U"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("44.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через дефис.")
    void testDoubleLatinNameWithHyphenInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("45.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойные имя и фамилия через дефис.")
    void testDoubleLatinNameAndLastNameWithHyphenInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya Pushkina-Romanova"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("46.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя и двойная фамилия через дефис.")
    void testTripleLatinNameAndDoubleLastNameWithHyphenInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna-Mariya-Jannet Pushkina-Romanova"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("47.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Двойное имя через пробел.")
    void testDoubleLatinNameWithSpaceInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna Mariya Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("48.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице. Тройное имя через пробелы.")
    void testTripleLatinNameWithSpacesInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Anna Mariya Jannet Pushkina"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("49.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице с использованием апострофа «’».")
    void testNameWithSpecCharInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara O’Hara"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("50.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на цифру.")
    void testNameWithDigitInTheEndOfCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara Conner0"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("51.Оплата тура по карте. Заполнение в поле «Владелец» имени и фамилии на латинице, оканчивающихся на спецсимвол.")
    void testNameWithSpecCharInTheEndOfCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("Sara Conner@"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("52.Оплата тура по карте. Заполнение в поле «Владелец» одним спецсимволом.")
    void testSpecCharInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getChar());
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("53.Оплата тура по карте. Заполнение в поле «Владелец» иероглифами.")
    void testHieroglyphInCardOwnerField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getInputChar("亚历山大·普希金"));
        webServicePage.setCardCVV(DataHelper.getNumbers(3));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("54.Оплата тура по карте. Заполнение в поле «CVC/CVV» нулями.")
    void testZerosInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getZero(3));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("55.Оплата тура по карте. Заполнение в поле «CVC/CVV» 2-мя цифрами.")
    void testTwoDigitsInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(2));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("56.Оплата тура по карте. Заполнение в поле «CVC/CVV» 4-х цифр.")
    void testFourDigitsInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getNumbers(4));
        webServicePage.clickContinueButton();
        webServicePage.messageSuccess();
        assertEquals("APPROVED", SQLHelper.getStatusOfPayment());
    }

    @Test
    @DisplayName("57.Оплата тура по карте. Заполнение в поле «CVC/CVV» латиницы.")
    void testLatinCharInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("wow"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("58.Оплата тура по карте. Заполнение в поле «CVC/CVV» кириллицы.")
    void testCyrillicCharInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("ого"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("59.Оплата тура по карте. Заполнение в поле «CVC/CVV» спецсимволов.")
    void testSpecCharInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("@#$"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }

    @Test
    @DisplayName("60.Оплата тура по карте. Заполнение в поле «CVC/CVV» иероглифов.")
    void testHieroglyphInCardCvcCvvField() {
        webServicePage.buyByCard();
        webServicePage.setCardNumber(DataHelper.getValidCardNumberApproved());
        webServicePage.setCardMonth(DataHelper.getCurrentMonth());
        webServicePage.setCardYear(DataHelper.getYearRange(5));
        webServicePage.setCardOwner(DataHelper.getCardOwnerLatin());
        webServicePage.setCardCVV(DataHelper.getInputChar("普希金"));
        webServicePage.clickContinueButton();
        webServicePage.messageFormatIncorrect();
    }
}
