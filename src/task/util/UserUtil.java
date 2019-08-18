package task.util;

import task.regexpr.CheckRegExpr;
import task.user.User;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class UserUtil {
    public static void createUser() {
        User user = new User();
        ArrayList<User> users = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String email;
        String role;
        String phone;
        ArrayList<String> roles;
        ArrayList<String> phones;

        System.out.println("Введите имя пользователя:");
        user.setFirstName(scanner.nextLine());

        System.out.println("Введите фамилию пользователя:");
        user.setLastName(scanner.nextLine());

        System.out.println("Введие email пользователя:");
//        email = scanner.nextLine();
        while (!CheckRegExpr.checkEmail(email = scanner.nextLine())) {
            System.out.println("Неккоректный email, должны быть ‘@’ и точка:");
        }
        user.setEmail(email);

        System.out.println("Введите роли пользователя от 1 до 3-х:");
        while (!CheckRegExpr.checkRoles(role = scanner.nextLine())) {
            System.out.println("Ввведите непустое значение либо не больше 3-х");
        }
        roles = new ArrayList<>(Arrays.asList(role.split(",")));
        user.setRoles(roles);

        System.out.println("Введите от 1 до 3-х номеров телефона:");
        while (!CheckRegExpr.checkPhones(phone = scanner.nextLine())) {
            System.out.println("Введите корректный номер телефона вида (37500 1234567) и не больше 3-х");
        }
        phones = new ArrayList<>(Arrays.asList(phone.split(",")));
        user.setPhoneNumbers(phones);

        users = SerialUser.getUserList();
        users.add(user);
        saveUserList(users);
        System.out.println("Пользователь сохранен");

    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        users = SerialUser.getUserList();
        return users;
    }

    public static boolean userEmpty() {
        ArrayList<User> users = getUsers();
        if (users.isEmpty()) return true;
        return false;
    }

    public static void saveUserList(ArrayList<User> users) {
        SerialUser.saveUserList(users);
    }

    public static int getNumber() {
        ArrayList<User> users = UserUtil.getUsers();
        if (userEmpty()) {
//            System.out.println("Список пользователей пуст");
            return -1;
        }

        Scanner scanner = new Scanner(System.in);
        int number;

        System.out.println("Введите номер пользователя, чьи данные нужно изменить/удалить:");

        while (true) {
            try {
                number = Integer.valueOf(scanner.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Введите число:");
            }
        }

        if (number > users.size()) {
            System.out.println("Такого пользователя нет;");
            return -1;
        }
        return number;
    }

    public static void updateUser() {
        ArrayList<User> users = new ArrayList<>();

        int number = getNumber();

        if (number == -1) return;

        createUser();

        users = UserUtil.getUsers();

        User user = users.get(users.size() - 1);
        users.remove(users.size() - 1);

        users.add(number - 1, user);
        users.remove(number);

        saveUserList(users);

        System.out.println("Пользователь успешно обновлен");
    }

    public static void deleteUser() {
        ArrayList<User> users = UserUtil.getUsers();

        int number = getNumber();

        if (number == -1) return;

        users.remove(number - 1);

        saveUserList(users);

        System.out.println("Пользователь успешно удален");
    }
}
