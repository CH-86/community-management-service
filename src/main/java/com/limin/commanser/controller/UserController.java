package com.limin.commanser.controller;

import com.github.pagehelper.PageHelper;
import com.limin.commanser.dto.UserDto;
import com.limin.commanser.service.UserService;
import com.limin.commanser.entity.User;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户控制器
 *
 * @author Administrator
 * 2021.02.19 16:46
 */
@RestController
public class UserController {

    // 用户服务
    private final UserService userService;

    @Autowired
    UserController(UserService userService) {
        this.userService = userService;
    }

    /*
     * 用户表分页查询
     * @param pageNum  页码
     * @param pageSize  每页数量
     * @param order  desc:降序 asc: 升序
     * @return Result
     */
    @GetMapping("/users")
    public Result findAll(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(value = "order", required = false) String order) {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        //添加查询参数
        Map<Object, Object> params = new HashMap<>();
        params.put("order", order);
        return ResultGenerator.genOkResult(userService.findAll(params));
    }

    /*
     * 根据ID查询单个用户信息
     * @param userId
     * @return Result
     */
    @GetMapping("/users/{userId}")
    public Result findById(@PathVariable("userId") String userId) {
        return ResultGenerator.genOkResult(userService.findById(userId));

    }

    /*
     * 用户登录
     * @param user
     * @return Result
     */
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpServletRequest request) {
        User sessionUser = userService.findOne(user);
        if (sessionUser != null) {
            request.getSession().setAttribute("user", user);
            return ResultGenerator.genOkResult(sessionUser);
        } else {
            return ResultGenerator.genFailureResult("用户名或密码错误");
        }
    }

    /*
     * 用户注册
     * @param user
     * @return Result
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user) {
        userService.add(user);
        return ResultGenerator.genOkResult();
    }


    /**
     * 退出登录
     *
     * @return String
     */
    @GetMapping("/logout")
    public Result logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");

        return ResultGenerator.genOkResult();
    }

    /*
     * 修改用户信息
     * @param user
     * @return Result
     */
    @PostMapping("/updateUserInfo")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return ResultGenerator.genOkResult();
    }

    /*
     * 根据ID删除用户
     * @param userId
     * @return Result
     */
    @DeleteMapping("/users/{userId}")
    public Result deleteById(@PathVariable("userId") String userId) {
        userService.deleteById(userId);
        return ResultGenerator.genOkResult();
    }

    /**
     * 批量删除用户信息
     *
     * @param ids id array
     * @return Result
     */
    @PostMapping("/batchDeleteUser")
    public Result batchDeleteById(@RequestBody String[] ids) {
        return ResultGenerator.genOkResult(userService.batchDeleteById(ids));

    }

    /**
     * 查询用户表总记录条数
     *
     * @return Result
     */
    @GetMapping("/users/total")
    public Result getTotal() {
        return ResultGenerator.genOkResult(userService.getTotal());
    }

    /*
     * 根据姓名模糊查询用户
     * @return Result
     */
    @GetMapping("/users/likeName/{userName}")
    public Result findAllByLikeUserName(@PathVariable("userName") String userName) {
        return ResultGenerator.genOkResult(userService.findAllByLikeUserName(userName));
    }

    /*
     * 根据当前登录社团管理员用户查询社团的成员信息和招新信息
     * @param [communityId, status]
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("/users/findByCommunityId")
    public Result findByCommunityId(@RequestParam("communityId") Integer communityId, @RequestParam("status") Integer status) {
        List<UserDto> userList = userService.findByCommunityId(communityId, status);
        return ResultGenerator.genOkResult(userList);
    }

    /*
     * 移除社员
     * @param [communityId, userId]
     * @return com.limin.commanser.result.Result
     */
    @DeleteMapping("/users/memberRemoveById")
    public Result memberRemoveById(@RequestParam("communityId") Integer communityId, @RequestParam("userId") String userId) {
        userService.memberRemoveById(userId, communityId);
        return ResultGenerator.genOkResult();
    }

    /*
     * 同意招新进入的社员加入
     * @param [communityId, userId]
     * @return com.limin.commanser.result.Result
     */
    @PutMapping("/users/memberApprovalById")
    public Result memberApprovalById(@RequestParam("communityId") Integer communityId, @RequestParam("userId") String userId) {
        userService.memberApprovalById(userId, communityId);
        return ResultGenerator.genOkResult();
    }

    /*
     *获取所有用户列表
     * 用于下拉框选择
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("/users/options")
    public Result findAllUserForOption(){
        return ResultGenerator.genOkResult(userService.findAllUserForOption());
    }
}
