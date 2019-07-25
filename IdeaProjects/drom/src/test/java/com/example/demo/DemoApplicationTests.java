package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    private MockMvc mockMvc; //此类可以模拟发送http请求

    @Before
    public void contextLoads() {   //创建mockMvc对象，同时指定哪个handler发送
        mockMvc =
                MockMvcBuilders.standaloneSetup(new UserHandler()).build();
    }
    @Test
    public void send(){ //发送请求
        //post("/user/all")请求方式及url
        //param("uid","1001")；请求的参数
        //accept（"MediaType.APPLICATION_JSON_UTF8"):期望返回类型
        //andDo(MockMvcResultHandlers.print() 打印数据
        try {
            mockMvc.perform(MockMvcRequestBuilders.post("/login").param("uid","1001").param("uname","list").accept(MediaType.APPLICATION_JSON_UTF8)).andDo(MockMvcResultHandlers
            .print());
        }catch (Exception e){

        }
    }

}
