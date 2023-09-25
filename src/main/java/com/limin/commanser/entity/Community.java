package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author Administrator
 * 2021.03.07 10:40
 */
@Data
public class Community implements Serializable {
    private static final long serialVersionUID = -1552277113104702202L;
    private Integer communityId;
    private String communityName;
    private String communityDiscription;
    private String communityLogo;
    private Integer communityStatus;

}
