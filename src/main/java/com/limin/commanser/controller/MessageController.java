package com.limin.commanser.controller;

import com.limin.commanser.dto.MessageDto;
import com.limin.commanser.entity.Message;
import com.limin.commanser.result.Result;
import com.limin.commanser.result.ResultGenerator;
import com.limin.commanser.service.MessageService;
import com.limin.commanser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 留言控制器
 * dingwen
 * 2021/3/27 21:38
 **/
@RestController
public class MessageController {
    private final MessageService messageService;
    private final UserService userService;
    @Autowired
    MessageController(MessageService messageService,UserService userService){
        this.messageService = messageService;
        this.userService = userService;
    }

    /*
     *查询当前用户的留言
     * @param [messageRecv]
     * @return com.limin.commanser.result.Result
     */
    @GetMapping("message/{messageRecv}")
    public Result findMessage(@PathVariable("messageRecv") String messageRecv){
        List<MessageDto> messageDtoList = messageService.findMessage(messageRecv);
        messageDtoList.stream().sequential().forEach(messageDto -> {
           String messageRecvName =  userService.findById(messageDto.getMessageRecv()).getUserName();
           String messageSendName = userService.findById(messageDto.getMessageSend()).getUserName();
           messageDto.setMessageRecvName(messageRecvName);
           messageDto.setMessageSendName(messageSendName);
        });
        return ResultGenerator.genOkResult(messageDtoList);

    }

    /*
     *新发起留言
     * @param [message]
     * @return com.limin.commanser.result.Result
     */
    @PostMapping("/message")
    public Result newMessage(@RequestBody Message message){
        messageService.addMessage(message);
        return ResultGenerator.genOkResult("ok");
    }

    /*
     *留言回复
     * @param [message]
     * @return com.limin.commanser.result.Result
     */
    @PostMapping("/message/reply")
        public Result replyMessage(@RequestBody Message message){
        // 更新已有留言的状态
        Integer oldMessageId = message.getMessageId();
        messageService.modifyMessage(oldMessageId);
        // 添加新留言
        messageService.addMessage(message);
        return ResultGenerator.genOkResult("ok");
    }
}
