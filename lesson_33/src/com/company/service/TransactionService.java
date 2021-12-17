package com.company.service;

import com.company.component.ComponentContainer;
import com.company.entity.Card;
import com.company.entity.Transaction;
import com.company.entity.TransactionType;
import com.company.entity.User;
import com.company.enums.CardStatus;
import com.company.service.CommissionService;
import com.company.service.ScannerService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TransactionService  {

    private List<Transaction> transactionList = new LinkedList<>();

    public void startP2P(){

           String senderCardNumber = ScannerService.getString("Enter number");
           String recieverCArdNumber = ScannerService.getString("Enter number");
           Long amount = ScannerService.getLong("Enter Amount");

           Card senderCard =   ComponentContainer.cardService.getCardByNumber(senderCardNumber );
           Card recieverCard =  ComponentContainer.cardService.getCardByNumber(recieverCArdNumber );


           if (senderCard == null && recieverCArdNumber== null){
               System.out.println("Card not found");
               return;
           }

           if (!senderCard.getStatus().equals(CardStatus.ACTIVE) || !recieverCard.getStatus().equals(CardStatus.ACTIVE)){
               System.out.println("Card not Active");
               return;
           }
//1
           Double commission = CommissionService.getTransactionCommission(senderCard.getType(), recieverCard.getType());
           long commissionAmount = (long) ((amount/100) * commission);


           if (senderCard.getBalance() < amount + commissionAmount){
               System.out.println("not enough balance");
               return;

           }
           senderCard.setBalance(senderCard.getBalance() - amount);
           recieverCard.setBalance(recieverCard.getBalance() + amount);

           Transaction transaction = new Transaction();
           transaction.setRecieverCardNumber(recieverCArdNumber);
           transaction.setSenderCardNumber(senderCardNumber);
           transaction.setAmount(amount);
           transaction.setType(TransactionType.P2P);

           transactionList.add((transaction));
           System.out.println("Success");



    }
}
