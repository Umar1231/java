package com.company.service;

import com.company.component.ComponentContainer;
import com.company.entity.Card;
import com.company.entity.Sms;
import com.company.entity.User;
import com.company.enums.CardOwnerType;
import com.company.enums.CardStatus;
import com.company.utils.CardUtil;
import com.company.utils.DateUtil;
import com.company.utils.PasswordUtil;

import javax.jws.soap.SOAPBinding;
import java.util.LinkedList;
import java.util.List;

public class CardService {
    private List<Card> cardList = new LinkedList<>();

    public void addCard() {
        do {
            Card card = getCardInfo();
            if (isValidCard(card)) {
                User user = ComponentContainer.userService.getAuthorizedUser();
                ComponentContainer.smsService.sendAndCheckSms(user.getPhone());
                card.setBalance(0L);
                card.setPhone(user.getPhone());
                card.setOwnerType(CardOwnerType.USER);
                card.setStatus(CardStatus.ACTIVE);
                card.setType(CardUtil.getCardType(card.getNumber()));
                cardList.add(card);
                return;
            }
        } while (true);
    }

    private Card getCardInfo() {
        System.out.println("*** Adding a Card ***");

        System.out.print("Enter Card number: ");
        String cardNumber = ScannerService.scanner.next();

        System.out.print("Enter Card Expired Date: ");
        String expDate = ScannerService.scanner.next();

        System.out.print("Enter Card password: ");
        String password = ScannerService.scanner.next();

        Card card = new Card();
        card.setNumber(cardNumber);
        card.setExpDate(expDate);
        card.setPassword(password);
        return card;
    }

    private boolean isValidCard(Card card) {
        if (!CardUtil.isValidCardNumber(card.getNumber())) {
            System.out.println("Card Number is wrong.");
            return false;
        }

        if (!DateUtil.isValidExpDate(card.getExpDate())) {
            System.out.println("Card ExpDate is wrong.");
            return false;
        }
        return true;
    }

    public void cardMenu() {
        User user = ComponentContainer.userService.getAuthorizedUser();
        while (true) {
            showCardMenu();
            int num = ScannerService.getInt();
            switch (num) {
                case 1:
                    addCard();
                    break;
                case 2:
                    showUserCard(user.getPhone());
                    break;
                case 3:
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Wrong Option");
                    break;
            }
        }
    }

    private void showUserCard(String phone) {
        for (Card c : cardList) {
            if (c.getPhone().equals(phone)) {
                System.out.println(c);
            }
        }
    }

    public void showCardMenu() {
        System.out.println("*** Card Menu *** ");
        System.out.println("1. Add Card");
        System.out.println("2. Card List");
        System.out.println("3. Change Card Status");
        System.out.println("4. Delete Card");
        System.out.println("0. Exit");
    }

    public  Card getCardByNumber (String number){
        for (Card card : cardList){
            if(card.getNumber().equals(number)){
                return card ;
            }
        }
        return null;
    }

}
