package com.bestbuy.stores.servicesinfo;

import com.bestbuy.stores.ServicesPojo;
import com.bestbuy.stores.StoresPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ServicesPutTest extends TestBase {

    @Test
    public void updateServiceWithPut() {

        ServicesPojo servicesPojo = new ServicesPojo();
        servicesPojo.setName("Electrical Recycling");

        Response response = given()
                .pathParam("id", 4)
                .header("Content-Type", "application/json")
                .body(servicesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    }
