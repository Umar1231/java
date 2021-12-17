package com.company.exceptions;

public class CardTypeNotFoundException  extends  RuntimeException{

    public CardTypeNotFoundException(String message) {
        super(message);
    }
}
