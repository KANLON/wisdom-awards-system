package org.jeecg.modules.list.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.list.entity.NationalScholarship;
import org.jeecg.modules.list.service.INationalScholarshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 国家奖学金信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@RestController
@RequestMapping("/list.national.scholarship/nationalScholarship")
@Slf4j
public class NationalScholarshipController {
	@Autowired
	private INationalScholarshipService nationalScholarshipService;
	
	/**
	  * 分页列表查询
	 * @param nationalScholarship
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<NationalScholarship>> queryPageList(NationalScholarship nationalScholarship,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<NationalScholarship>> result = new Result<IPage<NationalScholarship>>();
		QueryWrapper<NationalScholarship> queryWrapper = new QueryWrapper<NationalScholarship>(nationalScholarship);
		Page<NationalScholarship> page = new Page<NationalScholarship>(pageNo,pageSize);
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
		IPage<NationalScholarship> pageList = nationalScholarshipService.page(page, queryWrapper);
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
	 * @param nationalScholarship
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<NationalScholarship> add(@RequestBody NationalScholarship nationalScholarship) {
		Result<NationalScholarship> result = new Result<NationalScholarship>();
		try {
			nationalScholarshipService.save(nationalScholarship);
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
	 * @param nationalScholarship
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<NationalScholarship> eidt(@RequestBody NationalScholarship nationalScholarship) {
		Result<NationalScholarship> result = new Result<NationalScholarship>();
		NationalScholarship nationalScholarshipEntity = nationalScholarshipService.getById(nationalScholarship.getId());
		if(nationalScholarshipEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalScholarshipService.updateById(nationalScholarship);
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
	public Result<NationalScholarship> delete(@RequestParam(name="id",required=true) String id) {
		Result<NationalScholarship> result = new Result<NationalScholarship>();
		NationalScholarship nationalScholarship = nationalScholarshipService.getById(id);
		if(nationalScholarship==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalScholarshipService.removeById(id);
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
	public Result<NationalScholarship> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<NationalScholarship> result = new Result<NationalScholarship>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.nationalScholarshipService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<NationalScholarship> queryById(@RequestParam(name="id",required=true) String id) {
		Result<NationalScholarship> result = new Result<NationalScholarship>();
		NationalScholarship nationalScholarship = nationalScholarshipService.getById(id);
		if(nationalScholarship==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(nationalScholarship);
			result.setSuccess(true);
		}
		return result;
	}

}
