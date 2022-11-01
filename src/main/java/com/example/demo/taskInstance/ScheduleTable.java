package com.example.demo.taskInstance;

public class ScheduleTable {
    int time;
    String slotType;
    JobPros1 jp;

    public ScheduleTable(int time,String slotType) {
        this.time = time;
        this.slotType = slotType;
        this.jp = null;
    }

    public ScheduleTable(int time, String slotType,JobPros1 jp) {
        this.time = time;
        this.slotType = slotType;
        this.jp = jp;
    }

}
