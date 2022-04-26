package org.n26.tests.UserTests;

import io.restassured.response.Response;
import org.n26.model.User;
import org.n26.tests.BaseAPITest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.n26.requests.UserApiRequests.*;

public class DeleteUser extends BaseAPITest {

    User user;
    @BeforeMethod
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

        createUser(commonRequestSpec,user);
    }

    @Test(groups = {"smokeTests"})
    public void deleteUser_checkResponseCode_expect200(){

        Response response = deleteUser(commonRequestSpec,user.getUsername());

        response.then().statusCode(200);

    }

}
