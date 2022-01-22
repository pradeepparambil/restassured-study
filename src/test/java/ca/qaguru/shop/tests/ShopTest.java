package ca.qaguru.shop.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;

public class ShopTest {
    @Test
    public void saveANewProduct(){
        RequestSpecification specification = RestAssured.given();
        specification.header("Content-Type", "application/json");
        specification.body(new File("src/test/resources/product.json"));
        specification.auth().basic("maria","maria123");
        Response response = specification.post("http://localhost:8090/api/v1/products");
        Assert.assertEquals(response.statusCode(), HttpStatus.SC_CREATED);
        Assert.assertTrue(response.header("Location").contains("/api/v1/products/"));

    }
}
