package com.limin.commanser.service;

import com.limin.commanser.dto.CommunityDto;
import com.limin.commanser.dto.JoinCommunityDto;
import com.limin.commanser.entity.College;
import com.limin.commanser.entity.Community;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 2021.03.06 21:22
 */
public interface CommunityService {
    /**
     * 查询所有社团信息
     *
     * @return Community>
     */
    List<Community> findAll();

    /**
     * 添加社团
     * 管理员不需要通审核直接添加
     * 其他用户添加需要管理员审核
     *
     * @param community 社团
     * @return Integer
     */
    Integer add(Community community);


    /**
     * 修改社团信息
     * 管理员呢本社团管理员可以修改
     *
     * @param community 社团
     */
    void modify(Community community);

    /**
     * 管理员根据ID删除社团信息
     *
     * @param communityId 社团ID
     */
    void removeById(@Param("communityId") Integer communityId);

    /**
     * 获取社团表总记录条数
     *
     * @return Integer
     */
    Integer findTotal();


    /**
     * 根据登录用户查询我的社团信息
     *
     * @param communityId 社团ID
     * @return Community
     */
    Community findById(@Param("communityId") Integer communityId);


    /**
     * 管理员审核
     *
     * @param community `
     */
    void approvalCommunity(Community community);

    /**
     * 分页查询
     *
     * @param params 查询参数
     * @return Community>
     */
    List<CommunityDto> findAllByPaging(Map<Object, Object> params);


    /*
     *报名参加招新
     * @param [joinCommunityDto]
     * @return void
     */
    void joinCommunity(JoinCommunityDto joinCommunityDto);
}
