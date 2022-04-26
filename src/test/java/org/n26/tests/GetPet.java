package org.n26.tests;

import io.restassured.response.Response;
import org.n26.model.Category;
import org.n26.model.Pet;
import org.n26.model.Tag;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.n26.requests.PetStoreApiRequests.*;

public class GetPet extends BaseAPITest {

    Pet pet;
    enum status{
        available,
        pending,
        sold
    }
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
    public void getPetByNonExistingId_checkResponseStatus_expect404(){

        Response response = getPetById(commonRequestSpec, pet.getId());

        response.then().statusCode(404);
    }

    @Test
    public void getPetById_checkResponseStatus_expect200(){
        addNewPet(commonRequestSpec, pet);

        Response response = getPetById(commonRequestSpec, pet.getId());

        response.then().statusCode(200);
    }

    @Test
    public void getPetByStatus_checkResponseStatus_expect200(){
        addNewPet(commonRequestSpec, pet);
        System.out.println(status.available);
        Response response = getPetsByStatus(commonRequestSpec, status.available);

        response.then().statusCode(200);
    }

    @Test
    public void getPetsByStatus_checkNumberOfPets_expectSize7(){
        Response response = getPetsByStatus(commonRequestSpec, status.available);

        response.then().body("response",hasSize(7));
    }

    @Test
    public void getPetsByTags_checkNumberOfPets_expectSize9(){
        List<String> tags = new ArrayList<String>();
        tags.add("tag1");
        tags.add("tag2");
        Response response = getPetsByTags(commonRequestSpec, tags);

        response.then().body("response",hasSize(9));
    }

    @AfterMethod
    public void afterMethodTearDown(){
        deletePetById(commonRequestSpec, pet.getId());
    }
}
