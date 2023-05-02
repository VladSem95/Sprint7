package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

public class NoParameterizedLoginCourierTest {
    private CourierClient courierClient;
    private int courierId;
    private Courier courier;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = CourierGenerator.getRandom();
        courierClient.create(courier);
    }
    @After
    public void cleanUp() {
        String id = Integer.toString(courierId);
        courierClient.delete(id);
    }
    @Test
    public void courierCanBeLogin() {
        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");
        int statusCode = loginResponse.extract().statusCode();
        assertThat(courierId, is(notNullValue()));
        assertEquals(StatusCodeAndTextErrors.getSuccessLoginCourier(),statusCode);
    }
}
