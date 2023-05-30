package ru.praktikum_services.qa_scooter;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.hamcrest.Matchers.equalTo;

@RunWith(Parameterized.class)
public class ParametrizedCreateCourierTests {

    private final Courier courier;
    Order clientOrder = new Order();
    public ParametrizedCreateCourierTests(Courier courier) {
        this.courier = courier;
    }

    @Parameterized.Parameters
    public static Courier[] getCouriers() {
        return new Courier[] {
                new Courier(RandomHelper.getString(10), "", RandomHelper.getString(14)),
                new Courier("", RandomHelper.getString(10), RandomHelper.getString(16)),

        };
    }

    @Before
    public void setUp() {
        clientOrder.setUp();
    }

    @Test
    public void createCourierWithoutAllRequiredValues() {
        CourierHelper.create(courier)
                .then()
                .statusCode(400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
