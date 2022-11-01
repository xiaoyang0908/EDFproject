package com.example.demo;

import com.example.demo.controller.ScheduleTableController;
import com.example.demo.taskInstance.ScheduleTable;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@MapperScan("com.example.demo.dao")
public class demoApplication {
    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class, args);
    }

}
