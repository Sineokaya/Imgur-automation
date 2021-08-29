package ru.geekbrains.tests;

import io.restassured.RestAssured;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class AccountTests extends  BaseTest{

    @Test
    void getAccountPositiveTest() {
        given()
                //.header("Authorization","Bearer 2cb41b3b38afc5c1c4b4c70107e16d69042f2eb6")
                .header("Authorization",token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                //.get("https://api.imgur.com/3/account/" +"testprogmath")
                .get("account/" +username)
                .prettyPeek()
                .then()
                .statusCode(200)
        .body("success", CoreMatchers.is(true))
        //.body("data.url",CoreMatchers.equalTo("testprogmath"));
                .body("data.url",CoreMatchers.equalTo(username));
    }

    @Test
    void getAccountSettingsTest() {
        given()
                .header("Authorization","Bearer 2cb41b3b38afc5c1c4b4c70107e16d69042f2eb6")
                .log()
                .all()
                .expect()
                .body("success",CoreMatchers.is(true))
                .body("data.account_url", CoreMatchers.equalTo("testprogmath"))
                .when()
                .get("https://api.imgur.com/3/account/testprogmath/settings")
                .prettyPeek()
                .then()
                .statusCode(200);


    }
}
