package com.hillel.lombok;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MainJacksonUsers {

    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static void main(String[] args) throws IOException {

        readUsers();


    }

    private static void readUsers() throws IOException {
        List<User> usersFromJson = OBJECT_MAPPER.readValue(new File("users.json"), new TypeReference<>() {});

        usersFromJson.forEach(System.out::println);

    }

}
