package ru.praktikum_services.qa_scooter;
import io.restassured.RestAssured;

public class Constants {
    public void setUp(){
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }

    public final static String CREATE_COURIER_ENDPOINT = "/api/v1/courier";
    public final static String LOGIN_COURIER_ENDPOINT ="/api/v1/courier/login";
    public final static String DELETE_COURIER_ENDPOINT ="/api/v1/courier/{id}";
    public final static String CREATE_ORDER_ENDPOINT = "/api/v1/orders";



}
