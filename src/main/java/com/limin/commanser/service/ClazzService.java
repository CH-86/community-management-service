package com.limin.commanser.service;

import com.limin.commanser.dto.ClazzDto;
import com.limin.commanser.entity.Clazz;

import java.util.List;

/**
 *
 *
 * @author Administrator
 * 2021.03.06 21:22
 */
public interface ClazzService {
    List<ClazzDto> findAll();
    Integer add(Clazz clazz);

    void update(Clazz clazz);
}
