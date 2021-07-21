package com.bestbuy.stores.categoriesinfo;

import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class CategoriesDeleteTest extends TestBase {

    @Test
    public void getDeleteCategory() {
        Response response = given()
                .pathParam("id", "abcat0100000" )
                .when()
                .delete("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
