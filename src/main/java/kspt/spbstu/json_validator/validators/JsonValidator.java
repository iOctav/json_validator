package kspt.spbstu.json_validator.validators;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonValidator {

    public String validateJson(String json) {
        try {
            new JSONObject(json);
            new JSONArray(json);
        } catch (JSONException ex) {
            return errorMapping(ex);
        }
        return null;
    }

    private String errorMapping(final JSONException exception) {
        Map<String, String> errorMap = new HashMap<String, String>() {{
            //put("errorCode", filename);
            put("errorMessage", exception.getMessage().split(" at ")[0]);
            put("errorPlace", exception.getMessage().split(" at ")[1]);
            //put("resource", request.getPathInfo());
            //put("request-id", request.getRequestedSessionId());
        }};
        return errorMap.toString();
    }
}
