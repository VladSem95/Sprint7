package com.my;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class NoParameterizedCourierCreateTest {
    private CourierClient courierClient;
    private int courierId;
    private Courier courier;

    @Before
    public void setUp() {
        courierClient = new CourierClient();
        courier = CourierGenerator.getRandom();
    }
    @After
    public void cleanUp() {
        String id = Integer.toString(courierId);
        courierClient.delete(id);
    }
    @Test
    public void courierCanBeCreated() {

        ValidatableResponse createResponse = courierClient.create(courier);

        int statusCode = createResponse.extract().statusCode();
        boolean isCourierCreated = createResponse.extract().path("ok");


        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courier));
        courierId = loginResponse.extract().path("id");

        assertThat(courierId, is(notNullValue()));
        assertTrue(isCourierCreated);
        assertEquals(StatusCodeAndTextErrors.getSuccessCreateCourierStatusCode(), statusCode);
    }

    @Test
    public void courierIdenticalLoginOrFullCanNotBeCreated() {
        courierClient.create(courier);
        ValidatableResponse createResponseNegative = courierClient.create(courier);
        int statusCode = createResponseNegative.extract().statusCode();
        assertEquals(StatusCodeAndTextErrors.getLoginDuplicateStatusCode(), statusCode);
    }
}
