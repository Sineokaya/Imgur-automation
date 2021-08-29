package ru.geekbrains.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class DeleteImageTests extends BaseTest{
    String imageDeleteHash;
    String imageDeleteHash2;
    String imageDeleteId;
    @BeforeEach
    void setUpHash() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/img.png"))
                .when()
                .post("/image")
                .jsonPath()
                .get("data.deletehash");
    }
    @BeforeEach
    void setUpId() {
        imageDeleteId = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/img2.png"))
                .when()
                .post("/image")
                .jsonPath()
                .get("data.id");

    }
    @BeforeEach
    void setUpHashNoAuthorization() {
        imageDeleteHash2 = given()
                .header("Authorization", token)
                .body(new File("src/test/resources/images/img.png"))
                .when()
                .post("/image")
                .jsonPath()
                .get("data.deletehash");
    }

    @Test
    void deleteExistentImageHashTest() {
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void deleteExistentImageIdTest() {
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteId)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    void deleteExistentImageNoAuthorizationTest() {
        given()
               // .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteId)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}