package org.n26.tests.UserTests;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.n26.model.User;
import org.n26.tests.BaseAPITest;
import org.testng.Assert;
import org.testng.annotations.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.n26.requests.UserApiRequests.*;

public class UpdateUser extends BaseAPITest {
    User user;
    @BeforeMethod
    public void beforeMethodSetUp(){
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
    public void updateUser_checkResponseCode_expect200(){
        createUser(commonRequestSpec,user);
        User updatedUserPayload = user.toBuilder()
                .id(4321L)
                .username("blabla")
                .firstName("John")
                .lastName("Wick")
                .email("wick@john.com")
                .password("password321")
                .phone("54312")
                .userStatus(2)
                .build();
        Response response = updateUser(commonRequestSpec, user.getUsername(), updatedUserPayload);
        response.then().statusCode(200);
    }

    @Test
    public void updateUserName_checkUserName(){
        createUser(commonRequestSpec,user);
        User updatedUserPayload = user.toBuilder()
                .firstName("Wayne")
                .build();
        Response response = updateUser(commonRequestSpec, user.getUsername(), updatedUserPayload);
        response.then().body("firstName", equalTo(updatedUserPayload.getFirstName()));
    }

    @Test
    public void updateUserName_checkResponseBody(){
        createUser(commonRequestSpec,user);
        User updatedUserPayload = user.toBuilder()
                .firstName("Peter")
                .build();
        Response response = updateUser(commonRequestSpec, user.getUsername(), updatedUserPayload);

        response.then()
                .body("id", equalTo((int)updatedUserPayload.getId()))
                .body("username", equalTo(updatedUserPayload.getUsername()))
                .body("firstName", equalTo(updatedUserPayload.getFirstName()))
                .body("lastName", equalTo(updatedUserPayload.getLastName()))
                .body("email", equalTo(updatedUserPayload.getEmail()))
                .body("password", equalTo(updatedUserPayload.getPassword()))
                .body("phone", equalTo(updatedUserPayload.getPhone()))
                .body("userStatus", equalTo(updatedUserPayload.getUserStatus()));


    }

    @AfterMethod
    public void afterMethodTearDown(){
        deleteUser(commonRequestSpec, user.getUsername());
    }
}
