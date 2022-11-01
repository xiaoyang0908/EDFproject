package com.example.demo.controller;


import com.example.demo.dao.JobPros1Mapper;
import com.example.demo.service.ScheculerService;
import com.example.demo.taskInstance.JobPros1;
import com.example.demo.taskInstance.ScheduleTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value ="/scheduleTable",method = RequestMethod.GET)
public class ScheduleTableController {
    @Autowired
    private ScheculerService scheculerService;

    @GetMapping("/getTaskInfo")
    public List<ScheduleTable> getScheduleTable() {
        return  scheculerService.EDFSimulation();
    }
}
