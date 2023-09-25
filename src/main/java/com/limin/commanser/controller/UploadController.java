package com.limin.commanser.controller;

import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 图片、文件上传控制器
 *
 * @author Administrator
 * 2021.03.18 11:36
 */
@RestController
/*跨域处理*/
@CrossOrigin
public class UploadController {

    /*
     * 图片上传
     * @param multipartFile
     * @return String
     */
    @PostMapping("/uploadImg")
    public Result uploadImg(@RequestParam("file") MultipartFile multipartFile) {
        // 获取文件存储相对路径
        String storePath = System.getProperty("user.dir") + "/src/main/resources/static/images/";
        // 使用绝对路径 回显
//        String storePath = "D:\\community-management-service\\static\\images\\";
        // 获取完整文件名称
        String fileName = multipartFile.getOriginalFilename();
        // 判断目录是否存在，没有则创建
        assert fileName != null;
        File file = new File(storePath, fileName);
        if (!file.getParentFile().exists()) {
            boolean mkdirs = file.getParentFile().mkdirs();
        }

        // 上传
        try {
            multipartFile.transferTo(file);
            return ResultGenerator.genOkResult(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return ResultGenerator.genFailureResult("图片上传失败");
        }
    }

    @GetMapping("/static/images/{fileName}")
    public byte[] getImg(@PathVariable("fileName") String fileName) throws IOException {
        assert fileName != null;
        // 获取文件存储相对路径
        String storePath = System.getProperty("user.dir") + "/src/main/resources/static/images/";

        File file = new File(storePath+fileName);
        if(!file.exists()) return new byte[0];

        FileInputStream inputStream = new FileInputStream(file);

        byte[] bytes = new byte[inputStream.available()];
        inputStream.read(bytes, 0, inputStream.available());

        return bytes;
    }


}

