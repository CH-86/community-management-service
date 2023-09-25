package com.limin.commanser.service.impl;

import com.limin.commanser.entity.College;
import com.limin.commanser.mapper.CollegeMapper;
import com.limin.commanser.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @author Administrator
 * 2021.03.10 23:15
 */
@Service
public class CollegeServiceImpl implements CollegeService {
    private final CollegeMapper collegeMapper;
    @Autowired
    CollegeServiceImpl(CollegeMapper collegeMapper){
        this.collegeMapper = collegeMapper;
    }

    @Override
    public List<College> findAll() {
        return collegeMapper.findAll();
    }

    @Override
    public Integer add(College college) {
        return collegeMapper.add(college);
    }

    @Override
    public void update(College college) {
        collegeMapper.update(college);
    }
}
