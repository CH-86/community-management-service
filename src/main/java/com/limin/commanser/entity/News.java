package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 新闻实体
 *
 * @author Administrator
 * 2021.03.18 01:57
 */
@Data
public class News implements Serializable {

    private static final long serialVersionUID = -2836833231147377761L;
    private Integer newsId;
    private String newsTitle;
    private String newsImage;
    private String newsContent;
    private Integer newsType;
    private Timestamp newsCreateTime;
    private Integer newsCommunityId;
    private Integer newsStatus;
}
