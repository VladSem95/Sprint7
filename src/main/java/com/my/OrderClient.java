package com.my;
import io.restassured.response.ValidatableResponse;
import static io.restassured.RestAssured.given;
public class OrderClient extends RestClient{
    private static final String CREATE_ORDER_PATH = "/api/v1/orders";
    private static final String GET_ORDER_LIST_PATH = "/api/v1/orders";
    public ValidatableResponse create(Order order) {
        return given()
                .spec(getBaseSpec())
                .body(order)
                .when()
                .post(CREATE_ORDER_PATH)
                .then()
                .assertThat();
    }
    public ValidatableResponse get() {
        return given()
                .spec(getBaseSpec())
                .when()
                .get(GET_ORDER_LIST_PATH)
                .then()
                .assertThat();
    }
}
