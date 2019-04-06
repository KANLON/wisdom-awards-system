package org.jeecg.modules.list.message.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.list.message.entity.Message;
import org.jeecg.modules.list.message.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 消息管理
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@RestController
@RequestMapping("/list.message/message")
@Slf4j
public class MessageController {
	@Autowired
	private IMessageService messageService;
	
	/**
	  * 分页列表查询
	 * @param message
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<Message>> queryPageList(Message message,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<Message>> result = new Result<IPage<Message>>();
		QueryWrapper<Message> queryWrapper = new QueryWrapper<Message>(message);
		Page<Message> page = new Page<Message>(pageNo,pageSize);
		//排序逻辑 处理
		String column = req.getParameter("column");
		String order = req.getParameter("order");
		if(oConvertUtils.isNotEmpty(column) && oConvertUtils.isNotEmpty(order)) {
			if("asc".equals(order)) {
				queryWrapper.orderByAsc(oConvertUtils.camelToUnderline(column));
			}else {
				queryWrapper.orderByDesc(oConvertUtils.camelToUnderline(column));
			}
		}
		IPage<Message> pageList = messageService.page(page, queryWrapper);
		//log.debug("查询当前页："+pageList.getCurrent());
		//log.debug("查询当前页数量："+pageList.getSize());
		//log.debug("查询结果数量："+pageList.getRecords().size());
		//log.debug("数据总数："+pageList.getTotal());
		result.setSuccess(true);
		result.setResult(pageList);
		return result;
	}
	
	/**
	  *   添加
	 * @param message
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<Message> add(@RequestBody Message message) {
		Result<Message> result = new Result<Message>();
		try {
			messageService.save(message);
			result.success("添加成功！");
		} catch (Exception e) {
			e.printStackTrace();
			log.info(e.getMessage());
			result.error500("操作失败");
		}
		return result;
	}
	
	/**
	  *  编辑
	 * @param message
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<Message> eidt(@RequestBody Message message) {
		Result<Message> result = new Result<Message>();
		Message messageEntity = messageService.getById(message.getId());
		if(messageEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = messageService.updateById(message);
			//TODO 返回false说明什么？
			if(ok) {
				result.success("修改成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *   通过id删除
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/delete")
	public Result<Message> delete(@RequestParam(name="id",required=true) String id) {
		Result<Message> result = new Result<Message>();
		Message message = messageService.getById(id);
		if(message==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = messageService.removeById(id);
			if(ok) {
				result.success("删除成功!");
			}
		}
		
		return result;
	}
	
	/**
	  *  批量删除
	 * @param ids
	 * @return
	 */
	@DeleteMapping(value = "/deleteBatch")
	public Result<Message> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<Message> result = new Result<Message>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.messageService.removeByIds(Arrays.asList(ids.split(",")));
			result.success("删除成功!");
		}
		return result;
	}
	
	/**
	  * 通过id查询
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/queryById")
	public Result<Message> queryById(@RequestParam(name="id",required=true) String id) {
		Result<Message> result = new Result<Message>();
		Message message = messageService.getById(id);
		if(message==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(message);
			result.setSuccess(true);
		}
		return result;
	}

}
