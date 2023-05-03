package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static com.my.OrderGenerator.getRandomOrderWithColour;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedOrderCreateTest {
    private static OrderClient orderClient;
    private final int requestStatusCode;
    private final String firstColourForTest;
    private final String secondColourForTest;

    public ParameterizedOrderCreateTest(String firstColourForTest, String secondColourForTest, int requestStatusCode) {
        this.firstColourForTest = firstColourForTest;
        this.secondColourForTest = secondColourForTest;
        this.requestStatusCode = requestStatusCode;
    }
    //firstColour secondColour requestStatusCode
    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                //orderParam requestStatusCode
                //create order with only black colour
                {"BLACK","",
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order with only grey colour
                {"GREY", "",
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order with black and grey colours
                {"BLACK", "GREY",
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order without colour
                {"", "",
                        StatusCodeAndTextErrors.getSuccessCreateOrder()}
        };
    }

        @Before
    public void setup() {
        orderClient = new OrderClient();
    }

    @Test
    public void createOrderParam() {
        ValidatableResponse createResponse = orderClient.create(getRandomOrderWithColour(firstColourForTest,secondColourForTest));
        int statusCode = createResponse.extract().statusCode();
        int actualBodyResponse = createResponse.extract().path("track");
        assertThat(actualBodyResponse,is(notNullValue()));
        assertEquals(requestStatusCode,statusCode);
    }
}


