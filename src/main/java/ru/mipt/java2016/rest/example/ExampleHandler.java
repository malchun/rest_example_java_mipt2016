package ru.mipt.java2016.rest.example;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by malchun on 11/26/16.
 */

@RestController
public class ExampleHandler {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<String> homeresp() {
        System.out.println("Hello");
        ResponseEntity<String> resp = new ResponseEntity<>("<head><title>Example</title></head><body><p style='color:red'>Hello, World!</p></body>", HttpStatus.OK);
        return resp;
    }
    @RequestMapping(value = "/put/{name}", method = RequestMethod.PUT)
    public ResponseEntity<ExampleEntity> put(@RequestParam(value = "args", defaultValue = "x") List<String> vars, @PathVariable String name, @RequestBody String body) {
        System.out.println("PUT");
        ResponseEntity<ExampleEntity> resp = new ResponseEntity<>(new ExampleEntity(name, vars, body), HttpStatus.CREATED);
        return resp;
    }
}
