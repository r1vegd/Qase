package adapters;

import com.google.gson.Gson;

import static io.restassured.RestAssured.given;

public class BaseAdapter {
    Gson gson = new Gson();

    public String post(String body, int statusCode, String url) {
        return given().
                log().all().
                header("Token", "6771ea4f3389e8abe8de1be51094b96cf8a5177c").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
                body(body).
        when().
                post("https://api.qase.io/v1/" + url).
        then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();
    }

    public String get(int statusCode, String url) {
        return given().
                log().all().
                header("Token", "6771ea4f3389e8abe8de1be51094b96cf8a5177c").
                header("Content-Type", "application/json").
                header("Accept", "application/json").
        when().
                get("https://api.qase.io/v1/" + url).
        then().
                log().all().
                statusCode(statusCode).
                extract().
                body().
                asString();
    }


}
