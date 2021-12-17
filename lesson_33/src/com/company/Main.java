package com.company;

import com.company.utils.DateUtil;

public class Main {

    public static void main(String[] args) {
        BankSystem bankSystem = new BankSystem();
        bankSystem.init();
        bankSystem.start();

       /* for (int i = 0; i < 10; i++) {
            String id = UUID.randomUUID().toString();
            System.out.println(id);
        }*/

        // 1. UserChange password
        // User - Card - add, card list, + balance -- 1dan ortiq. UserCard/CompanyCard
        // Company - + Card,
        // Company(name,card,id,createdDate, ) add,list, delete, update
        // Admin(Menu -> Company)
//        System.out.println(DateUtil.isValidExpDate("12/21"));

    }
}
