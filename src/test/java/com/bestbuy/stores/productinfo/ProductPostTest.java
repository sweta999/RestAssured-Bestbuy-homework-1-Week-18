package com.bestbuy.stores.productinfo;

import com.bestbuy.stores.ProductPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;


import static io.restassured.RestAssured.given;

public class ProductPostTest extends TestBase {

    @Test
    public void createProduct() {

        /*List<String> courseList = new ArrayList<>();
        categoryList.add("");
        categoryList.add("");
*/
        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Panasonic");
        productPojo.setType("StrongGood");
        productPojo.setPrice(6.49);
        productPojo.setShipping(0);
        productPojo.setUpc("041333422021");
        productPojo.setDescription("Compatible with select electronic devices; AAA size; Panasonic Power Preserve technology; 4-pack");
        productPojo.setManufacturer("Panasonic");
        productPojo.setModel("PN2400B4z");
        productPojo.setUrl("string");
        productPojo.setImage("string");


        Response response = given()
                .header("Content-Type","application/json")
                .body(productPojo)
                .when()
                .post();
        response.then().statusCode(201);
        response.prettyPrint();

    }


}
