package org.savstanis.lab5;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.savstanis.lab5.model.User;


public class UserEndpoint {
    private final String BASE_URL = "https://gorest.co.in/public-api/users";
    private final String USER_BY_ID = "/{userId}";

    public Response getUserById(String id) {
        return given()
                .pathParam("userId", id)
                .when()
                .get(USER_BY_ID)
                .then().extract().response();
    }

    public Response getUsers() {
        return given()
                .when()
                .get()
                .then().extract().response();
    }

    public Response createUser(User user, String accessToken) {
        return given()
                .body(user)
                .header(new Header("Authorization", "Bearer " + accessToken))
                .when()
                .post()
                .then().extract().response();
    }

    public Response updateUser(String userId, User user, String accessToken) {
        return given()
                .body(user)
                .header(new Header("Authorization", "Bearer " + accessToken))
                .pathParam("userId", userId)
                .when()
                .put(USER_BY_ID)
                .then().extract().response();
    }

    public Response deleteUser(String userId, String accessToken) {
        return given()
                .header(new Header("Authorization", "Bearer " + accessToken))
                .pathParam("userId", userId)
                .when()
                .delete(USER_BY_ID)
                .then().extract().response();
    }

    private RequestSpecification given() {
        return RestAssured.given()
                .log().uri()
                .log().body()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON);
    }
}
