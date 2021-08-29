package ru.geekbrains.tests;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class BaseTest {
    static Properties properties;
    static String host;
    static String username;
    static String token;


    @BeforeAll
    static void beforeAll() {
        properties=new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/application.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        host=properties.getProperty("host","https://api.imgur.com/3/");
        username=properties.getProperty("username","testprogmath");
        token=properties.getProperty("auth.token");

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.baseURI=host;

    }
}
