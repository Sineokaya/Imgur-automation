package lesson4.tests;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static lesson4.EndPoints.GET_ACCOUNT;
import static lesson4.EndPoints.GET_ACCOUNT_SETTINGS;
import static lesson4.EndPoints.UPLOAD_IMAGE;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class AccountTests extends BaseTest {
    static ResponseSpecification responseSpecification;

@BeforeEach
void setUp() {
             responseSpecification = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(2500l))
            .expectStatusCode(200)
            .expectBody("data.url",equalTo(username))
            .expectBody("success",CoreMatchers.is(true))
            .build();
             RestAssured.responseSpecification=responseSpecification;
}
   @Test
    void getAccountPositiveTest() {
        given()
                .header("Authorization",token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get(GET_ACCOUNT, username)
                .prettyPeek();

    }


}

