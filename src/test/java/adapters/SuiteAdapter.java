package adapters;

import static io.restassured.RestAssured.given;

public class SuiteAdapter extends BaseAdapter {

    public String post(String body, int statusCode, String codeProject) {
        return super.post(body, statusCode, "suite/" + codeProject);
    }


}
