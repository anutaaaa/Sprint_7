package ru.praktikum_services.qa_scooter;

import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;

public class LoginCourierTests {

    private Courier courier;

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
        this.courier = CourierHelper.getRandom();
        CourierHelper.create(courier);
    }

    @Test
    public void loginSuccess() {
        CourierHelper
                .login(courier)
                .then()
                .statusCode(200);
    }

    @Test
    public void loginWithNonExistingLogin() {
        CourierHelper.login(CourierHelper.getRandom())
                .then()
                .statusCode(404)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @After
    public void tearDown() {
        int id = CourierHelper.loginAndGetId(courier);
        CourierHelper.deleteAndGetStatus(id);
    }
}





