package lesson4.tests;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import lesson4.Images;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static lesson4.EndPoints.UPLOAD_IMAGE;
import static lesson4.Images.IMAGE_URL;
import static lesson4.Images.PNG_1_1;
import static lesson4.Images.IMAGE_FILE1;
import static lesson4.Images.TIFF_50mb;
import static lesson4.Images.TIFF_BIG50;
import static lesson4.Images.DIG10K_BMP;
import static lesson4.Images.IMG2_PNG;
import static lesson4.Images.IMG3_PNG;
import static lesson4.Images.IT_JPG;
import static lesson4.Images.TIFF_TIF;
import static lesson4.Images.TIGER;
import static lesson4.Images.TX2Q;

public class ImageTests extends BaseTest {

    String imageDeleteHash;
   // String base64Image;
    RequestSpecification multiPartReqSpec;
    RequestSpecification imageRequestSpecification;

    @Test
    void uploadImageFileTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(IMAGE_FILE1.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

@Test
    void uploadImageFileTiff50MbTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TIFF_50mb.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                 .then()
                 .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }
    @Test
    void uploadImageFileTiffBig50MbTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TIFF_BIG50.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileBmpTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(DIG10K_BMP.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileImg2Test() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(IMG2_PNG.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }
    @Test
    void uploadImageFileImg3Test() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(IMG3_PNG.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileItTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(IT_JPG.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileTiffTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TIFF_TIF.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileTigerTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TIGER.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadImageFileTx2QTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TX2Q.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    //загрузка по URL
    @Test
    void uploadFileURLTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", IMAGE_URL.getPath())
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

    @Test
    void uploadFilePNG_1_1Test() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(PNG_1_1.getPath()))
                .expect()
                .spec(positiveResponseSpecification)
                .when()
                .post(UPLOAD_IMAGE)
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }

  /*  @Test
    void uploadBase64FileTest() {
        imageDeleteHash=  given()
                .headers("Authorization", token)
                .multiPart("image", base64Image)
                .when()
                .post("https://api.imgur.com/3/image")
                .prettyPeek()
                .then()
                .extract()
                .response()
                .jsonPath()
                .getString("data.deletehash");
    }
    */

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
