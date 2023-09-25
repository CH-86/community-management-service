package com.limin.commanser.service.impl;

import com.limin.commanser.dto.MessageDto;
import com.limin.commanser.entity.Message;
import com.limin.commanser.mapper.MessageMapper;
import com.limin.commanser.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * dingwen
 * 2021/3/27 21:35
 **/
@Service
public class MessageServiceImpl implements MessageService {
    private final MessageMapper messageMapper;

    @Autowired
    MessageServiceImpl(MessageMapper messageMapper) {
        this.messageMapper = messageMapper;
    }

    @Override
    public List<MessageDto> findMessage(String messageRecv) {
        return messageMapper.findMessage(messageRecv);
    }

    @Override
    public void modifyMessage(Integer messageId) {
        messageMapper.modifyMessage(messageId);
    }

    @Override
    public void addMessage(Message message) {
        messageMapper.addMessage(message);
    }
}
