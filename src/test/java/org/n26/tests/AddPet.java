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
import static org.n26.requests.PetStoreApiRequests.addNewPet;
import static org.n26.requests.PetStoreApiRequests.deletePetById;


public class AddPet extends BaseAPITest {

    Pet pet;

    @BeforeClass
    public void beforeClassSetUp(){
        pet = Pet.builder()
                .id(101L)
                .name("Toby")
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

    @Test(groups = {"smokeTests"})
    public void addPet_checkResponseStatus_expect200(){
            Response response = addNewPet(commonRequestSpec, pet);

            response.then().statusCode(200);
    }

    @Test
    public void addPet_checkResponseBody(){
        Response response = addNewPet(commonRequestSpec, pet);

        response.then()
                .body("id", equalTo(pet.getId().intValue()))
                .body("name", equalTo(pet.getName()))
                .body("status", equalTo(pet.getStatus()))
                .body("category.id", equalTo((int)pet.getCategory().getId()))
                .body("category.name", equalTo(pet.getCategory().getName()))
                .body("photoUrls[0]", equalTo(pet.getPhotoUrls().get(0)))
                .body("tags[0].id", equalTo((int)pet.getTags().get(0).getId()))
                .body("tags[0].name", equalTo(pet.getTags().get(0).getName()));
    }

    @AfterMethod
    public void afterMethodTearDown(){
        deletePetById(commonRequestSpec, pet.getId());
    }
}
