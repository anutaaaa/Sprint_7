package ru.praktikum_services.qa_scooter;

import io.restassured.response.Response;

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
                .post("/api/v1/courier");
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
                .post("/api/v1/courier/login");
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
                .delete("/api/v1/courier/{id}", id);
    }

}
