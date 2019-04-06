package org.jeecg.modules.list.national.grants.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 国家助学金信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Data
@TableName("wisdom_national_grants")
public class NationalGrants implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**uuid*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**姓名*/
	private java.lang.String baseRealName;
	/**性别，0表示女，1表示男*/
	private java.lang.Integer baseSex;
	/**政治面貌*/
	private java.lang.String basePolitical;
	/**民族*/
	private java.lang.String baseNation;
	/**入学年月*/
	private java.lang.String baseComeSchoolDay;
	/**学号*/
	private java.lang.String baseStudentId;
	/**班级*/
	private java.lang.String baseClass;
	/**联系电话*/
	private java.lang.String basePhone;
	/**身份证号*/
	private java.lang.String baseIdCardNumber;
	/**贫困等级*/
	private java.lang.String basePoorGrade;
	/**学年*/
	private java.lang.String studyYear;
	/**学期*/
	private java.lang.String studyTeam;
	/**出生日期*/
	private java.lang.String birthday;
	/**困难等级*/
	private java.lang.String poorLevel;
	/**应发金额*/
	private java.lang.Integer amountPayable;
	/**发放日期*/
	private java.lang.String payDate;
	/**申请理由（150字）*/
	private java.lang.String applicationReasons;
	/**创建时间*/
	private java.util.Date ctime;
	/**修改时间*/
	private java.util.Date mtime;
	/**是否有效,标记删除*/
	private java.lang.Integer dr;
}
