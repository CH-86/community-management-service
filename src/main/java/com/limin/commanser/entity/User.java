package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 *
 * @author Administrator
 * 2021.02.19 16:46
 */
@Data
// lombok 自动生成 所有属性的get和set方法、toString 方法、hashCode方法、equals方法
public class User implements Serializable {
    private static final long serialVersionUID = 5607850160681596580L;
    private String userId;
    private String userName;
    private String userPassword;
    private Integer userClazzId;
    private String userDepartment;
    private String userImage;
    private String userQq;
    private String userTelephone;
    private Integer userGender;
    private Integer userType;
    private Integer userCommunityId;


}
