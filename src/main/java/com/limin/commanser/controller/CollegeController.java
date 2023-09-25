package com.limin.commanser.controller;

import com.limin.commanser.entity.College;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.CollegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 学院信息控制器
 *
 * @author Administrator
 * 2021.03.06 21:24
 */
@RestController
public class CollegeController {
    private final CollegeService collegeService;

    @Autowired
    CollegeController(CollegeService collegeService) {
        this.collegeService = collegeService;
    }

    /*
     *  查询所有学院信息
     * @return Result
     */
    @GetMapping("/colleges")
    public Result findAll() {
        return ResultGenerator.genOkResult(collegeService.findAll());
    }

    /**
     * 添加学院
     *
     * @param college 学院
     * @return Result
     */
    @PostMapping("/colleges")
    public Result add(@RequestBody College college) {
        return ResultGenerator.genOkResult(collegeService.add(college));
    }


    /**
     * 修改学院信息
     * @param college   学院
     * @return Result
     */
    @PutMapping("/colleges")
    public Result update(@RequestBody College college){
        collegeService.update(college);
        return ResultGenerator.genOkResult("修改成功");
    }
}
