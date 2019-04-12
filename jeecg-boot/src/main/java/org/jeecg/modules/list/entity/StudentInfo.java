package org.jeecg.modules.list.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 学生基本信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Data
@TableName("wisdom_student_info")
public class StudentInfo implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**uuid*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**姓名*/
	private java.lang.String baseRealName;
	/**学号*/
	private java.lang.String baseStudentId;
	/**身份证号*/
	private java.lang.String baseIdCardNumber;
	/**性别，0表示女，1表示男*/
	private java.lang.Integer baseSex;
	/**政治面貌*/
	private java.lang.String basePolitical;
	/**民族*/
	private java.lang.String baseNation;
	/**入学年月*/
	private java.lang.String baseComeSchoolDay;
	/**班级*/
	private java.lang.String baseClass;
	/**联系电话*/
	private java.lang.String basePhone;
	/**贫困等级*/
	private java.lang.String basePoorGrade;
	/**户口类型*/
	private java.lang.String baseResidence;
	/**家庭住址*/
	private java.lang.String baseAddress;
	/**宿舍地址*/
	private java.lang.String baseDormitory;
	/**专业*/
	private java.lang.String baseMajor;
	/**学院*/
	private java.lang.String baseDepartment;
	/**学校*/
	private java.lang.String baseSchool;
	/**出生日期*/
	private java.lang.String birthday;
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
