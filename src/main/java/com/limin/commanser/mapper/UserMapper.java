package com.limin.commanser.mapper;

import com.limin.commanser.dto.UserDto;
import com.limin.commanser.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
/**
 * 用户 Mapper 相当于 Dao
 *
 * @author Administrator
 * 2021.02.19 16:46
 */
@Repository
public interface UserMapper {
    List<UserDto> findAll(Map<Object,Object> params);
    User findOne(User user);
    void add(User user);
    void update(User user);
    User findById(@Param("userId") String userId);
    void deleteById(@Param("userId") String userId);
    Integer batchDeleteById(String[] ids);
    Integer getTotal();
    List<User> findAllByLikeUserName(@Param("userName") String userName);

    /*
     * 根据当前登录的社团管理员查询社团成员信息、招新信息
     */
    List<UserDto> findByCommunityId(@Param("communityId") Integer communityId,@Param("status") Integer status);

    /*
     * 移除社员
     */
    void memberRemoveById(@Param("userId") String userId, @Param("communityId") Integer communityId);

    /*
     * 批准社员加入
     */
    void memberApprovalById(@Param("userId") String userId, @Param("communityId") Integer communityId);


    /*
     *统计某个社团下的人数 【社团招新人数 + 活动报名参加人数 + 参与人数】
     * @param [communityId]
     * @return java.lang.Integer
     */
    Integer memberByStatistics(@Param("communityId") Integer communityId);

    /*
     * 加载所有用户列表 用于下拉框选项
     * @param []
     * @return java.util.List<com.limin.commanser.entity.User>
     */
    List<User> findAllUserForOption();
}
