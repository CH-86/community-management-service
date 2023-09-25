package com.limin.commanser.dto;

import com.limin.commanser.entity.News;
import lombok.Data;

import java.io.Serializable;

/**
 * 新闻信息Dto
 *
 * @author Administrator
 * 2021.03.18 02:02
 */
@Data
public class NewsDto extends News implements Serializable {
    private static final long serialVersionUID = -1827277691244934290L;
    private Integer communityId;
    private String communityName;
    private String communityDiscription;
    private String communityLogo;
}
