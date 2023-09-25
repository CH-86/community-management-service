package com.limin.commanser.dto;

import com.limin.commanser.entity.Clazz;
import lombok.Data;

import java.io.Serializable;

/**
 *
 *
 * @author Administrator
 * 2021.03.14 10:49
 */
@Data
public class ClazzDto extends Clazz implements Serializable {
    private static final long serialVersionUID = -2657499714704590227L;
    private String collegeName;
}
