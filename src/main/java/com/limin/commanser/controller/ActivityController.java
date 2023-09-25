package com.limin.commanser.controller;

import com.github.pagehelper.PageHelper;
import com.limin.commanser.dto.ActivityDto;
import com.limin.commanser.dto.JoinActivityDto;
import com.limin.commanser.entity.Activity;
import com.limin.commanser.entity.User;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 2021.03.19 09:58
 */
@RestController
public class ActivityController {
    private final ActivityService activityService;

    @Autowired
    ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    /*
     * 分页查询所有活动列表、或者查询某个社团的活动列表
     * @param pageNum
     * @param pageSize
     * @param order
     * @param activityId
     * @return Result
     */
    @GetMapping("/activities")
    public Result findAllByPaging(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam(value = "order", required = false, defaultValue = "DESC") String order,
                                  @RequestParam(value = "communityId", required = false) Integer communityId,
                                  @RequestParam(value = "activityStatus",required = false) Integer activityStatus) {
        PageHelper.startPage(pageNum, pageSize);
        Map<Object, Object> params = new HashMap<>();
        params.put("order", order);
        params.put("communityId", communityId);
        params.put("activityStatus", activityStatus);
        List<ActivityDto> activityDtos = activityService.findAllByPaging(params);
        return ResultGenerator.genOkResult(activityDtos);
    }

    /*
     * 查询总记录条数
     * @return Result
     */
    @GetMapping("/activities/total")
    public Result findTotal() {
        return ResultGenerator.genOkResult(activityService.findTotal());
    }

    /*
     *发布活动、招新
     * @param activity
     * @return Result
     */
    @PostMapping("/activities")
    public Result add(@RequestBody Activity activity) {
        activityService.add(activity);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     *管理员根据ID删除活动信息
     * @param activityId
     * @return Result
     */
    @DeleteMapping("/activities/{activityId}")
    public Result removeById(@PathVariable Integer activityId) {
        activityService.removeById(activityId);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 修改活动信息
     * @param activity
     * @param userType
     * @param communityId
     * @return Result
     */
    @PutMapping("/activities/{userType}/{communityId}")
    public Result editActivity(@RequestBody Activity activity,
                               @PathVariable("userType") Integer userType,
                               @PathVariable("communityId") Integer communityId) {
        User user = new User();
        user.setUserCommunityId(communityId);
        user.setUserType(userType);
        activityService.modify(activity, user);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 管理员审核活动
     * @param activity
     * @return Result
     */
    @PutMapping("/activities/approval")
    public Result approvalActivity(@RequestBody Activity activity) {
        activityService.approvalActivity(activity);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 根据用户查询活动信息
     * @param userId
     * @param userType
     * @param activityType
     * @return Result
     */
    @GetMapping("/activities/{userId}/{userType}/{activityType}/{userCommunityId}")
    public Result findActivitiesByUser(@PathVariable("userId") String userId,
                                       @PathVariable("userType") Integer userType,
                                       @PathVariable("activityType") Integer activityType,
                                       @PathVariable("userCommunityId") Integer userCommunityId) {
        User user = new User();
        user.setUserType(userType);
        user.setUserId(userId);
        user.setUserCommunityId(userCommunityId);
        Map<String, List<ActivityDto>> data = activityService.findByUser(user, activityType);
        return ResultGenerator.genOkResult(data);
    }

    /*
     *用户报名参加活动
     * @param [joinActivityDto]
     * @return com.limin.commanser.result.Result
     */
    @PostMapping("/activities/join")
    public Result joinActivity(@RequestBody JoinActivityDto joinActivityDto) {
        try {
            activityService.joinActivity(joinActivityDto);
        } catch (Exception e) {
            System.out.println("当前用户已经完成报名" + joinActivityDto.toString());
            return ResultGenerator.genFailureResult("您已经完成报名，请勿重复提交");
        }
        return ResultGenerator.genOkResult("ok");
    }
}
