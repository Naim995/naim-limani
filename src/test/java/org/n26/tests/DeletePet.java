package org.n26.tests;

import io.restassured.response.Response;
import org.n26.model.Category;
import org.n26.model.Pet;
import org.n26.model.Tag;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.n26.requests.PetStoreApiRequests.*;

public class DeletePet extends BaseAPITest {

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
    public void deletePetById_checkResponseStatus_expect200(){
        addNewPet(commonRequestSpec, pet);

        Response response = deletePetById(commonRequestSpec, pet.getId());

        response.then().assertThat().statusCode(200);
    }

    @Test
    public void deletePetById_verifyPetIsDeletedWithGetPetRequest_expectPetNotFound(){
        addNewPet(commonRequestSpec, pet);
        deletePetById(commonRequestSpec, pet.getId());

        Response response = getPetById(commonRequestSpec, pet.getId());
        response.then().body(equalToIgnoringCase("Pet not found"));
    }
}
