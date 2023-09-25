package com.limin.commanser.entity;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 消息 留言
 * dingwen
 * 2021/3/27 20:24
 **/
@Data
public class Message implements Serializable {
    private static final long serialVersionUID = -4986555479527857811L;
    private Integer messageId;
    private String messageContent;
    private String  messageSend;
    private String  messageRecv;
    private Integer  messageStatus;
    private Timestamp messageTime;
}
