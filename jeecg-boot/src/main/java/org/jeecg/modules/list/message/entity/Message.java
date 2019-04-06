package org.jeecg.modules.list.message.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 消息管理
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Data
@TableName("wisdom_message")
public class Message implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**uuid*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**消息标题*/
	private java.lang.String title;
	/**消息内容*/
	private java.lang.String content;
	/**附件地址*/
	private java.lang.String attachment;
	/**备注*/
	private java.lang.String remark;
	/**状态*/
	private java.lang.Integer statu;
	/**创建时间*/
	private java.util.Date ctime;
	/**修改时间*/
	private java.util.Date mtime;
	/**是否有效,标记删除*/
	private java.lang.Integer dr;
}
