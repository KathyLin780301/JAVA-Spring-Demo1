package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DemoModel;
import com.example.demo.model.DemoRepository;

@Service
public class DemoService {
    @Autowired
    private DemoRepository demoRepository;
    public DemoModel getUserByName(String name){
        System.out.println("GetUserByName is being excuted.");
        return this.demoRepository.findByName(name);
    }

    public DemoModel createUserByName(String name) {
        DemoModel model = new DemoModel();
        model.setName(name);
        return this.demoRepository.save(model);
    }

    public void performTask() {
        System.out.println("Task is being performed.");
    }
}
