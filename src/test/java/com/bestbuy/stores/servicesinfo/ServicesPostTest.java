package com.bestbuy.stores.servicesinfo;

import com.bestbuy.stores.ServicesPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesPostTest extends TestBase {

    @Test
    public void createService() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Best buy Laptop");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }
}
