package kspt.spbstu.json_validator.controllers;

import kspt.spbstu.json_validator.validators.JsonValidator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

@RestController
public class JsonUploadController {


    @PostMapping
    public ResponseEntity uploadFile(@RequestBody String input) {
        String decodedInput;
        try {
            decodedInput = URLDecoder.decode(input, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            return new ResponseEntity(ex.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
        }
        String result = new JsonValidator().validateJson(decodedInput);
        if (result == null) {
            return new ResponseEntity(decodedInput, HttpStatus.OK);
        } else {
            return new ResponseEntity(result, HttpStatus.CONFLICT);
        }
    }
}