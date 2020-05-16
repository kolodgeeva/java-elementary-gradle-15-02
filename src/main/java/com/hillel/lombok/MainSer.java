package com.hillel.lombok;

import java.io.*;

public class MainSer {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        writeUser();
        readUser();

    }

    private static void readUser() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("user.dat");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        Object object = objectInputStream.readObject();

        objectInputStream.close();
        fileInputStream.close();

        User userFromFile = (User) object;

        System.out.println("before:");
        System.out.println(userFromFile);
    }

    private static void writeUser() throws IOException {
        User user = User.builder()
                .age(20)
                .name("Mariana")
                .surname("Kolodzheieva")
                .build();

        System.out.println("before:");
        System.out.println(user);

        FileOutputStream fileOutputStream = new FileOutputStream("user.dat");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(user);

        objectOutputStream.close();
        fileOutputStream.close();
    }
}
