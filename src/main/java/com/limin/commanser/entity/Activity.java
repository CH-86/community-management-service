package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 活动实体
 *
 * @author Administrator
 * 2021.03.18 15:41
 */
@Data
public class Activity implements Serializable {
    private static final long serialVersionUID = -7059034866612522941L;
    private Integer activityId;
    private Integer activityCommunityId;
    private String activityName;
    private Integer activityType;
    private Timestamp activityStartTime;
    private Timestamp activityEndTime;
    private String activityImage;
    private String activityAddress;
    private String activitySponser;
    private String activityDescription;
    private Integer activityStatus;

}
