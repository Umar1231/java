package com.company.service;


import com.company.component.ComponentContainer;
import com.company.entity.User;

public class UserService {
    private User authorizedUser;

    public void userMenu() {
        while (true) {
            showUserMenu();
            int num = ScannerService.getInt();
            switch (num) {
                case 1:
                    ComponentContainer.cardService.cardMenu();
                    break;
                case 2:
                    ComponentContainer.transactionService.startP2P();
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

    public void showUserMenu() {
        System.out.println("*** User Menu *** ");
        System.out.println("1. Card");
        System.out.println("2. P2P"); // kartadan kartaga
        System.out.println("3. Payment"); // oplata
        System.out.println("4. History"); // transaction
        System.out.println("5. Setting");
        System.out.println("0. Exit");
    }

    /*public void adminMenu() {
        while (true) {
            showAdminMenu();
            int num = ScannerService.getInt();
            switch (num) {
                case 1:
                    break;
                case 2:
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
    }*/

   /* public void showAdminMenu() {
        System.out.println("*** Admin Menu *** ");
        System.out.println("1. User");
        System.out.println("2. Card");
        System.out.println("3. SMS"); // kartadan kartaga
        System.out.println("3. Transaction"); // kartadan kartaga
        System.out.println("0. Exit");
    }*/

    public User getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(User authorizedUser) {
        this.authorizedUser = authorizedUser;
    }
}
