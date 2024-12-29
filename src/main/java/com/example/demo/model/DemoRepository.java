package com.example.demo.model;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DemoRepository extends JpaRepository<DemoModel, Integer>{
    DemoModel findByName(String name);
}
