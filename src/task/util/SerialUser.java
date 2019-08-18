package task.util;

import task.user.User;

import java.io.*;
import java.util.ArrayList;

public class SerialUser {
    public static final String file = "serialUser.txt";

    public static void saveUserList(ArrayList<User> users) {
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream(file));
            objectOutputStream.writeObject(users);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUserList() {
        ArrayList<User> users = new ArrayList<>();
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(
                    new FileInputStream(file));
            users = ((ArrayList<User>) objectInputStream.readObject());
            objectInputStream.close();
        } catch (IOException e) {
//            e.printStackTrace();
            saveUserList(users);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
}
