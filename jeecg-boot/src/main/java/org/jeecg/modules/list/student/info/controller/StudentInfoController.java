package org.jeecg.modules.list.student.info.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.list.student.info.entity.StudentInfo;
import org.jeecg.modules.list.student.info.service.IStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

 /**
 * @Title: Controller
 * @Description: 学生基本信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@RestController
@RequestMapping("/list.student.info/studentInfo")
@Slf4j
public class StudentInfoController {
	@Autowired
	private IStudentInfoService studentInfoService;
	
	/**
	  * 分页列表查询
	 * @param studentInfo
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@GetMapping(value = "/list")
	public Result<IPage<StudentInfo>> queryPageList(StudentInfo studentInfo,
									  @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
									  @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
									  HttpServletRequest req) {
		Result<IPage<StudentInfo>> result = new Result<IPage<StudentInfo>>();
		QueryWrapper<StudentInfo> queryWrapper = new QueryWrapper<StudentInfo>(studentInfo);
		Page<StudentInfo> page = new Page<StudentInfo>(pageNo,pageSize);
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
		IPage<StudentInfo> pageList = studentInfoService.page(page, queryWrapper);
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
	 * @param studentInfo
	 * @return
	 */
	@PostMapping(value = "/add")
	public Result<StudentInfo> add(@RequestBody StudentInfo studentInfo) {
		Result<StudentInfo> result = new Result<StudentInfo>();
		try {
			studentInfoService.save(studentInfo);
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
	 * @param studentInfo
	 * @return
	 */
	@PutMapping(value = "/edit")
	public Result<StudentInfo> eidt(@RequestBody StudentInfo studentInfo) {
		Result<StudentInfo> result = new Result<StudentInfo>();
		StudentInfo studentInfoEntity = studentInfoService.getById(studentInfo.getId());
		if(studentInfoEntity==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = studentInfoService.updateById(studentInfo);
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
	public Result<StudentInfo> delete(@RequestParam(name="id",required=true) String id) {
		Result<StudentInfo> result = new Result<StudentInfo>();
		StudentInfo studentInfo = studentInfoService.getById(id);
		if(studentInfo==null) {
			result.error500("未找到对应实体");
		}else {
			boolean ok = studentInfoService.removeById(id);
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
	public Result<StudentInfo> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		Result<StudentInfo> result = new Result<StudentInfo>();
		if(ids==null || "".equals(ids.trim())) {
			result.error500("参数不识别！");
		}else {
			this.studentInfoService.removeByIds(Arrays.asList(ids.split(",")));
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
	public Result<StudentInfo> queryById(@RequestParam(name="id",required=true) String id) {
		Result<StudentInfo> result = new Result<StudentInfo>();
		StudentInfo studentInfo = studentInfoService.getById(id);
		if(studentInfo==null) {
			result.error500("未找到对应实体");
		}else {
			result.setResult(studentInfo);
			result.setSuccess(true);
		}
		return result;
	}

}
