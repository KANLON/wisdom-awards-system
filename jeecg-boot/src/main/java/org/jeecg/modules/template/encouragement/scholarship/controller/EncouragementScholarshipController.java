package org.jeecg.modules.template.encouragement.scholarship.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.template.encouragement.scholarship.entity.EncouragementScholarship;
import org.jeecg.modules.template.encouragement.scholarship.service.IEncouragementScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 国家励志奖学金信息
 * @author： jeecg-boot
 * @date：   2019-04-01
 * @version： V1.0
 */
@RestController
@RequestMapping("/encouragement.scholarship/encouragementScholarship")
@Slf4j
public class EncouragementScholarshipController {
	@Autowired
	private IEncouragementScholarshipService encouragementScholarshipService;
	
	/**
	  * 分页列表查询
	 * @param encouragementScholarship
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<EncouragementScholarship>> queryPageList(EncouragementScholarship encouragementScholarship,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<EncouragementScholarship>> result = new Result<IPage<EncouragementScholarship>>();
		QueryWrapper<EncouragementScholarship> queryWrapper = new QueryWrapper<EncouragementScholarship>(encouragementScholarship);
		Page<EncouragementScholarship> page = new Page<EncouragementScholarship>(pageNo,pageSize);
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
		IPage<EncouragementScholarship> pageList = encouragementScholarshipService.page(page, queryWrapper);
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
	 * @param encouragementScholarship
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<EncouragementScholarship> add(@RequestBody EncouragementScholarship encouragementScholarship) {
		Result<EncouragementScholarship> result = new Result<EncouragementScholarship>();
		try {
			encouragementScholarshipService.save(encouragementScholarship);
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
	 * @param encouragementScholarship
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<EncouragementScholarship> eidt(@RequestBody EncouragementScholarship encouragementScholarship) {
		Result<EncouragementScholarship> result = new Result<EncouragementScholarship>();
		EncouragementScholarship encouragementScholarshipEntity = encouragementScholarshipService.getById(encouragementScholarship.getId());
		if(encouragementScholarshipEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = encouragementScholarshipService.updateById(encouragementScholarship);
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
	public Result<EncouragementScholarship> delete(@RequestParam(name="id",required=true) String id) {
		Result<EncouragementScholarship> result = new Result<EncouragementScholarship>();
		EncouragementScholarship encouragementScholarship = encouragementScholarshipService.getById(id);
		if(encouragementScholarship==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = encouragementScholarshipService.removeById(id);
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
	public Result<EncouragementScholarship> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<EncouragementScholarship> result = new Result<EncouragementScholarship>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.encouragementScholarshipService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<EncouragementScholarship> queryById(@RequestParam(name="id",required=true) String id) {
		Result<EncouragementScholarship> result = new Result<EncouragementScholarship>();
		EncouragementScholarship encouragementScholarship = encouragementScholarshipService.getById(id);
		if(encouragementScholarship==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(encouragementScholarship);
			result.setSuccess(true);
		}
		return result;
	}

}
