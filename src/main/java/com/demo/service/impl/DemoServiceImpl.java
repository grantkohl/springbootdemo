package com.demo.service.impl;

import com.demo.config.DataSource;
import com.demo.config.DataSourceContextHolder;
import com.demo.dao.local.PersonMapper;
import com.demo.domain.Person;
import com.demo.service.DemoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DemoServiceImpl implements DemoService {

    @Resource
    PersonMapper personMapper;

    /**
     * 加这里也能回滚
     * 回滚后，id仍然会自增1
     * 需特别设定rollbackfor=Exception.class
     *
     * 自定义的注解DataSource并不能用在insertDB方法中
     */
    @Override
//    @Transactional
    @DataSource(value="devDataSource")
    public void insert() throws Exception {

        insertDB();

//        throw new Exception();
    }

    /**
     * 将transactional加在此处,内部调用不能回滚
     */
//    @Transactional
    public void insertDB() throws Exception {

        Person person = new Person();
        person.setName("brian");

        int id = personMapper.insert(person);
        System.out.println("==========="+id);

//        throw new Exception();
    }
}
