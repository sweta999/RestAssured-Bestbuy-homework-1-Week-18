package com.bestbuy.stores.storesinfo;

import com.bestbuy.stores.StoresPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresPutTest extends TestBase {

    @Test
    public void updateStoreWithPut() {

        HashMap<String, Object> services = new HashMap<>();


        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Burnsville");
        storesPojo.setType("SmallBox");
        storesPojo.setAddress("14141 Aldrich Ave S");
        storesPojo.setAddress2("");
        storesPojo.setCity("Burnsville");
        storesPojo.setState("MN");
        storesPojo.setZip("55337");
        storesPojo.setLat(44.747404);
        storesPojo.setLng(-93.288039);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-9; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        storesPojo.setServices(services);

        Response response = given()
                .pathParam("id", 7)
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}