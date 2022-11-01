package com.example.demo;

import com.example.demo.controller.ScheduleTableController;
import com.example.demo.dao.JobPros1Mapper;
import com.example.demo.taskInstance.JobPros1;
import com.example.demo.taskInstance.ScheduleTable;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = demoApplication.class)
class DemoApplicationTests {
    @Autowired
    private ScheduleTableController scheduleTableController;

    @Test
    public void test() {
        List<ScheduleTable> st = scheduleTableController.getScheduleTable();
        for (ScheduleTable t: st) {
            System.out.println(t.toString());
        }
    }

}
