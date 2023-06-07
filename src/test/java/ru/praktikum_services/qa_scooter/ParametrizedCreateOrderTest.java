package ru.praktikum_services.qa_scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class ParametrizedCreateOrderTest extends BaseApi{

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

    @Test
    public void createNewOrder() {
        CourierHelper.createOrder(order)
                .then()
                .assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);
    }
}
