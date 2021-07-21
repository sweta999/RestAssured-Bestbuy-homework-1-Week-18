package com.bestbuy.stores.productinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class ProductGetTest extends TestBase {

    @Test
    public void getAllProductsList() {
        Response response =
                given()
                        .when()
                        .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchProductsWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 3);
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
    public void getSingleProduct() {
        Response response = given()
                .pathParam("id", 43900)
                .when()
                .get("/{id}");
        response.prettyPrint();
    }


}
