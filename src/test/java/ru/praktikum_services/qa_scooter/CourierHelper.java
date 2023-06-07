package ru.praktikum_services.qa_scooter;

import io.restassured.response.Response;
import org.hamcrest.Condition;

import static io.restassured.RestAssured.given;

public class CourierHelper {

    public static Courier getRandom() {
        return new Courier(
                RandomHelper.getString(8),
                RandomHelper.getString(10),
                RandomHelper.getString(12)
        );
    }

    public static Response create(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(Constants.CREATE_COURIER_ENDPOINT);
    }

    public static int loginAndGetId(Courier courier) {
        return login(courier)
                .then()
                .extract()
                .body()
                .jsonPath().get("id");
    }

    public static Response login(Courier courier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(courier)
                .when()
                .post(Constants.LOGIN_COURIER_ENDPOINT);
    }


    public static boolean deleteAndGetStatus(int id) {
        return delete(id)
                .then()
                .extract()
                .body()
                .jsonPath().get("ok");
    }

    public static Response delete(int id) {
        return given()
                .header("Content-type", "application/json")
                .when()
                .delete(Constants.DELETE_COURIER_ENDPOINT, id);

    }

    public static Response createOrder(Order order) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(order)
                .when()
                .post(Constants.CREATE_ORDER_ENDPOINT);
    }
}
