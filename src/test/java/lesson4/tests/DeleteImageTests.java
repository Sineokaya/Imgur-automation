package lesson4.tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;


import static lesson4.Images.IMAGE_FILE1;

import static lesson4.Images.IMG2_PNG;


public class DeleteImageTests extends BaseTest {

    String imageDeleteHash;
    String imageDeleteId;
    @BeforeEach
    void setUp() {
        imageDeleteHash = given()
                .header("Authorization", token)
                .body(new File(IMAGE_FILE1.getPath()))
                .when()
                .post("/image")
                .jsonPath()
                .get("data.deletehash");
    }

    @BeforeEach
    void setUp2() {
        imageDeleteId = given()
                .header("Authorization", token)
                .body(new File(IMG2_PNG.getPath()))
                .when()
                .post("/image")
                .jsonPath()
                .get("data.id");
    }

    @Test
    @Feature("deleteImageHashTest")
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
    @Feature("DeleteImageId")
    void deleteExistentImageIDTest() {
        given()
                .header("Authorization", token)
                .when()
                .delete("image/{imageHash}", imageDeleteId)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

    @Test
    @Feature("DeleteImageNoAuth")
    void deleteExistentImageNoAuthTest() {
        given()
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
}


