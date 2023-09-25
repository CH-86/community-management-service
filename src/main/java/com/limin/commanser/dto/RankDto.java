package com.limin.commanser.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * dingwen
 * 2021/3/30 0:29
 **/
@Data
public class RankDto implements Serializable {
    public RankDto(String name, Integer score,Integer rankId) {
        this.rankId = rankId;
        this.name = name;
        this.score = score;
    }

    private static final long serialVersionUID = -6830755793745527364L;
    private String name;
    private Integer score;
    private Integer rankId;
}
