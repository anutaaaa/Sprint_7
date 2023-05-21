package ru.praktikum_services.qa_scooter;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class ParametrizedLoginCourierTests {
    private final Courier courier;

    public ParametrizedLoginCourierTests(Courier courier) {
        this.courier = courier;
    }

    @Parameterized.Parameters
    public static Courier[] getCouriers() {
    return new Courier[]{
            new Courier(RandomHelper.getString(10), ""),
            new Courier("", RandomHelper.getString(10)),
    };
}

    @Before
    public void setUp() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    @Test
    public void loginWithoutAllRequiredValues() {
        CourierHelper.login(courier)
                .then()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }
}





