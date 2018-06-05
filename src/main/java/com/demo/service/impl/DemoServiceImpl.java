package com.demo.service.impl;

import com.demo.dao.PersonMapper;
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
     * exception需特别设定
     *
     *
     */
    @Override
//    @Transactional(rollbackFor = Exception.class)
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
