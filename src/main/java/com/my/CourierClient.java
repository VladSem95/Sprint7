package com.my;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;

public class CourierClient extends RestClient {
    private static final String CREATE_COURIER_PATH = "api/v1/courier";
    private static final String LOGIN_COURIER_PATH = "api/v1/courier/login";
    private static final String DELETE_COURIER_PATH = "/api/v1/courier/";

    public ValidatableResponse create(Courier courier) {
        return given()
                .spec(getBaseSpec())
                .body(courier)
                .when()
                .post(CREATE_COURIER_PATH)
                .then()
                .assertThat();

    }

    public ValidatableResponse login(CourierCredentials credentials) {

        return given()
                .spec(getBaseSpec())
                .body(credentials)
                .when()
                .post(LOGIN_COURIER_PATH)
                .then()
                .assertThat();

    }
    public ValidatableResponse delete(String id) {
        return given()
                .spec(getBaseSpec())
                .body(id)
                .when()
                .delete(DELETE_COURIER_PATH)
                .then()
                .assertThat();
    }
}
