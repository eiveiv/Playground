package server.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRest {

    @GetMapping(path = "/hello")
    public String get() {
        return "Hello";
    }
}
