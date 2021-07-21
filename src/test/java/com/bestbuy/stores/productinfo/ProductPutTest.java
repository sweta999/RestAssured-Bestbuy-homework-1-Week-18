package com.bestbuy.stores.productinfo;

import com.bestbuy.stores.ProductPojo;
import com.bestbuy.stores.testbase.TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class ProductPutTest extends TestBase {


    @Test
    public void updateProductWithPut() {

        ProductPojo productPojo = new ProductPojo();
        productPojo.setName("Pioneer - 4\" 3-Way Surface-Mount Speakers with IMPP Composite Cones (Pair) - Black");
        productPojo.setType("softGood");
        productPojo.setShipping(0);
        productPojo.setPrice(144.99);
        productPojo.setUpc("012562165141");
        productPojo.setDescription("80W maximum power (20W RMS); 4\" IMPP composite cone woofer; 3/4\" horn tweeter");
        productPojo.setManufacturer("Pioneer");
        productPojo.setModel("TS-X200");
        productPojo.setUrl("http://www.bestbuy.com/site/pioneer-4-3-way-surface-mount-speakers-with-impp-composite-cones-pair-black/309062.p?id=1218643240258&skuId=309062&cmp=RMXCC");
        productPojo.setImage("http://img.bbystatic.com/BestBuy_US/images/products/0309/0309062_sa.jpg");


        Response response = given()
                .pathParam("id", 309062)
                .header("Content-Type", "application/json")
                .body(productPojo)
                .when()
                .put("/{id}");
        response.then().statusCode(200);
        response.prettyPrint();
    }

}
