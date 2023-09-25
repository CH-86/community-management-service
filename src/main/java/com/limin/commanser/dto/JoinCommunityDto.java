package com.limin.commanser.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 报名参加社团 dto
 * dingwen
 * 2021/3/27 13:00
 **/
@Data
public class JoinCommunityDto implements Serializable {
    private static final long serialVersionUID = -4889474907980777899L;
    private Integer communityId;
    private String userId;
    private Integer status;
}
