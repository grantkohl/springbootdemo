package com.demo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@Configuration
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseJunit {

    public static final String logMsgPart=
            "*********************************************************************************"
            +"\r\n"
            +"*                        单元测试                                               *"
            +"\r\n"
            +"*********************************************************************************"
            +"\r\n";
}
