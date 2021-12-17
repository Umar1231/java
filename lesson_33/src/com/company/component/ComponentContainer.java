package com.company.component;

import com.company.service.TransactionService;
import com.company.service.AuthService;
import com.company.service.CardService;
import com.company.service.SmsService;
import com.company.service.UserService;

public interface ComponentContainer {
    public static final UserService userService = new UserService();
    public static final AuthService authService = new AuthService();
    public static final SmsService smsService = new SmsService();
    public static final CardService cardService = new CardService();
    public static  final TransactionService transactionService = new TransactionService();

}
