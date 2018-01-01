package kspt.spbstu.json_validator.validators;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/** Class for validation
 * @author Andrei
 */
public class JsonValidator {

    /**
     *
     * @param json
     * @return formatted json or error of format
     */
    public String validateJson(String json) {
        try {
            new JSONObject(json);
        } catch (JSONException ex) {
            return errorMapping(ex);
        }
        return null;
    }

    /**
     *
     * @param exception
     * @return Formmated json error
     */
    private String errorMapping(final JSONException exception) {
        Map<String, String> errorMap = new HashMap<String, String>() {{
            put("errorCode", "12345");
            put("errorMessage", exception.getMessage().split(" at ")[0]);
            put("errorPlace", exception.getMessage().split(" at ")[1]);
            put("resource", "filename.json");
            put("request-id", "12345");
        }};
        return errorMap.toString();
    }
}