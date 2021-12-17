package com.company.entity;

public class Transaction extends  BaseEntity {
    private String senderCardNumer;
    private String recieverCardNumber;
    private Long amount;
    private Double comPer;
    private TransactionType type;


    public Transaction( ) {

    }

    public String getSenderCardNumber() {
        return senderCardNumer;
    }

    public void setSenderCardNumber(String senderCard) {
        this.senderCardNumer = senderCard;
    }

    public String getRecieverCardNumber() {
        return recieverCardNumber;
    }

    public void setRecieverCardNumber(String recieverCardNumber) {
        this.recieverCardNumber = recieverCardNumber;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getComPer() {
        return comPer;
    }

    public void setComPer(Double comPer) {
        this.comPer = comPer;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
