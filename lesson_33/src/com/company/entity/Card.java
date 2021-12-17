package com.company.entity;

import com.company.enums.CardOwnerType;
import com.company.enums.CardStatus;
import com.company.enums.CardType;

public class Card extends BaseEntity {

    private String number;
    private String expDate;//card ni amal qilsh muddati;
    private String password;
    private Long balance;
    private String phone;
    private CardStatus status;
    private CardType type;
    private CardOwnerType ownerType;

    public Card() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpDate() {
        return expDate;
    }

    public void setExpDate(String expDate) {
        this.expDate = expDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CardStatus getStatus() {
        return status;
    }

    public void setStatus(CardStatus status) {
        this.status = status;
    }

    public CardType getType() {
        return type;
    }

    public void setType(CardType type) {
        this.type = type;
    }

    public CardOwnerType getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(CardOwnerType ownerType) {
        this.ownerType = ownerType;
    }
}
