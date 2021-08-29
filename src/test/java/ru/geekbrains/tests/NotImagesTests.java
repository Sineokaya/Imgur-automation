package ru.geekbrains.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class NotImagesTests extends BaseTest {
    String imageDeleteHash;
    @Test
    void uploadDocTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/Test.docx")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadPdfTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/Замена_проходки.pdf")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadLogTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/debug.log")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadHtmlTest() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/dns.html")))
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
