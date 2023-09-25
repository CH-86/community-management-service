package com.limin.commanser.dto;

import com.limin.commanser.entity.Community;
import lombok.Data;

import java.io.Serializable;

/**
 * 社团DTO
 * dingwen
 * 2021/3/21 17:02
 **/
@Data
public class CommunityDto extends Community implements Serializable {
    private static final long serialVersionUID = 4742857394267696276L;
    private String userName;
    private String userTelephone;
}
