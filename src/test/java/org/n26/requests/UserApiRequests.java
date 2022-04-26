package org.n26.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserApiRequests {

    public static Response createUser(RequestSpecification requestSpecification, Object requestPayload) {
        return given()
                .spec(requestSpecification)
                .body(requestPayload)
                .post("/api/v3/user");
    }

    public static Response deleteUser(RequestSpecification requestSpecification, String username) {
        return given()
                .spec(requestSpecification)
                .pathParam("username", username)
                .delete("/api/v3/user/{username}");
    }
}
