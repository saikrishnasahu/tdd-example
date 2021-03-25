package com.wipro.tddexample.controller;


import com.wipro.tddexample.service.TDDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tdd")
public class TDDController {

    @Autowired
    private TDDService tddService;

    @GetMapping
    public String helloWorld() {
        return tddService.helloWorld();
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello hello() {
        return new Hello("Greetings", "Hello World");
    }

    @GetMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Hello post(@RequestBody Hello hello) {
        return hello;
    }

    public static class Hello {
        private String name;
        private String value;

        public Hello(String name, String value) {
            this.name = name;
            this.value = value;
        }

        public Hello() {

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
