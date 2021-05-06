package org.savstanis.lab5;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.savstanis.lab5.model.User;


public class MainTests {

    @Test
    public void findUsers_bodyShouldBePresent() {
        new UserEndpoint()
                .getUsers()
                .then()
                .assertThat()
                .body(Matchers.notNullValue());
    }

    @Test
    public void findUserById_bodyShouldBePresent() {
        new UserEndpoint()
                .getUserById("123")
                .then()
                .assertThat()
                .body(Matchers.notNullValue());
    }

    @Test
    public void createUser_userShouldBeCreated() {
        User user = new User("Name", "email4@mail.com", "Male", "Active");

        new UserEndpoint()
                .createUser(user, System.getenv("ACCESS_TOKEN"))
                .then()
                .log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void updateUser_userShouldBeUpdated() {
        User user = new User("Name", "email2@mail.com", "Female", "Active");

        new UserEndpoint()
                .updateUser("1666", user, System.getenv("ACCESS_TOKEN"))
                .then()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void deleteUser_authFailed() {
        User user = new User("Name", "email@mail.com", "Male", "Active");

        Response baseResponse = new UserEndpoint().deleteUser("1403", "");

        JsonPath jsonPath = baseResponse.jsonPath();
        Assert.assertEquals( 401, jsonPath.getInt("code"));
    }
}
