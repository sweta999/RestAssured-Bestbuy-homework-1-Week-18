package com.bestbuy.stores.categoriesinfo;

import com.bestbuy.stores.CategoriesPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesPostTest extends TestBase {

    @Test
    public void createCategory() {

        CategoriesPojo categoriesPojo = new CategoriesPojo();
        categoriesPojo.setName("Remote Cars");
        categoriesPojo.setId("rmct0020003");

        Response response = given()
                .header("Content-Type", "application/json")
                .body(categoriesPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();
    }

}