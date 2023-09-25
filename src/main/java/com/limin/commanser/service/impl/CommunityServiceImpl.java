package com.limin.commanser.service.impl;

import com.limin.commanser.dto.CommunityDto;
import com.limin.commanser.dto.JoinCommunityDto;
import com.limin.commanser.entity.Community;
import com.limin.commanser.mapper.CommunityMapper;
import com.limin.commanser.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 * 2021.03.10 23:29
 */
@Service
public class CommunityServiceImpl implements CommunityService {

    private final CommunityMapper communityMapper;

    @Autowired
    CommunityServiceImpl(CommunityMapper communityMapper) {
        this.communityMapper = communityMapper;
    }

    @Override
    public List<Community> findAll() {
        return communityMapper.findAll();
    }

    @Override
    public Integer add(Community community) {
        return communityMapper.add(community);
    }

    @Override
    public void modify(Community community) {
        communityMapper.modify(community);
    }

    @Override
    public void removeById(Integer communityId) {
        communityMapper.removeById(communityId);
    }

    @Override
    public Integer findTotal() {
        return communityMapper.findTotal();
    }

    @Override
    public Community findById(Integer communityId) {
        return communityMapper.findById(communityId);
    }

    @Override
    public void approvalCommunity(Community community) {
        communityMapper.approvalCommunity(community);
    }

    @Override
    public List<CommunityDto> findAllByPaging(Map<Object, Object> params) {
        return communityMapper.findAllByPaging(params);
    }

    @Override
    public void joinCommunity(JoinCommunityDto joinCommunityDto) {
        communityMapper.joinCommunity(joinCommunityDto);
    }
}
