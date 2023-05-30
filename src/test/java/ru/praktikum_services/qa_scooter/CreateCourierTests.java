package ru.praktikum_services.qa_scooter;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;

public class CreateCourierTests {

    private Courier courier;
    Order clientOrder = new Order();
    @Before
    public void setUp() {
        clientOrder.setUp();
        this.courier = CourierHelper.getRandom();
    }

    @Test
    public void createNewCourier() {
        CourierHelper.create(courier)
                .then()
                .statusCode(201)
                .and()
                .body("ok", equalTo(true));
    }

    @Test
    public void createCourierWithExistingLogin() {
        CourierHelper.create(courier)
                .then()
                .statusCode(201);

        CourierHelper.create(courier)
                .then()
                .statusCode(409)
                .and()
                .body("message", equalTo("Этот логин уже используется"));
    }

    @After
    public void tearDown() {
        int id = CourierHelper.loginAndGetId(courier);
        CourierHelper.deleteAndGetStatus(id);
    }
}
