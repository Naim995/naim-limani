package org.n26.restassured;

import io.restassured.specification.RequestSpecification;

import static org.n26.restassured.RequestSpecificationBuilder.createCommonRequestSpecBuilder;


public class RequestSpecificationUtils {
    public static RequestSpecification createCommonRequestSpecification() {
        return createCommonRequestSpecBuilder().build();
    }

    public static RequestSpecification createAuthenticatedRequestSpecification(String token) {
        RequestSpecificationBuilder requestSpecBuilder = createCommonRequestSpecBuilder();
        return requestSpecBuilder.addToken(token).build();
    }

//    public static RequestSpecification createNotAuthenticatedRequestSpecification() {
//        RequestSpecificationBuilder requestSpecBuilder = createCommonRequestSpecBuilder();
//        return requestSpecBuilder.buildClientDataFromConfig(RequestSpecificationBuilder.properties).build();
//    }
}