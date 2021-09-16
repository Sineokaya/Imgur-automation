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

import static lesson4.Images.NORMAL_MP4;
import static lesson4.Images.SMALL_MP4;
import static lesson4.Images.BIG_MP4;

public class VideoTests extends BaseTest {
    String imageDeleteHash;
    RequestSpecification multiPartReqSpec;
    RequestSpecification imageRequestSpecification;

    @Test
    void uploadImageFileNormalTest() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(NORMAL_MP4.getPath()))
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
    void uploadImageFileSmallMp4Test() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(SMALL_MP4.getPath()))
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
    void uploadImageFileBigMp4Test() {
        imageDeleteHash=  given()
                .spec(requestSpecification)
                .multiPart("image", new File(BIG_MP4.getPath()))
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
