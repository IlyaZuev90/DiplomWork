package ru.netology.data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataHelper {
    private static final Faker faker = new Faker(new Locale("en"));

    public static String getValidCardNumberApproved() {
        return "4444 4444 4444 4441";
    }

    public static String getValidCardNumberDeclined() {
        return "4444 4444 4444 4442";
    }

    public static String getNumbers(int quantity) {
        return String.format(faker.number().digits(quantity));
    }

    public static String getZero(int quantity) {
        String zero = "0";
        for (int i = quantity - 1; i > 0; i--) {
            zero = zero + "0";
        }
        return zero;
    }

    public static String getMonth() {
        return String.format("%02d", faker.number().numberBetween(1, 12));
    }

    public static String getNumbersBetween(int min, int max) {
        return String.format("%02d", faker.number().numberBetween(min, max));
    }

    public static String getCurrentMonth() {
        LocalDate currentMonth = LocalDate.now();

        return currentMonth.format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getMonthBefore() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneMonthBefore = currentDate.minusMonths(1);
        return oneMonthBefore.format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getCurrentYear() {
        LocalDate currentYear = LocalDate.now();

        return currentYear.format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearBefore() {
        LocalDate currentDate = LocalDate.now();
        LocalDate oneYearBefore = currentDate.minusYears(1);
        return oneYearBefore.format(DateTimeFormatter.ofPattern("yy"));
    }

    public static String getYearRange(int range) {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int modifiedYear = currentYear + range;
        return String.format("%02d", modifiedYear % 100);
    }

    public static String getInvalidMonth() {
        return "00";
    }

    public static String getInputChar(String value) {
        return value;
    }

    public static String getCardOwnerLatin() {
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getLatinChars() {

        String[] generateLatinChars = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        return generateLatinChars[new Random().nextInt(generateLatinChars.length)];
    }


    public static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static char getRandomOneLatinChar() {
        return getRandomCharacter('a', 'z');
    }

    public static String getCardOwnerCyrillic() {
        var faker = new Faker(new Locale("ru"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getCyrillicChars() {
        String[] generateCyrillicChars = {"а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о", "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"};
        return generateCyrillicChars[new Random().nextInt(generateCyrillicChars.length)];
    }

    public static String getHieroglyph() {
        String[] generateChineseHieroglyphs = {"刃", "令", "難", "骨", "詩", "海", "起", "及", "英", "次", "誤", "能", "函", "純", "船", "述", "窗"};
        return generateChineseHieroglyphs[new Random().nextInt(generateChineseHieroglyphs.length)];
    }

    public static String getChar() {
        String[] generateChar = {"!", "@", "#", "№", "$", ";", "%", "^", ":", "&", "?", "*", "(", ")", "-", "_", "+", "=", "`", "~"};

        return generateChar[new Random().nextInt(generateChar.length)];
    }

}
