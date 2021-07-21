package com.bestbuy.stores.storesinfo;

import com.bestbuy.stores.ProductPojo;
import com.bestbuy.stores.StoresPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class StoresPatchTest extends TestBase {

    @Test
    public void updateStoreWithPatch() {

        StoresPojo storesPojo = new StoresPojo();
        storesPojo.setState("BV");

        Response response = given()
                .pathParam("id",7)
                .header("Content-Type","application/json")
                .body(storesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
