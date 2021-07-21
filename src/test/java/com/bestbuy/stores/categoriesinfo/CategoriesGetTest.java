package com.bestbuy.stores.categoriesinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class CategoriesGetTest extends TestBase {

    @Test
    public void getAllCategoriesList() {
        Response response =
                given()
                        .when()
                        .get("");
        response.then().statusCode(200);
        response.prettyPrint();
    }

    @Test
    public void searchCategoryWithParameter() {
        HashMap<String, Object> qParams = new HashMap<>();
        qParams.put("$limit", 5);
        qParams.put("$skip", 0);

        Response response = given()
                /*.queryParam("limit",3)   //can show queryParam seperately
                .queryParam("skip",2)*/
                .queryParams(qParams)       //2nd Method- both queryParam shown as queryParams in 1 line
                .when()
                .get("");
        response.prettyPrint();
    }

    @Test
    public void getSingleCategory() {
        Response response = given()
                .pathParam("id", "abcat0102006")
                .when()
                .get("/{id}");
        response.prettyPrint();
    }



}
