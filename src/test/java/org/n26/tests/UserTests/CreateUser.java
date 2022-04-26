package org.n26.tests.UserTests;

import io.restassured.response.Response;
import org.n26.model.User;
import org.n26.tests.BaseAPITest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.n26.requests.UserApiRequests.createUser;
import static org.n26.requests.UserApiRequests.deleteUser;


public class CreateUser extends BaseAPITest {

    User user;
    @BeforeClass
    public void beforeClassSetUp(){
        user = User.builder()
                .id(1234L)
                .username("username")
                .firstName("firstname")
                .lastName("lastname")
                .email("email@hotmail.com")
                .password("password123")
                .phone("12345")
                .userStatus(1)
                .build();
    }

    @Test(groups = {"smokeTests"})
    public void createUser_checkResponseCode_expect200(){

        Response response = createUser(commonRequestSpec,user);

        response.then().statusCode(200);

    }

    @AfterMethod
    public void afterMethodTearDown(){
        deleteUser(commonRequestSpec, user.getUsername());
    }
}
