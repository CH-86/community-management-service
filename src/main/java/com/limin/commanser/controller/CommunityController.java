package com.limin.commanser.controller;

import com.github.pagehelper.PageHelper;
import com.limin.commanser.dto.CommunityDto;
import com.limin.commanser.dto.JoinCommunityDto;
import com.limin.commanser.entity.Community;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.CollegeService;
import com.limin.commanser.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 社团信息控制器
 *
 * @author Administrator
 * 2021.03.06 21:24
 */
@RestController
public class CommunityController {
    private final CommunityService communityService;

    @Autowired
    CommunityController(CommunityService communityService) {
        this.communityService = communityService;
    }

    /*
     *  查询所有社团信息信息
     * @return Result
     */
    @GetMapping("/communities")
    public Result findAll() {
        List<Community> communities = communityService.findAll();
        communities = communities.stream()
                    .filter(community -> !community.getCommunityName().equals("无"))
                    .collect(Collectors.toList());
        return ResultGenerator.genOkResult(communities);
    }

    /*
     * 分页查询所有社团信息
     * @return Result
     */
    @GetMapping("/communities/paging")
    public Result findAllByPaging(@RequestParam("pageNum") Integer pageNum,
                                  @RequestParam("pageSize") Integer pageSize,
                                  @RequestParam(value = "order", required = false, defaultValue = "DESC") String order) {
        PageHelper.startPage(pageNum, pageSize);
        Map<Object, Object> params = new HashMap<>();
        params.put("order", order);
        List<CommunityDto> communityList = communityService.findAllByPaging(params);
        return ResultGenerator.genOkResult(communityList);
    }

    /**
     * 查询社团总记录条数
     *
     * @return Result
     */
    @GetMapping("/communities/total")
    public Result findTotal() {
        return ResultGenerator.genOkResult(communityService.findTotal());
    }

    /*
     * 添加社团信息
     * @param community  社团信息
     * @return Result
     */
    @PostMapping("/communities")
    public Result add(@RequestBody Community community) {
        return ResultGenerator.genOkResult(communityService.add(community));
    }

    /*
     * 修改社团信息
     * @param community
     * @return Result
     */
    @PutMapping("/communities")
    public Result modify(@RequestBody Community community) {
        communityService.modify(community);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 根据登录用户查询我的社团信息
     * @param communityId
     * @return Result
     */
    @GetMapping("/communities/{communityId}")
    public Result findById(@PathVariable("communityId") Integer communityId) {
        Community community = communityService.findById(communityId);
        return ResultGenerator.genOkResult(community);
    }

    /*
     * 管理员审核
     * @param community
     * @return Result
     */
    @PutMapping("/communities/approvalCommunity")
    public Result approvalCommunity(@RequestBody Community community) {
        communityService.approvalCommunity(community);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     * 根据ID删除社团信息
     * @param communityId
     * @return Result
     */
    @DeleteMapping("/communities/}{communityId}")
    public Result removeById(@PathVariable("communityId") Integer communityId) {
        communityService.removeById(communityId);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     *用户报名参加社团
     * @param [joinCommunityDto]
     * @return com.limin.commanser.result.Result
     */
    @PostMapping("/communities/join")
    public Result joinCommunity(@RequestBody JoinCommunityDto joinCommunityDto) {
        try{
            communityService.joinCommunity(joinCommunityDto);
        }catch (Exception e){
            System.out.println("当前用户已经在此社团" + joinCommunityDto.toString());
            return  ResultGenerator.genFailureResult("您已经完成报名，请勿重复提交，耐心等待管理员审核");
        }

        return ResultGenerator.genOkResult("ok");
    }
}
