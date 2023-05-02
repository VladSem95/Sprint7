package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;


@RunWith(Parameterized.class)
public class ParameterizedLoginCourierTest {
    private CourierClient courierClient;
    private final Courier courierParam;
    private final int requestStatusCode;
    private final String errorMessage;

    public ParameterizedLoginCourierTest(Courier courierParam, int requestStatusCode, String errorMessage) {
        this.courierParam = courierParam;
        this.requestStatusCode = requestStatusCode;
        this.errorMessage = errorMessage;
    }

    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        //courierParam, requestStatusCode, errorMessage
        return new Object[][]{
                //without required field login
                {CourierGenerator.getRandomLoginCourierWithoutLogin(),
                        StatusCodeAndTextErrors.getLoginErrorStatusCode(),
                        StatusCodeAndTextErrors.getErrorLoginWithoutLoginOrPassword()},
                //without required field password
                {CourierGenerator.getRandomLoginCourierWithoutPassword(),
                        StatusCodeAndTextErrors.getLoginErrorStatusCode(),
                        StatusCodeAndTextErrors.getErrorLoginWithoutLoginOrPassword()},
                //account does not exist
                {CourierGenerator.getRandomWithoutFirstName(),
                        StatusCodeAndTextErrors.getLoginErrorNotFoundStatusCode(),
                        StatusCodeAndTextErrors.getErrorNotFound()}
        };
    }

    @Before
    public void setUp() {
        courierClient = new CourierClient();
    }

    @Test
    public void courierCanNotBeLogin() {

        ValidatableResponse loginResponse = courierClient.login(CourierCredentials.from(courierParam));
        int statusCode = loginResponse.extract().statusCode();
        String actualErrorMessage = loginResponse.extract().path("message");
        assertEquals(requestStatusCode, statusCode);
        assertEquals(errorMessage, actualErrorMessage);
    }
}



