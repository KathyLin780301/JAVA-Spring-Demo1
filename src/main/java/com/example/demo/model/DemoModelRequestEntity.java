package com.example.demo.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class DemoModelRequestEntity {
    @NotNull
    @NotEmpty
    private String name;

    public String getName(){
        return this.name;
    }
    
    public void setName(String name){
        this.name = name;
    }
}
