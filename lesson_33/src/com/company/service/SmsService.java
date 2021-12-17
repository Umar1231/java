package com.company.service;

import com.company.component.ComponentContainer;
import com.company.entity.Sms;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SmsService {
    private List<Sms> smsList = new LinkedList<>();

    public Sms sendSms(String phone) {
        String code = getRandomNumber();
        Sms sms = new Sms();
        sms.setContent(code);
        sms.setPhone(phone);
        smsList.add(sms);
        System.out.println("Sending sms... " + sms);
        return sms;
    }

    public String getRandomNumber() {
        Random r = new Random();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            s.append(r.nextInt(9)); // 0...9
        }
        return s.toString();
    }

    public void showSmsList() {
        // ....
    }

    public List<Sms> getUserSmsList(String phone) {
        return null;
    }

    public void sendAndCheckSms(String phone) {
        do {
            Sms sms = sendSms(phone);
            System.out.println("We send Sms to " + phone);
            String code = ScannerService.getString("Enter Sms Code: ");

            if (!sms.getContent().equals(code)) {
                continue;
            }
            // 36 + 1   37 -> 36.5

            if (!sms.getCreatedDate().plusMinutes(1).isAfter(LocalDateTime.now())) {
                continue;
            }
            break;
        } while (true);

    }
}
