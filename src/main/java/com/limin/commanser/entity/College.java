package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author Administrator
 * 2021.03.07 10:42
 */
@Data
public class College implements Serializable {
    private static final long serialVersionUID = -7940021389637519015L;
    private Integer collegeId;
    private String collegeName;
}
