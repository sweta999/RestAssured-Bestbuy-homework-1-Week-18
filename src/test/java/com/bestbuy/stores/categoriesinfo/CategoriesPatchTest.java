package com.bestbuy.stores.categoriesinfo;

import com.bestbuy.stores.CategoriesPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPatchTest extends TestBase {

    @Test
    public void updateCategoryWithPut() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("TV & Home Theaters");


        Response response = given()
                .pathParam("id", "abcat0100000")
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
