package org.jeecg.modules.list.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.list.entity.NationalGrants;
import org.jeecg.modules.list.service.INationalGrantsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 国家助学金信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@RestController
@RequestMapping("/list.national.grants/nationalGrants")
@Slf4j
public class NationalGrantsController {
	@Autowired
	private INationalGrantsService nationalGrantsService;
	
	/**
	  * 分页列表查询
	 * @param nationalGrants
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<NationalGrants>> queryPageList(NationalGrants nationalGrants,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<NationalGrants>> result = new Result<IPage<NationalGrants>>();
		QueryWrapper<NationalGrants> queryWrapper = new QueryWrapper<NationalGrants>(nationalGrants);
		Page<NationalGrants> page = new Page<NationalGrants>(pageNo,pageSize);
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
		IPage<NationalGrants> pageList = nationalGrantsService.page(page, queryWrapper);
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
	 * @param nationalGrants
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<NationalGrants> add(@RequestBody NationalGrants nationalGrants) {
		Result<NationalGrants> result = new Result<NationalGrants>();
		try {
			nationalGrantsService.save(nationalGrants);
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
	 * @param nationalGrants
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<NationalGrants> eidt(@RequestBody NationalGrants nationalGrants) {
		Result<NationalGrants> result = new Result<NationalGrants>();
		NationalGrants nationalGrantsEntity = nationalGrantsService.getById(nationalGrants.getId());
		if(nationalGrantsEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalGrantsService.updateById(nationalGrants);
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
	public Result<NationalGrants> delete(@RequestParam(name="id",required=true) String id) {
		Result<NationalGrants> result = new Result<NationalGrants>();
		NationalGrants nationalGrants = nationalGrantsService.getById(id);
		if(nationalGrants==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = nationalGrantsService.removeById(id);
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
	public Result<NationalGrants> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<NationalGrants> result = new Result<NationalGrants>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.nationalGrantsService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<NationalGrants> queryById(@RequestParam(name="id",required=true) String id) {
		Result<NationalGrants> result = new Result<NationalGrants>();
		NationalGrants nationalGrants = nationalGrantsService.getById(id);
		if(nationalGrants==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(nationalGrants);
			result.setSuccess(true);
		}
		return result;
	}

}
