package org.tietoevry;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class UserResourceTest {

    @Test
    void testUsersEndpoint() {
        given()
          .when().get("/users")
          .then()
             .statusCode(200)
             .body("size()", is(10))
             .body("[9].email", is("Rey.Padberg@karina.biz"));
    }

    @Test
    void testKnownUser() {
        given()
          .when().get("/users/1")
          .then()
            .statusCode(200)
            .body("id", is(1))
            .body("name", is("Leanne Graham"))
            .body("username", is("Bret"))
            .body("email", is("Sincere@april.biz"));
    }

    @Test
    void testUserNotFound() {
        given()
          .when().get("/users/999")
          .then()
            .statusCode(404);
    }

}
