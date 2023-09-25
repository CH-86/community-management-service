package com.limin.commanser.service;

import com.limin.commanser.dto.ActivityDto;
import com.limin.commanser.dto.JoinActivityDto;
import com.limin.commanser.entity.Activity;
import com.limin.commanser.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 活动接口
 *
 * @author Administrator
 * 2021.03.18 16:41
 */
public interface ActivityService {
    /*
     * 分页查询活动信息
     * 根据结束时间降序
     * 其他活动、招新
     * 某某社团查询
     * @param params
     * @return ActivityDto>
     */
    List<ActivityDto> findAllByPaging(Map<Object,Object> params);

    /*
     * 活动表总记录条数
     * 分别查询 其他活动 & 招新
     * @return Integer
     */
    Integer findTotal();

    /*
     * 发布活动、招新
     * @param activity
     *
     */
    void add(Activity activity);

    /*
     * 管理员: 根据ID删除活动信息
     * @param activityId
     *
     */
    void removeById(@Param("activityId")Integer activityId);

    /*
     * 活动发布的社团负责人可以修改活动信息
     * @param activity
     *
     */
    Integer modify(Activity activity,User user);

    /*
     * 管理员审核活动
     * @param activity
     *
     */
    void approvalActivity(Activity activity);

    /*
     * 社团管理员：
     *           发布的活动
     *           参加的活动
     *
     * 普通用户：
     *          参加的活动
     * @param user
     */
    Map<String,List<ActivityDto>> findByUser(User user,Integer activityType);

    /*
     *统计查询某个社团有多少活动数据
     * @param []
     * @return java.util.List<com.limin.commanser.entity.News>
     */
    Integer findAllByCommunityIdStatistics(@Param("communityId") Integer communityId);

    /*
     *查询所有活动 【用于统计】
     * @param []
     * @return java.util.List<com.limin.commanser.entity.Activity>
     */
    List<Activity> findAllByStatistics();

    /*
     * 用户报名参加活动
     * @param
     * @return
     */
    void joinActivity(JoinActivityDto joinActivityDto);
}
