package com.bestbuy.stores.storesinfo;

import com.bestbuy.stores.StoresPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class StoresPostTest extends TestBase {

    @Test
    public void createStore() {

        HashMap<String, Object> services = new HashMap<>();
        services.put("Name","Magnolia Design Center");
        services.put("storesservices",5);


        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setName("Rosewood");
        storesPojo.setType("BigBox");
        storesPojo.setAddress("14321 Ridge Dr");
        storesPojo.setAddress2("");
        storesPojo.setCity("Duluth");
        storesPojo.setState("MN");
        storesPojo.setZip("44309");
        storesPojo.setLat(0);
        storesPojo.setLng(0);
        storesPojo.setHours("Mon: 10-9; Tue: 10-9; Wed: 10-9; Thurs: 10-8; Fri: 10-9; Sat: 10-9; Sun: 10-8");
        storesPojo.setServices(services);


        Response response = given()
                .header("Content-Type", "application/json")
                .body(storesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }


}

//storesPojo.setServices(serviceList);