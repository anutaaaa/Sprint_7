package ru.praktikum_services.qa_scooter;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class ParametrizedCreateOrderTest {

    private final Order order;

    public ParametrizedCreateOrderTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters
    public static Order[] getOrders() {
        return new Order[]{
                new Order(RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getInt(), RandomHelper.getFormattedDate(), RandomHelper.getString(10)),
                new Order(RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getInt(), RandomHelper.getFormattedDate(), RandomHelper.getString(10), new Color[]{Color.GREY}),
                new Order(RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getInt(), RandomHelper.getFormattedDate(), RandomHelper.getString(10), new Color[]{Color.BLACK}),
                new Order(RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getString(10), RandomHelper.getInt(), RandomHelper.getFormattedDate(), RandomHelper.getString(10), new Color[]{Color.GREY, Color.BLACK}),
        };
    }

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void createNewOrder() {
        given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post("/api/v1/orders")
                .then()
                .assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);
    }
}
