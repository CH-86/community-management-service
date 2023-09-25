package com.limin.commanser.service.impl;

import com.limin.commanser.dto.UserDto;
import com.limin.commanser.entity.User;
import com.limin.commanser.mapper.UserMapper;
import com.limin.commanser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 用户接口实现类
 *
 * @author Administrator
 * 2021.02.19 16:46
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Autowired
    UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /*
     * 分页查询所有用户 admin 权限功能
     * @param params
     * @return List<User>
     */
    @Override
    public List<UserDto> findAll(Map<Object, Object> params) {
        return userMapper.findAll(params);
    }

    /*
     * 用户登录功能
     * @param user
     * @return User
     */
    @Override
    public User findOne(User user) {
        return userMapper.findOne(user);
    }

    @Override
    public void add(User user) {
        userMapper.add(user);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public User findById(String userId) {
        return userMapper.findById(userId);
    }

    @Override
    public void deleteById(String userId) {
        userMapper.deleteById(userId);
    }

    @Override
    public Integer batchDeleteById(String[] ids) {
        return userMapper.batchDeleteById(ids);
    }

    @Override
    public Integer getTotal() {
        return userMapper.getTotal();
    }

    @Override
    public List<User> findAllByLikeUserName(String userName) {
        return userMapper.findAllByLikeUserName(userName);
    }

    @Override
    public List<UserDto> findByCommunityId(Integer communityId, Integer status) {
        return userMapper.findByCommunityId(communityId, status);
    }

    @Override
    public void memberRemoveById(String userId, Integer communityId) {
        userMapper.memberRemoveById(userId, communityId);
    }

    @Override
    public void memberApprovalById(String userId, Integer communityId) {
        userMapper.memberApprovalById(userId, communityId);
    }

    @Override
    public Integer memberByStatistics(Integer communityId) {
        return userMapper.memberByStatistics(communityId);
    }

    @Override
    public List<User> findAllUserForOption() {
        return userMapper.findAllUserForOption();
    }
}
