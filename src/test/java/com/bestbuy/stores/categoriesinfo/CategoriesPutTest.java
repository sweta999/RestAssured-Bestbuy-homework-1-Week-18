package com.bestbuy.stores.categoriesinfo;

import com.bestbuy.stores.CategoriesPojo;
import com.bestbuy.stores.ServicesPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPutTest extends TestBase {

    @Test
    public void updateCategoryWithPut() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("New Gift Ideas");
        categoriesPojo.setId("NGI999");




        Response response = given()
                .pathParam("id", "ngi210006G")
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}

