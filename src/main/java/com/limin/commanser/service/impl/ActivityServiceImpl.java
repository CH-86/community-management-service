package com.limin.commanser.service.impl;

import com.limin.commanser.dto.ActivityDto;
import com.limin.commanser.dto.JoinActivityDto;
import com.limin.commanser.entity.Activity;
import com.limin.commanser.entity.User;
import com.limin.commanser.mapper.ActivityMapper;
import com.limin.commanser.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 2021.03.18 18:10
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityMapper activityMapper;

    @Autowired
    ActivityServiceImpl(ActivityMapper activityMapper) {
        this.activityMapper = activityMapper;
    }

    @Override
    public List<ActivityDto> findAllByPaging(Map<Object, Object> params) {
        return activityMapper.findAllByPaging(params);
    }

    @Override
    public Integer findTotal() {
        return activityMapper.findTotal();
    }

    @Override
    public void add(Activity activity) {
        activityMapper.add(activity);
    }

    @Override
    public void removeById(Integer activityId) {
        activityMapper.removeById(activityId);
    }

    @Override
    public Integer modify(Activity activity,User user) {
        if (user.getUserType() == 1 && user.getUserCommunityId().equals(activity.getActivityCommunityId())) {
            activityMapper.modify(activity);
            return 200;
        } else {
            return 401;
        }

    }

    @Override
    public void approvalActivity(Activity activity) {
        activityMapper.approvalActivity(activity);
    }

    @Override
    public Map<String, List<ActivityDto>> findByUser(User user, Integer activityType) {
        Map<String, List<ActivityDto>> mapResult = new HashMap<>();
        if (user.getUserType() == 1) {
            // 社团管理员：发布的活动、参加的活动、参加过的招新、发布过的招新
            mapResult.put("adminPublish", activityMapper.findPuplishActivities(user.getUserCommunityId(), activityType));
            mapResult.put("adminJoin", activityMapper.findJoinActivities(user.getUserId(), activityType));
        } else if (user.getUserType() == 0) {
            // 普通用户： 参加的活动、参加过的招新
            mapResult.put("commonJoin", activityMapper.findJoinActivities(user.getUserId(), activityType));
        }

        return mapResult;
    }

    @Override
    public Integer findAllByCommunityIdStatistics(Integer communityId) {
        return activityMapper.findAllByCommunityIdStatistics(communityId);
    }

    @Override
    public List<Activity> findAllByStatistics() {
        return activityMapper.findAllByStatistics();
    }

    @Override
    public void joinActivity(JoinActivityDto joinActivityDto) {
        activityMapper.joinActivity(joinActivityDto);
    }
}
