package com.limin.commanser.mapper;

import com.limin.commanser.entity.Clazz;
import com.limin.commanser.entity.College;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 学院Mapper
 *
 * @author Administrator
 * 2021.03.06 21:17
 */
@Repository
public interface CollegeMapper {
    List<College> findAll();
    Integer add(College college);
    void update(College college);
    College findById(College college);
}