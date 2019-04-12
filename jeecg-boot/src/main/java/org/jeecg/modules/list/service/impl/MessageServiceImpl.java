package org.jeecg.modules.list.service.impl;

import org.jeecg.modules.list.entity.Message;
import org.jeecg.modules.list.mapper.MessageMapper;
import org.jeecg.modules.list.service.IMessageService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 消息管理
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {

}
