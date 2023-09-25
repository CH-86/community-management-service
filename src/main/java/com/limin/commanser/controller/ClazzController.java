package com.limin.commanser.controller;

import com.limin.commanser.entity.Clazz;
import com.limin.commanser.entity.College;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 班级信息控制器
 *
 * @author Administrator
 * 2021.03.06 21:24
 */
@RestController
public class ClazzController {
    private final ClazzService clazzService;
    @Autowired
    ClazzController(ClazzService clazzService){
        this.clazzService = clazzService;
    }

    /*
     *  查询所有班级信息
     * @return Result
     */
    @GetMapping("/clazzs")
    public Result findAll(){
        return ResultGenerator.genOkResult(clazzService.findAll());
    }

    /**
     * 添加班级
     *
     * @param clazz 班级
     * @return Result
     */
    @PostMapping("/clazzs")
    public Result add(@RequestBody Clazz clazz) {
        return ResultGenerator.genOkResult(clazzService.add(clazz));
    }


    /**
     * 修改班级信息
     * @param clazz 班级
     * @return Result
     */
    @PutMapping("/clazzs")
    public Result update(@RequestBody Clazz clazz){
        clazzService.update(clazz);
        return ResultGenerator.genOkResult("修改成功");
    }
}
