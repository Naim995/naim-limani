package org.n26.tests;

import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeSuite;

import static org.n26.restassured.RequestSpecificationUtils.createCommonRequestSpecification;


public class BaseAPITest {

    protected static RequestSpecification commonRequestSpec;

    @BeforeSuite
    protected void setUp(){
        commonRequestSpec = createCommonRequestSpecification();
    }
}
