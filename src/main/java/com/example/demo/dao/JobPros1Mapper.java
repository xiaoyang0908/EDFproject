package com.example.demo.dao;

import com.example.demo.taskInstance.JobPros1;

import java.util.List;

public interface JobPros1Mapper {
    int deleteByPrimaryKey(String name);

    int insert(JobPros1 record);

    int insertSelective(JobPros1 record);

    JobPros1 selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(JobPros1 record);

    int updateByPrimaryKey(JobPros1 record);

    List<JobPros1> findAllTasks();
}