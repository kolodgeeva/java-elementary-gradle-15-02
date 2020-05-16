package com.hillel.lombok;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class MainJackson {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        //writeUser();

        readUser();


    }

    private static void readUser() throws IOException {
        User userFromJson = OBJECT_MAPPER.readValue(new File("user.json"), User.class);

        System.out.println(userFromJson);
    }

    private static void writeUser() throws IOException {
        User user = User.builder()
                .name("test")
                .surname("testovich")
                .age(30)
                .salary(3000)
                .build();

        OBJECT_MAPPER.writeValue(new File("user.json"), user);
    }
}
