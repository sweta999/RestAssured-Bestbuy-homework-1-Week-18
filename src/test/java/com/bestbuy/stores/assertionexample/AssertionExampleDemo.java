package com.bestbuy.stores.assertionexample;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AssertionExampleDemo {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/stores")
                .then();
    }

    // 1) Verify if the total is equal to 1565
    @Test
    public void test001() {
        response.body("total", equalTo(1565));
    }

    // 2) Verify if the stores of limit is equal to 10
    @Test
    public void test002() {
        response.body("limit", equalTo(10));

    }

    // 3) Check Single Name in ArrayList (Maplewood))
    @Test
    public void test003() {
        response.body("data.name", hasItem("Maplewood"));

    }

    // 4) Check Multiple Names in ArrayList (Minnetonka, Roseville, Maplewood, Fargo)

    @Test
    public void test004() {
        response.body("data.name", hasItems("Minnetonka", "Roseville","Maplewood", "Fargo"));

    }

    // 5) Verify the storeid inside storeservices of the third store of second services
    @Test
    public void test005() {
        response.body("data[3].services[2].id", equalTo(4));

    }

    // 6) Check hash map values createdAt inside "storeservices" map where store name = Southbridge
    @Test
    public void test006() {
        response.body("data.findAll{it.data[6].services[0].storeservices}", hasItems(hasEntry("createdAt", "2016-11-17T17:57:08.328Z")));
        //response.body("data[6].services[0].storeservices",  hasItems("createdAt","2016-11-17T17:57:08.328Z","updatedAt","2016-11-17T17:57:08.328Z", "storeId",14,"serviceId",1));
        //response.body("data[6].services[0].storeservices.createdAt", hasItem("2016-11-17T17:57:08.328Z"));
    }

    // 7) Verify the state=IA of ninth store   //Verify the state=IA of third store
    @Test
    public void test007() {
        response.body("data[9].state", equalToCompressingWhiteSpace("IA"));

    }

    // 8) Verify the name=West Des Moines of 9th store  //Verify the name=GreenBay of 9th store
    @Test
    public void test008() {
        response.body("data[9].name", equalToCompressingWhiteSpace("West Des Moines"));
    }

    // 9) Verify the storeid = 13 for the 6th store
    @Test
    public void test009() {
        response.body("data[6].services[0].storeservices.storeId", equalTo(13));
        //data[6].id
    }

    // 10) Verify the storeid = 14 for the 7th store  //Verify serviceid=1 for 7th store
    @Test
    public void test010() {
        response.body("data[7].services[0].storeservices.storeId", equalTo(14));
        // response.body("data[7].services[0].storeservices.serviceId", equalTo(1));
    }

}
