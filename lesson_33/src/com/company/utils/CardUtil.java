package com.company.utils;

import com.company.enums.CardType;

public class CardUtil {
    public static boolean isValidCardNumber(String cardNumber) {
        if (cardNumber.length() != 16) {
            return false;
        }
        for (char c : cardNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static CardType getCardType(String cardNumber) {
        if (cardNumber.startsWith("8600")) {
            return CardType.UZCARD;
        } else if (cardNumber.startsWith("9860")) {
            return CardType.HUMO;
        } else if (cardNumber.startsWith("4000") || cardNumber.startsWith("4100")) {
            return CardType.VISA;
        } else {
            return null;
        }
    }

}
