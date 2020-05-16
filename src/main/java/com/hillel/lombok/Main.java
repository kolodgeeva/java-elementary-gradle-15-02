package com.hillel.lombok;

public class Main {

    public static void main(String[] args) {

        User user = new User();
        User user1 = new User("test", "", 10, 1000);

        user1.getAge();
        user1.getName();

        User user2 = User.builder()
                .age(12)
                .name("test")
                .build();

        User user3 = User.builder()
                .name("test")
                .build();

        System.out.println(user1);


    }

}
