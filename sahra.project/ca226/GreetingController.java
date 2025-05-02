package com.just.ca226;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping

public class GreetingController {
    @GetMapping("/greeting")
    public String welcome(){
        return "asalama aleykum";
    }

    @GetMapping("/greet/{name}")
    public String greet(@PathVariable String name){
        return "hello,"+name+"!";
    }


}
