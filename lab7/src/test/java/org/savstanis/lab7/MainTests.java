package org.savstanis.lab7;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.savstanis.lab7.model.User;


@RunWith(SerenityRunner.class)
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

    @Test
    public void createUser_withoutGender_userShouldBeCreated() {
        User user = new User("Name", "email4@mail.com", "Male", "Active");
        user.setGender(null);

        new UserEndpoint()
                .createUser(user, System.getenv("ACCESS_TOKEN"))
                .then()
                .log().body()
                .assertThat()
                .statusCode(200);
    }

    @Test
    public void createUser_withoutName_userShouldNotBeCreated() {
        User user = new User("Name", "email4@mail.com", "Male", "Active");
        user.setName(null);

        new UserEndpoint()
                .createUser(user, System.getenv("ACCESS_TOKEN"))
                .then()
                .log().body()
                .assertThat()
                .statusCode(400);
    }

    @Test
    public void updateUser_removeGender_userShouldBeUpdated() {
        User user = new User("Name", "email2@mail.com", "Female", "Active");
        user.setGender(null);

        new UserEndpoint()
                .updateUser("1666", user, System.getenv("ACCESS_TOKEN"))
                .then()
                .assertThat()
                .statusCode(200);
    }
}
