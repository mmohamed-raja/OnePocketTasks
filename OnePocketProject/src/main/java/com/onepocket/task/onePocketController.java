package com.onepocket.task;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class onePocketController {
	@GetMapping("onepocket")
    public String helloWorld() {
        return "Hello world!";
    }

}
