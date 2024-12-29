package com.example.demo.controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.aspect.LoggingAspect;
import com.example.demo.model.DemoModel;
import com.example.demo.model.DemoModelRequestEntity;
import com.example.demo.service.DemoService;

import jakarta.validation.Valid;

@RestController
@Import(LoggingAspect.class)
public class DemoController {

    @Autowired
    private DemoService demoService;
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello Ivan!";
    }

    @GetMapping("/model")
    public ResponseEntity<DemoModel> getModel(
            @RequestParam int id, 
            @RequestParam(required = false, defaultValue = "Test") String name) {
        DemoModel model = new DemoModel(id, name);
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @PostMapping("/model/register")
    public ResponseEntity<?> register(
        @Valid @ModelAttribute DemoModelRequestEntity modelBody,
        BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>("Validation errors: " + result.getAllErrors(), HttpStatus.BAD_REQUEST);
        }
        // Save the model to the database
        // String name = (String) jsonBody.get("name");
        // if (name == null) {
        //     throw new RuntimeException("name can't be null");
        // }
        DemoModel savedModel = demoService.createUserByName(modelBody.getName());
        return new ResponseEntity<>(savedModel, HttpStatus.CREATED);
    }

    @GetMapping("/model/{name}")
    public DemoModel getUserByName(@PathVariable String name) {
        DemoModel demoModel = demoService.getUserByName(name);
        if(demoModel == null) {
            throw new RuntimeException("demoModel can't be null");
        }
        return demoModel;
    }

    @ExceptionHandler(Exception.class)
    public String handleException(Exception e, Model model) {
        return String.format("error: %s", e.getMessage());
    }
}
