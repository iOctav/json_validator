package kspt.spbstu.json_validator.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@RestController
public class JsonUploadController {


    @PostMapping
    public ResponseEntity uploadFile(@RequestBody String input) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String decodedInput = URLDecoder.decode(input, "UTF-8");
            mapper.readValue(decodedInput, Object.class);
            return new ResponseEntity(decodedInput, HttpStatus.OK);
        } catch (final IOException ex_ser) {
            Map<String, String> errorMap = new HashMap<String, String>() {{
                //put("errorCode", filename);
                put("errorMessage", ex_ser.getMessage().split("\n at ")[0]);
                put("errorPlace", ex_ser.getMessage().split("; ")[1]
                    .substring(0,ex_ser.getMessage().split("; ")[1].length()-2));
                //put("resource", request.getPathInfo());
                //put("request-id", request.getRequestedSessionId());
            }};
            return new ResponseEntity(errorMap, HttpStatus.BAD_REQUEST);
        }
    }
}