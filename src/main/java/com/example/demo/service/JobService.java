package com.example.demo.service;

import com.example.demo.taskInstance.JobPros1;
import com.example.demo.taskInstance.ScheduleTable;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.List;


public class JobService implements JSInterface{
    // 从工厂中获取调度的实例
    public Scheduler scheduler = new StdSchedulerFactory().getScheduler();

    public JobService() throws SchedulerException {

    }


    public void addJob(JobPros1 jp) {
        //任务实例化
        JobDetail jobDetail = JobBuilder.newJob(OutlierJob.class)
                .withIdentity(jp.getName(),jp.getType())
                .build();
        //添加job到jobdatamap中
        jobDetail.getJobDataMap().put("name",jp.getName());
        jobDetail.getJobDataMap().put("groupId",jp.getType());
        jobDetail.getJobDataMap().put("duration",jp.getDuration());

        //触发器
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity(jp.getName(),jp.getType()).startNow()
                .build();
        System.out.println(jp.getName()+"'s trigger 启动");
        //将job加入调度
        // 4、让调度器关联任务和触发器，保证按照触发器定义的调整执行任务
        try {
            scheduler.scheduleJob(jobDetail,trigger);
            if (!scheduler.isShutdown()){
                scheduler.start();
                System.out.println("项目启动");
            }
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public  void removeJob(JobPros1 jp){
        System.out.println(jp.getName()+" exit");
        JobKey jobkey = JobKey.jobKey(jp.getName(), jp.getType());
        TriggerKey triggerKey = TriggerKey.triggerKey(jp.getName(),jp.getType());
        try {
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(jobkey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }
}
