package data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataHelper {
    @Value
    public static class CardInfo {
        String cardNumber;
        String month;
        String year;
        String cardHolder;
        String cvc;
    }

    public static String getShiftedMonth(int monthCount) {
        return LocalDate.now().plusMonths(monthCount).format(DateTimeFormatter.ofPattern("MM"));
    }

    public static String getShiftedYear(int yearCount) {
        return LocalDate.now().plusYears(yearCount).format(DateTimeFormatter.ofPattern("yy"));
    }

    public static CardInfo getApprovedCard() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(5);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getDeclinedCard() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(3);
        String year = getShiftedYear(2);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444442", month, year, holder, cvv);
    }

    public static CardInfo getEmptyCard() {
        return new CardInfo("", "", "", "", "");
    }


    public static CardInfo getNumberCard15Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        String number = faker.number().digits(15);
        return new CardInfo(number, month, year, holder, cvv);
    }

    public static CardInfo getCardNotInDatabase() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("1444444444444444", month, year, holder, cvv);
    }

    public static CardInfo getCardMonth1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = faker.number().digit();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardMonthOver12() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", "13", year, holder, cvv);
    }

    public static CardInfo getCardMonthPreviousToThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(0);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", "06", year, holder, cvv);
    }

    public static CardInfo getCardMonth00OverThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", "00", year, holder, cvv);
    }

    public static CardInfo getCardYear1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = faker.number().digit();
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardYearOverThisYearOn6() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(6);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardYearUnderThisYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(-1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardYear00() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, "00", holder, cvv);
    }

    public static CardInfo getCardCvv1Symbol() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(1);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardCvv2Symbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(2);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardHolder1Word() {
        Faker faker = new Faker();
        String holder = faker.name().firstName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardHolderCirillic() {
        Faker faker = new Faker(new Locale("ru"));
        String holder = faker.name().firstName() + " " + faker.name().lastName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardHolderWithNumbers() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.number().digit();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getCardSpecialSymbols() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " %$ * &";
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, holder, cvv);
    }

    public static CardInfo getIgnoreTheCardMonth() {
        Faker faker = new Faker();
        String holder = faker.name().firstName();
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", "", year, holder, cvv);
    }

    public static CardInfo getIgnoreTheCardNumbers() {
        Faker faker = new Faker();
        String holder = faker.name().firstName();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("", month, year, holder, cvv);
    }

    public static CardInfo getIgnoreTheCardYear() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.number().digit();
        String month = getShiftedMonth(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, "", holder, cvv);
    }

    public static CardInfo getIgnoringTheCaldholder() {
        Faker faker = new Faker();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        String cvv = faker.number().digits(3);
        return new CardInfo("4444444444444441", month, year, "", cvv);
    }
    public static CardInfo getIgnoreCvvCards() {
        Faker faker = new Faker();
        String holder = faker.name().firstName() + " " + faker.number().digit();
        String month = getShiftedMonth(1);
        String year = getShiftedYear(1);
        return new CardInfo("4444444444444441", month, year, holder, "");
    }
}