package ru.geekbrains.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class ImageTests extends BaseTest {
    String imageDeleteHash;
    @Test
            void uploadImageFileTest() {
        imageDeleteHash=    given()
                   .header("Authorization",token)
                   .body(new File(("src/test/resources/Images/img.png")))
                .expect()
                .statusCode(200)
                   .when()
                   .post("/image")
                   .prettyPeek()
                .jsonPath()
                .get("data.deletehash");

    }

    @Test
    void uploadImageJPG() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/IT.jpg")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImagePNG() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/tiger-clip-art-23.png")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImageTIFF() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/tiff.tif")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImageBMP() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/dig10k_penguin.bmp")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImageGIF() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/Tx2q.gif")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImage1x1pixel() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/1x1.png")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImage50mb() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(new File(("src/test/resources/Images/50+mb.tif")))
                .expect()
                .statusCode(200)
                .when()
                .post("/image")
                .prettyPeek()
                .jsonPath()
                .get("data.deletehash");
    }
    @Test
    void uploadImagefromURL() {
        imageDeleteHash=    given()
                .header("Authorization",token)
                .body(("http://img1.liveinternet.ru/images/attach/c/11/127/974/127974421_4264148_Ummy_Video_Downloader1.jpg"))
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
