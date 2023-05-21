package ru.praktikum_services.qa_scooter;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class GetOrdersTests {
    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void getOrders() {
        Response response = given()
                .get("/api/v1/orders");

        response.then().statusCode(200);

        GetOrders orders = response.getBody().as(GetOrders.class);
        assertFalse(orders.getOrders().isEmpty());
    }
}
