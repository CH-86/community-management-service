package com.limin.commanser.mapper;

import com.limin.commanser.dto.ActivityDto;
import com.limin.commanser.dto.JoinActivityDto;
import com.limin.commanser.entity.Activity;
import com.limin.commanser.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * 活动、招新Mapper
 * 0: 其他 1:招新
 *
 * @author Administrator
 * 2021.03.18 16:15
 */
@Repository
public interface ActivityMapper {

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
    void modify(Activity activity);

    /*
     * 管理员审核活动
     * @param activity
     *
     */
    void approvalActivity(Activity activity);

    /*
     * 查询发布的活动、招新
     * @param communityId
     * @param activityType
     * @return ActivityDto>
     */
    List<ActivityDto> findPuplishActivities(@Param("communityId") Integer communityId, @Param("activityType") Integer activityType);


    /*
     * 查询参加的活动、招新
     * @param userId
     * @param activityType
     * @return ActivityDto>
     */
    List<ActivityDto> findJoinActivities(@Param("userId") String userId, @Param("activityType") Integer activityType);

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
