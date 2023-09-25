package com.limin.commanser.controller;

import com.limin.commanser.dto.RankDto;
import com.limin.commanser.entity.Activity;
import com.limin.commanser.entity.Community;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.ActivityService;
import com.limin.commanser.service.CommunityService;
import com.limin.commanser.service.NewsService;
import com.limin.commanser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.util.*;

/**
 * 统计 社团评优
 * dingwen
 * 2021/3/25 23:41
 **/
@RestController
public class StatisticsController {
    private final CommunityService communityService;
    private final NewsService newsService;
    private final ActivityService activityService;
    private final UserService userService;


    @Autowired
    StatisticsController(CommunityService communityService,
                         ActivityService activityService,
                         UserService userService,
                         NewsService newsService) {
        this.communityService = communityService;
        this.newsService = newsService;
        this.activityService = activityService;
        this.userService = userService;
    }

    /*
     *统计每个社团的新闻、公告数量
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("/statistics/news")
    public Result newsStatistics() {
        Map<String, List<String>> result = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        List<Community> communityList = communityService.findAll();
        communityList.stream()
                .filter(c -> !c.getCommunityName().equals("无")).sequential()
                .forEach(community -> {
                    nameList.add(community.getCommunityName());
                    valueList.add(newsService.findAllByCommunityIdStatistics(community.getCommunityId()).toString());
                });
        result.put("name", nameList);
        result.put("value", valueList);
        return ResultGenerator.genOkResult(result);
    }


    /*
     *统计每个社团的活动数量
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("/statistics/activities")
    public Result activitiesStatistics() {
        Map<String, List<String>> result = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        List<Community> communityList = communityService.findAll();
        communityList.stream()
                .filter(c -> !c.getCommunityName().equals("无"))
                .sequential()
                .forEach(community -> {
                    nameList.add(community.getCommunityName());
                    valueList.add(activityService.findAllByCommunityIdStatistics(community.getCommunityId()).toString());
                });
        result.put("name", nameList);
        result.put("value", valueList);
        return ResultGenerator.genOkResult(result);
    }


    /*
     *统计每个社团的人员情况 【社团招新人数 + 活动报名参加人数 + 参与人数】
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("/statistics/members")
    public Result membersStatistics() {
        Map<String, List<String>> result = new HashMap<>();
        List<String> nameList = new ArrayList<>();
        List<String> valueList = new ArrayList<>();
        List<Community> communityList = communityService.findAll();
        communityList.stream()
                .filter(c -> !c.getCommunityName().equals("无"))
                .sequential()
                .forEach(community -> {
                    nameList.add(community.getCommunityName());
                    valueList.add(userService.memberByStatistics(community.getCommunityId()).toString());
                });
        result.put("name", nameList);
        result.put("value", valueList);
        return ResultGenerator.genOkResult(result);
    }

    /*
     *优秀社团评选 社团排名
     * @param []
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("statistics/rank")
    public Result ranking() {
        List<Integer> activityScore = new ArrayList<>();
        List<String> nameList = new ArrayList<>();

        communityService.findAll().stream()
                .filter(c -> !c.getCommunityName().equals("无"))
                .sequential()
                .forEach(community -> {
                    nameList.add(community.getCommunityName());
                    activityScore.add((activityService.findAllByCommunityIdStatistics(community.getCommunityId()) * 4));
                });


        List<Integer> memberScore = new ArrayList<>();
        communityService.findAll().stream()
                .filter(c -> !c.getCommunityName().equals("无"))
                .sequential()
                .forEach(community -> {
                    memberScore.add((userService.memberByStatistics(community.getCommunityId())) * 3);
                });


        List<Integer> newsScore = new ArrayList<>();
        communityService.findAll().stream()
                .filter(c -> !c.getCommunityName().equals("无")).sequential()
                .forEach(community -> {
                    newsScore.add((newsService.findAllByCommunityIdStatistics(community.getCommunityId())) * 3);
                });


        List<RankDto> rankList = new ArrayList<>();
        for (int i = 0; i < activityScore.size(); i++) {
            rankList.add(new RankDto(nameList.get(i), (activityScore.get(i) + newsScore.get(i) + memberScore.get(i)), i + 1));
        }
        Collections.sort(rankList, Comparator.comparing(RankDto::getScore).reversed());


        for (int i = 0; i < rankList.size(); i++) {
            rankList.get(i).setRankId(i + 1);
        }
        return ResultGenerator.genOkResult(rankList);
    }

}
