package com.limin.commanser.dto;

import com.limin.commanser.entity.Activity;
import lombok.Data;

import java.io.Serializable;

/**
 * 活动 Dto
 *
 * @author Administrator
 * 2021.03.18 15:50
 */
@Data
public class ActivityDto extends Activity implements Serializable {
    private static final long serialVersionUID = -8446323327252634930L;
    private Integer communityId;
    private String communityName;
    private String communityDiscription;
    private String communityLogo;
    private Integer communityStatus;
}
