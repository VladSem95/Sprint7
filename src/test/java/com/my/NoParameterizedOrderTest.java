package com.my;

import io.restassured.response.ValidatableResponse;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static com.my.StatusCodeAndTextErrors.getSuccessGetOrderList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
public class NoParameterizedOrderTest {
    private OrderClient orderClient;
    @Before
    public void setup() {
        orderClient = new OrderClient();
    }
    @Test
    public void getOrderList() {
        ValidatableResponse getOrderListResponse = orderClient.get();
        int statusCode = getOrderListResponse.extract().statusCode();
        List<String> orderList = getOrderListResponse.extract().path("orders");
        assertThat(orderList, is(notNullValue()));
        assertEquals(getSuccessGetOrderList(),statusCode);
    }
}
