package org.jeecg.modules.list.national.scholarship.entity;

import java.io.Serializable;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Description: 国家奖学金信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Data
@TableName("wisdom_national_scholarship")
public class NationalScholarship implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**uuid*/
	@TableId(type = IdType.UUID)
	private java.lang.String id;
	/**正式姓名*/
	private java.lang.String baseRealName;
	/**性别，0表示女，1表示男*/
	private java.lang.Integer baseSex;
	/**出生年月*/
	private java.lang.String baseBirthMonth;
	/**政治面貌*/
	private java.lang.String basePolitical;
	/**民族*/
	private java.lang.String baseNation;
	/**入学时间*/
	private java.lang.String baseComeSchoolDay;
	/**专业*/
	private java.lang.String baseMajor;
	/**学制*/
	private java.lang.Integer baseEducationalSystem;
	/**联系电话*/
	private java.lang.String basePhone;
	/**身份证号*/
	private java.lang.String baseIdCardNumber;
	/**成绩排名*/
	private java.lang.Integer stuMarkRank;
	/**总人数*/
	private java.lang.Integer stuTotalNumber;
	/**是否有综合考评，1表示有，0表示没有*/
	private java.lang.Integer stuIsHaveEvaluation;
	/**综合考评排名*/
	private java.lang.Integer stuEvaluationRank;
	/**申请理由（200字）*/
	private java.lang.String applicationReasons;
	/**推荐理由（100字）*/
	private java.lang.String recommendReasons;
	/**院（系）意见*/
	private java.lang.String departmentOpinion;
	/**创建时间*/
	private java.util.Date ctime;
	/**修改时间*/
	private java.util.Date mtime;
	/**是否有效,标记删除*/
	private java.lang.Integer dr;
}
