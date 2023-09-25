package com.limin.commanser.service;

import com.limin.commanser.entity.College;

import java.util.List;

/**
 *
 *
 * @author Administrator
 * 2021.03.06 21:22
 */
public interface CollegeService {
    List<College> findAll();
    Integer add(College college);
    void update(College college);
}
