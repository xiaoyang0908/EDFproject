package com.example.demo.service;

import com.example.demo.dao.JobPros1Mapper;
import com.example.demo.taskInstance.JobPros1;
import com.example.demo.taskInstance.ScheduleTable;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@Service("schedulerOperation")
public class SchedulerOperation implements ScheculerService{

    @Autowired
    private JobPros1Mapper jpsMapper;
    @Override
    public List<ScheduleTable> EDFSimulation() {
        List<ScheduleTable> st = new ArrayList<>();
        List<JobPros1> taskList = jpsMapper.findAllTasks();
        System.out.println(taskList.toArray());

        int timeUnit = 0;
        //第一次按照deadline的时间从小到大排序
//        sortedList(taskList);

        int[] periodList = new int[taskList.size()];
        for (int i=0; i<periodList.length;i++) {
            periodList[i] = taskList.get(i).getPeriod();
        }
        int leastCommonPeriod = getLcm(periodList);

        for (JobPros1 jp: taskList) {
             if (jp.getType().equals("TT")){
                 jp.setComputeTime(jp.getDuration());
             }
        }

        //添加任务
        //任务执行完的时间
        while (timeUnit < leastCommonPeriod) {
            for (JobPros1 jp: taskList) {
                //TT + EDF
                if (jp.getType().equals("TT")) {
                    //初始化计算时间
                    if (jp.getComputeTime() > 0 && jp.getDeadline() <= timeUnit) {
                        System.out.println(jp.getName() + "missed the deadline");//deadline miss
                        return null;
                    }
                    if (timeUnit % jp.getPeriod() == 0) {
                        jp.setReleaseTime(timeUnit);
                        jp.setComputeTime(jp.getDuration());
                        jp.setDeadline(timeUnit + jp.getDeadline());
                    }
                }

            }
            //polling server + TT
            //找到当前TT最先执行的事件
            sortedList(taskList);
            JobPros1 jpEarliest = new JobPros1();
            for (JobPros1 jp1: taskList) {
                if (jp1.getType().equals("TT")){
                    jpEarliest = jp1;
                    break;
                }
            }
            for (JobPros1 jp: taskList) {
                if (jp.getType().equals("TT")) {
                    if (jp.getComputeTime() == 0) {
                        st.add(new ScheduleTable(timeUnit, "idle slot"));
                    }else {
                        st.add(new ScheduleTable(timeUnit, "TT", jpEarliest));
                        jp.setComputeTime(jp.getComputeTime() - 1);
                        if (jp.getComputeTime() == 0 && jp.getDeadline() >= timeUnit) {
                            if (timeUnit - jp.getReleaseTime() >= jp.getWCRT()) {
                                jp.setWCRT(timeUnit - jp.getReleaseTime());
                            }
                        }
                    }
                }
            }
            timeUnit++;
        }

        for (int i = 0; i < taskList.size();i++) {
            if (taskList.get(i).getComputeTime()>0){
                return null;
            }
        }

         return st;
    }

    //设置所有TT job的周期最小公倍数
    public int getLcm(int[] arr){
		int lcm = arr[0];
        for (boolean flag = true;flag;){
            for (int p : arr) {
                if (lcm%p!=0){
                    flag = true;
                    break;
                }
                flag = false;
            }
            lcm = flag?(lcm+1) :lcm;
        }
       return lcm;
    }

    @Override
    public void sortedList(List<JobPros1> list) {
        Collections.sort(list, new Comparator<JobPros1>() {
            @Override
            public int compare(JobPros1 o1, JobPros1 o2) {
                return o1.getDeadline()-o2.getDeadline();
            }
        });
    }
}


