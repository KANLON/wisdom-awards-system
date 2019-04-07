package org.jeecg.modules.list.national.encouragement.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.list.national.encouragement.entity.NationalEncouragement;
import org.jeecg.modules.list.national.encouragement.service.INationalEncouragementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 *  国家励志奖学金信息
 * 国家励志奖学金信息
 * @author jeecg-boot
 * @since    2019-04-06
 * @version V1.0
 */
@RestController
@RequestMapping("/list.national.encouragement/nationalEncouragement")
@Slf4j
public class NationalEncouragementController {
	@Autowired
	private INationalEncouragementService nationalEncouragementService;
	
	/**
	  * 分页列表查询
	 * @param nationalEncouragement
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<NationalEncouragement>> queryPageList(NationalEncouragement nationalEncouragement,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<NationalEncouragement>> result = new Result<IPage<NationalEncouragement>>();
		QueryWrapper<NationalEncouragement> queryWrapper = new QueryWrapper<NationalEncouragement>(nationalEncouragement);
		Page<NationalEncouragement> page = new Page<NationalEncouragement>(pageNo,pageSize);
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
		IPage<NationalEncouragement> pageList = nationalEncouragementService.page(page, queryWrapper);
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
	 * @param nationalEncouragement
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<NationalEncouragement> add(@RequestBody NationalEncouragement nationalEncouragement) {
		Result<NationalEncouragement> result = new Result<NationalEncouragement>();
		try {
			nationalEncouragementService.save(nationalEncouragement);
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
	 * @param nationalEncouragement
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<NationalEncouragement> eidt(@RequestBody NationalEncouragement nationalEncouragement) {
		Result<NationalEncouragement> result = new Result<NationalEncouragement>();
		NationalEncouragement nationalEncouragementEntity = nationalEncouragementService.getById(nationalEncouragement.getId());
		if(nationalEncouragementEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalEncouragementService.updateById(nationalEncouragement);
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
	public Result<NationalEncouragement> delete(@RequestParam(name="id",required=true) String id) {
		Result<NationalEncouragement> result = new Result<NationalEncouragement>();
		NationalEncouragement nationalEncouragement = nationalEncouragementService.getById(id);
		if(nationalEncouragement==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalEncouragementService.removeById(id);
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
	public Result<NationalEncouragement> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<NationalEncouragement> result = new Result<NationalEncouragement>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.nationalEncouragementService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<NationalEncouragement> queryById(@RequestParam(name="id",required=true) String id) {
		Result<NationalEncouragement> result = new Result<NationalEncouragement>();
		NationalEncouragement nationalEncouragement = nationalEncouragementService.getById(id);
		if(nationalEncouragement==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(nationalEncouragement);
			result.setSuccess(true);
		}
		return result;
	}

}
