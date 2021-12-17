package com.company.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    public static boolean isValidDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate;
        try {
            localDate = LocalDate.parse(date, dateTimeFormatter);
        } catch (RuntimeException e) {
            return false;
        }

        return true;
    }

    public static boolean isValidExpDate(String date) { // 11/21
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        try {
            LocalDate expDate = LocalDate.parse("01/" + date, dateTimeFormatter); // dd-MM-yyyy
            if (expDate.isAfter(LocalDate.now())) {
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
            return false;
        }

        return false;
    }

    public static LocalDate getLocalDate(String date) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(date, dateTimeFormatter);
        } catch (RuntimeException e) {
            return null;
        }

        return localDate;
    }
}
