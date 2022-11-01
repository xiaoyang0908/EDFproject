package com.example.demo.service;

import org.quartz.*;

import java.util.Date;

//定义任务类
//单个task需要完成的任务
//实现监听

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class OutlierJob implements Job {
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //定义一个datamap
        JobDataMap dataMap = jobExecutionContext.getJobDetail().getJobDataMap();
        String name = dataMap.getString("name");
        int d = dataMap.getIntValue("duration");
        System.out.println(new Date()+" task ["+name+"] is running"+"---Thread: " + Thread.currentThread().getId());
        try {
            Thread.sleep(d*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(new Date()+" task ["+name+"] has finished"+"---Thread: " + Thread.currentThread().getId());
    }
}
