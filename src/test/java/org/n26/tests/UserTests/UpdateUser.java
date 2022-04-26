package org.n26.tests.UserTests;

import io.restassured.response.Response;
import org.n26.model.User;
import org.n26.tests.BaseAPITest;
import org.testng.annotations.*;

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
    @Parameters({"firstname"})
    public void updateUserName_checkUserName(String firstname){
        createUser(commonRequestSpec,user);
        User updatedUserPayload = user.toBuilder()
                .firstName(firstname)
                .build();
        Response response = updateUser(commonRequestSpec, user.getUsername(), updatedUserPayload);
        response.then().statusCode(200);
    }

    @AfterMethod
    public void afterMethodTearDown(){
        deleteUser(commonRequestSpec, user.getUsername());
    }
}
