package com.example.demo.service;

import com.example.demo.taskInstance.JobPros1;
import com.example.demo.taskInstance.ScheduleTable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public interface ScheculerService {
    List<ScheduleTable> EDFSimulation();
    int getLcm(int[] arr);
    void sortedList(List<JobPros1> list);
}
