package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedOrderCreateTest {
    private OrderClient orderClient;
    private final Order orderParam;
    private final int requestStatusCode;


    public ParameterizedOrderCreateTest(Order orderParam, int requestStatusCode) {
        this.orderParam = orderParam;
        this.requestStatusCode = requestStatusCode;
    }

    @Parameterized.Parameters
    public static Object[][] getTestParameters() {
        return new Object[][]{
                //orderParam requestStatusCode
                //create order with only black colour
                {OrderGenerator.getRandomOrderWithBlackColour(),
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order with only grey colour
                {OrderGenerator.getRandomOrderWithGreyColour(),
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order with black and grey colours
                {OrderGenerator.getRandomOrderWithBlackAndGreyColour(),
                        StatusCodeAndTextErrors.getSuccessCreateOrder()},
                //create order without colour
                {OrderGenerator.getRandomOrderWithoutColour(),
                        StatusCodeAndTextErrors.getSuccessCreateOrder()}
        };
    }
    @Before
    public void setup() {
        orderClient = new OrderClient();
    }

    @Test
    public void createOrderParam() {
        ValidatableResponse createResponse = orderClient.create(orderParam);
        int statusCode = createResponse.extract().statusCode();
        int actualBodyResponse = createResponse.extract().path("track");
        assertThat(actualBodyResponse,is(notNullValue()));
        assertEquals(requestStatusCode,statusCode);
    }
}


