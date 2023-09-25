package com.limin.commanser.service.impl;

import com.limin.commanser.dto.ClazzDto;
import com.limin.commanser.entity.Clazz;
import com.limin.commanser.entity.College;
import com.limin.commanser.mapper.ClazzMapper;
import com.limin.commanser.mapper.CollegeMapper;
import com.limin.commanser.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Administrator
 * 2021.03.06 21:23
 */
@Service
public class ClazzServiceImpl implements ClazzService {
    private final ClazzMapper clazzMapper;
    private final CollegeMapper collegeMapper;
    @Autowired
    ClazzServiceImpl(ClazzMapper clazzMapper,CollegeMapper collegeMapper){
        this.clazzMapper = clazzMapper;
        this.collegeMapper = collegeMapper;
    }
    @Override
    public List<ClazzDto> findAll() {
        List<Clazz> clazzList = clazzMapper.findAll();
        List<ClazzDto> clazzDtoList = new ArrayList<>();
        clazzList.stream().sequential().forEach(clazz -> {
            College college = new College();
            college.setCollegeId(clazz.getCollegeId());
             String collegeName = collegeMapper.findById(college).getCollegeName();
             ClazzDto clazzDto = new ClazzDto();
             clazzDto.setCollegeName(collegeName);
             clazzDto.setClazzId(clazz.getClazzId());
             clazzDto.setClazzName(clazz.getClazzName());
             clazzDto.setCollegeId(clazz.getCollegeId());
             clazzDtoList.add(clazzDto);
        });
        return clazzDtoList;
    }

    @Override
    public Integer add(Clazz clazz) {
        return clazzMapper.add(clazz);
    }

    @Override
    public void update(Clazz clazz) {
        clazzMapper.update(clazz);
    }
}
