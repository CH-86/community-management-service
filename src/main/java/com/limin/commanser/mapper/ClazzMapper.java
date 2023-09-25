package com.limin.commanser.mapper;

import com.limin.commanser.entity.Clazz;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 班级Mapper
 *
 * @author Administrator
 * 2021.03.06 21:17
 */
@Repository
public interface ClazzMapper {
    List<Clazz> findAll();

    Integer add(Clazz clazz);

    void update(Clazz clazz);
}