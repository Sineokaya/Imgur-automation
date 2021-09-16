package lesson4.tests;

import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static lesson4.EndPoints.UPLOAD_IMAGE;
import static lesson4.Images.*;

import static lesson4.Images.DEBUG_LOG;
import static lesson4.Images.ZAMENA;
import static lesson4.Images.DNS_HTML;
import static lesson4.Images.TEST_DOCX;

public class NotImagesTests extends BaseTest {
    String imageDeleteHash;
    RequestSpecification multiPartReqSpec;
    RequestSpecification imageRequestSpecification;

    @Test
    void uploadImageFileDebugLogTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(DEBUG_LOG.getPath()))
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
    void uploadImageFileHtmlTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(DNS_HTML.getPath()))
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
    void uploadImageFileTestDocxTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(TEST_DOCX.getPath()))
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
    void uploadImageFileZamenaTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(ZAMENA.getPath()))
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
