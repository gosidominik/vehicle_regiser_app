package org.example.utils;

import org.json.JSONException;
import org.json.JSONObject;

public class Validator {
public static JSONObject validate(JSONObject jsonObject) {
    try {
        if(jsonObject.getString("registrationNumber").equals("")) {
            jsonObject.put("message", "Kötelező rendszámot megadni!");
        } else {
            return jsonObject;
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return jsonObject;
}
}
