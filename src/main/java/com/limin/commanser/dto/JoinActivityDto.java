package com.limin.commanser.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 报名参加活动 dto
 * dingwen
 * 2021/3/27 13:00
 **/
@Data
public class JoinActivityDto implements Serializable {
    private static final long serialVersionUID = -4889474907980777899L;
    private Integer activityId;
    private String userId;
    private Integer status;
}
