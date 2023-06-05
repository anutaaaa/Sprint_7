package ru.praktikum_services.qa_scooter;
import io.restassured.RestAssured;
import org.junit.Before;


public class BaseApi {
    public BaseApi() {
    }
    @Before
    public void setUp(){
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru/";
    }
}