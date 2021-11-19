package RestTests;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class RestTest1 {
    @Test
    public void getUserName(){
        given()
                .baseUri("https://passport.yandex.ru")
                .basePath("/profile")
                .contentType(ContentType.JSON)
                .when().get()
                .then().statusCode(200);
    }
}
