package com.bestbuy.stores.storesinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class StoresGetTest extends TestBase {

    @Test
    public void getAllStoresList() {
        Response response =
                given()
                        .when()
                        .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchStoresWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 2);
        qParams.put("$skip", 2);

        Response response = given()
                /*.queryParam("limit",3)   //can show queryParam seperately
                .queryParam("skip",2)*/
                .queryParams(qParams)       //2nd Method- both queryParam shown as queryParams in 1 line
                .when()
                .get("");
        response.prettyPrint();
    }

    @Test
    public void getSingleStore() {
        Response response = given()
                .pathParam("id", 7)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }

}
