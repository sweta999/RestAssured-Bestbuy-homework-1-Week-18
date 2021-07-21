package com.bestbuy.stores.servicesinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ServicesGetTest extends TestBase {

    @Test
    public void getAllServicesList() {
        Response response =
                given()
                        .when()
                        .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchServicesWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 5);
        qParams.put("$skip", 1);

        Response response = given()
                /*.queryParam("limit",3)   //can show queryParam seperately
                .queryParam("skip",2)*/
                .queryParams(qParams)       //2nd Method- both queryParam shown as queryParams in 1 line
                .when()
                .get("");
        response.prettyPrint();
    }

    @Test
    public void getSingleService() {
        Response response = given()
                .pathParam("id", 4)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }
}
