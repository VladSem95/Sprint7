package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedCourierCreateTest {
    private CourierClient courierClient;
    private final Courier courierParam;
    private final int requestStatusCode;
    private final String errorMessage;
    public ParameterizedCourierCreateTest(Courier courierParam, int requestStatusCode, String errorMessage) {
        this.courierParam = courierParam;
        this.requestStatusCode = requestStatusCode;
        this.errorMessage = errorMessage;
    }
    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                //without required fields login
                {CourierGenerator.getRandomWithoutLogin(),
                        StatusCodeAndTextErrors.getNotEnoughDataStatusCode(),
                        StatusCodeAndTextErrors.getCreateErrorWithoutLoginOrPassword()},
                //without required fields password
                {CourierGenerator.getRandomWithoutPassword(),
                        StatusCodeAndTextErrors.getNotEnoughDataStatusCode(),
                        StatusCodeAndTextErrors.getCreateErrorWithoutLoginOrPassword()},

                //required fields, without firstName
                {CourierGenerator.getRandomWithoutFirstName(),
                        StatusCodeAndTextErrors.getSuccessCreateCourierStatusCode(),
                        null
                },
        };
    }
    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }
    @Test
    public void courierCanBeCreated() {

        ValidatableResponse createResponse = courierClient.create(courierParam);
        int statusCode = createResponse.extract().statusCode();
        String textError = createResponse.extract().path("message");
        assertEquals(requestStatusCode, statusCode);
        assertEquals(errorMessage, textError);
    }
}
