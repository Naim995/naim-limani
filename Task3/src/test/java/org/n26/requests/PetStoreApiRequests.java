package org.n26.requests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PetStoreApiRequests {

    public static Response addNewPet(RequestSpecification requestSpecification, Object requestPayload) {
        return given()
                .spec(requestSpecification)
                .body(requestPayload)
                .post("/api/v3/pet");
    }

    public static Response updateNewPet(RequestSpecification requestSpecification, Object requestPayload) {
        return given()
                .spec(requestSpecification)
                .body(requestPayload)
                .put("/api/v3/pet");
    }

    public static Response getPetById(RequestSpecification requestSpecification, Long id) {
        return given()
                .spec(requestSpecification)
                .pathParam("id",id)
                .get("/api/v3/pet/{id}");
    }

    public static Response getPetsByStatus(RequestSpecification requestSpecification, Enum<?> status) {
        return given()
                .spec(requestSpecification)
                .queryParam("status",status)
                .get("/api/v3/pet/findByStatus");
    }

    public static Response getPetsByTags(RequestSpecification requestSpecification, List<String> tags) {
        return given()
                .spec(requestSpecification)
                .queryParam("tags",tags)
                .get("/api/v3/pet/findByTags");
    }

    public static Response deletePetById(RequestSpecification requestSpecification, Long id) {
        return given()
                .spec(requestSpecification)
                .pathParam("id",id)
                .delete("/api/v3/pet/{id}");
    }
}
