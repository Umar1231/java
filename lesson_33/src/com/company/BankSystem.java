package com.company;

import com.company.component.ComponentContainer;
import com.company.entity.User;
import com.company.enums.UserRole;
import com.company.service.ScannerService;

public class BankSystem {

    public void start() {
        while (true) {
            showMainMenu();
            int num = ScannerService.getInt();
            switch (num) {
                case 1:
                    User user = ComponentContainer.authService.logIn();
                    if (user != null) {
                        ComponentContainer.userService.setAuthorizedUser(user);
                        if (user.getRole().equals(UserRole.CLIENT)) {
                            ComponentContainer.userService.userMenu();
                        }
                    }
                    break;
                case 2:
                    ComponentContainer.authService.registration();
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

    public void showMainMenu() {
        System.out.println("***** Menu ***** ");
        System.out.println("1. LogIn");
        System.out.println("2. Registration");
        System.out.println("3. Currency");
        System.out.println("0. Exit");
        System.out.print("Choose Option: ");
    }

    public void init() {
        ComponentContainer.authService.init();
    }

}
