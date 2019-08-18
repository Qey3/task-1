package task;

import task.user.User;
import task.util.SerialUser;
import task.util.UserUtil;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final String file = "serialUser.txt";
        ArrayList<User> users = new ArrayList<>();

        String s = "";
        Scanner scanner = new Scanner(System.in);

        while (!s.equals("exit")) {
            users = UserUtil.getUsers();
            if (!UserUtil.userEmpty()) {
                System.out.println("Список пользователей:");
                int i = 1;
                for (User buff : users) {
                    System.out.println(i + ": " + buff);
                    i++;
                }
            } else System.out.println("Список пользователей пуст;");

            System.out.println("Введите: 1-создать пользователя;");
            System.out.println("Введите: 2-редактировать пользователя;");
            System.out.println("Введите: 3-удалить пользователя;");
            System.out.println("Введите: 'exit', чтобы выйти из программы;");
            System.out.println("Введите код действия: ");

            switch (scanner.nextLine()) {
                case ("1"):
                    UserUtil.createUser();
                    break;
                case ("2"):
                    UserUtil.updateUser();
                    break;
                case ("3"):
                    UserUtil.deleteUser();
                    break;
                case ("exit"):
                    s = "exit";
                    break;
                default:
                    System.out.println("Неверная команда, попробуйте еще раз");
                    break;
            }
        }

    }
}
