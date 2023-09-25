package com.limin.commanser.dto;

import com.limin.commanser.entity.User;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * dingwen
 * 2021/3/27 22:10
 **/
@Data
public class MessageDto  implements Serializable {
    private static final long serialVersionUID = 994484154335742643L;
    private Integer messageId;
    private String messageContent;
    private String  messageSend;
    private String  messageSendName;
    private String  messageRecv;
    private String  messageRecvName;
    private Integer  messageStatus;
    private Timestamp messageTime;
}
