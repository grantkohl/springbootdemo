package com.demo.dao.local;

import com.demo.domain.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonMapper {

    int insert(Person record);

}