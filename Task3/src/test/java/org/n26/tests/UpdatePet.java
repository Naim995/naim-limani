package org.n26.tests;

import io.restassured.response.Response;
import org.n26.model.Category;
import org.n26.model.Pet;
import org.n26.model.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.equalTo;
import static org.n26.requests.PetStoreApiRequests.*;

public class UpdatePet extends BaseAPITest {

    Pet pet;

    @BeforeClass
    public void beforeClassSetUp(){
        pet = Pet.builder()
                .id(101L)
                .name("Felix")
                .category(Category.builder()
                        .id(1)
                        .name("Dogs")
                        .build())
                .photoUrls(Collections.singletonList("pic1"))
                .tags(Collections.singletonList(Tag.builder()
                        .id(0)
                        .name("tag1")
                        .build()))
                .status("available")
                .build();

    }

    @Test
    public void updatePetWithNonExistingId_checkResponseStatus_expect404(){

        Response response = updateNewPet(commonRequestSpec, pet);

        response.then().statusCode(404);
    }

    @Test(groups = {"smokeTests"})
    public void updatePet_checkResponseStatus_expect200(){
        addNewPet(commonRequestSpec, pet);

        Pet updatedPet = pet.toBuilder()
                .id(101L)
                .name("Jacky")
                .category(Category.builder()
                        .id(2)
                        .name("Dogs")
                        .build())
                .photoUrls(Collections.singletonList("pic2"))
                .tags(Collections.singletonList(Tag.builder()
                        .id(1)
                        .name("cute")
                        .build()))
                .status("pending")
                .build();

        Response response = updateNewPet(commonRequestSpec, updatedPet);

        response.then().statusCode(200);
    }

    @Test
    public void updatePetNameToJacky_checkPetName_expectNameJacky(){
        addNewPet(commonRequestSpec, pet);

        pet.setName("Jacky");

        Response response = updateNewPet(commonRequestSpec, pet);

        response.then().body("name", equalTo("Jacky"));
    }

    @AfterMethod
    public void afterMethodTearDown(){
        deletePetById(commonRequestSpec, pet.getId());
    }
}
