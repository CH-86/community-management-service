package com.limin.commanser.dto;

import com.limin.commanser.entity.User;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户信息Dto
 *
 * @author Administrator
 * 2021.03.18 00:52
 */
@Data
public class UserDto extends User implements Serializable {
    private static final long serialVersionUID = 7506327664581199292L;
    private Integer clazzId;
    private String clazzName;
    private Integer collegeId;
    private Integer communityId;
    private String communityName;
    private String communityDiscription;
    private String communityLogo;
}
