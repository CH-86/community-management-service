package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 班级实体
 *
 * @author Administrator
 * 2021.03.06 21:17
 */
@Data
public class Clazz implements Serializable {
    private static final long serialVersionUID = 997879315411459626L;
    private Integer clazzId;
    private String clazzName;
    private Integer collegeId;
}
