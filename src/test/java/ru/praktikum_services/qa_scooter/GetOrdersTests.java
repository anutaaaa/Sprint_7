package ru.praktikum_services.qa_scooter;

import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;


public class GetOrdersTests{

     Order clientOrder = new Order();
    @Before
    public void setUp() {
        clientOrder.setUp();
    }
    @Test
    public void getOrders() {
        Response response = given()
                .get(Constants.CREATE_ORDER_ENDPOINT);


        response.then().statusCode(200);

        GetOrders orders = response.getBody().as(GetOrders.class);
        assertFalse(orders.getOrders().isEmpty());
    }
}
