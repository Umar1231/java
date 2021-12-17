package com.company.service;

import com.company.component.ComponentContainer;
import com.company.entity.Sms;
import com.company.entity.User;
import com.company.enums.UserRole;
import com.company.enums.UserStatus;
import com.company.utils.PasswordUtil;
import com.company.utils.PhoneUtil;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class AuthService {
    private List<User> userList = new LinkedList<>();

    public boolean registration() {
        System.out.println("*** Registration ***");

        String name = ScannerService.getString("Enter Name: ");

        String surname = ScannerService.getString("Enter Surname: ");

        String phone;

        do {
            phone = ScannerService.getString("Enter Phone: ");
            if (!PhoneUtil.isValidPhone(phone)) {
                System.out.println("Phone not valid.");
                continue;
            }
            if (isPhoneExists(phone)) {
                System.out.println("Phone is exist.");
                continue;
            }
            break;
        } while (true);

        String password;
        do {
            password = ScannerService.getString("Enter Password: ");
        } while (!PasswordUtil.isValidPassword(password));

        String confirm;
        do {
            confirm = ScannerService.getString("Confirm Password: ");
        } while (!password.equals(confirm));

        Sms sms;
        String code;
        boolean shouldContinue;
        ComponentContainer.smsService.sendAndCheckSms(phone);

        User user = new User();
        user.setName(name);
        user.setSurname(surname);
        user.setPhone(phone);
        user.setPassword(password);
        user.setRole(UserRole.CLIENT);
        user.setStatus(UserStatus.ACTIVE);

        userList.add(user);
        System.out.println("Registration completed");
        return true;
    }

    public boolean isPhoneExists(String phone) {
        for (User user : userList) {
            if (user.getPhone().equals(phone)) {
                return true;
            }
        }
        return false;
    }

    public User logIn() {
        System.out.println("*** LogIn ***");
        System.out.print("Enter Phone: ");
        String phone = ScannerService.getString();

        System.out.print("Enter Password: ");
        String password = ScannerService.getString();
        for (User user : userList) {
            if (user.getPhone().equals(phone) &&
                    user.getPassword().equals(password) &&
                    user.getStatus().equals(UserStatus.ACTIVE)) {
                System.out.println("Successfully");
                System.out.println("# Welcome: " + user.getName());
                return user;
            }
        }
        System.out.println("Phone or Password is Wrong.");
        return null;
    }

    public void init() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Alish");
        user.setSurname("Alishov");
        user.setPhone("998123456789");
        user.setPassword("123123Aa");
        user.setRole(UserRole.ADMIN);

        userList.add(user);

        user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setName("Ali");
        user.setSurname("Aliyev");
        user.setPhone("998915721213");
        user.setPassword("12345Aa");
        user.setRole(UserRole.CLIENT);

        userList.add(user);
    }
}
