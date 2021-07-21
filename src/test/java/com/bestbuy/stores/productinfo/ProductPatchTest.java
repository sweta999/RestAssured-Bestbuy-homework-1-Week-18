package com.bestbuy.stores.productinfo;

import com.bestbuy.stores.ProductPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.codehaus.groovy.control.io.ReaderSource;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPatchTest extends TestBase {

    @Test
    public void updateProductWithPatch() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setType("SoftGood");

        Response response = given()
                .pathParam("id",9999707)
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .patch("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
