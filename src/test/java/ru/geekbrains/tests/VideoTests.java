package ru.geekbrains.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class VideoTests extends BaseTest {
    String imageDeleteHash;
    @Test
    void videoUploadSmallTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/small.mp4")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void videoUploadBigTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/big.mp4")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void videoUploadNormalTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/normal.mp4")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }


    @AfterEach
    void tearDown() {
        given()
                .header("Authorization",token)
                .when()
                .delete("image/{imageHash}", imageDeleteHash)
                .then()
                .statusCode(200);
    }
}
