package com.limin.commanser.service;

import com.limin.commanser.dto.MessageDto;
import com.limin.commanser.entity.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息接口
 * dingwen
 * 2021/3/27 21:34
 **/
public interface MessageService {
    /*
     *查看当前用户的留言信息
     * 未读状态
     * @param [messageRecv]
     * @return com.limin.commanser.entity.Message
     */
    List<MessageDto> findMessage(@Param("messageRecv")String messageRecv);


    /*
     *修改留言状态
     * @param [messageId]
     * @return void
     */
    void modifyMessage(@Param("messageId") Integer messageId);


    /*
     *新增留言
     * @param [message]
     * @return void
     */
    void addMessage(Message message);
}
