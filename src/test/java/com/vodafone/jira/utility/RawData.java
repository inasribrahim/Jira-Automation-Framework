package com.vodafone.jira.utility;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RawData {

    public  JsonPath rawToJson(Response response)
    {
        String respon= response.asString();
        JsonPath jsonPath =new JsonPath(respon);
            return jsonPath;
    }
}
