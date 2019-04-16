package org.jeecg.modules.list.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 国奖管理
 * @author： jeecg-boot
 * @date：   2019-04-16
 * @version： V1.0
 */
@Data
@TableName("wisdom_national_scholarship")
public class NationalScholarship implements Serializable {
    private static final long serialVersionUID = 1L;
    
	/**uuid*/
	@TableId(type = IdType.UUID)
	private String id;
	/**正式姓名*/
	private String baseRealName;
	/**学号*/
	private String baseStudentId;
	/**性别，0表示女，1表示男*/
	private Integer baseSex;
	/**出生年月*/
	private String baseBirthMonth;
	/**政治面貌*/
	private String basePolitical;
	/**民族*/
	private String baseNation;
	/**入学时间*/
	private String baseComeSchoolDay;
	/**专业*/
	private String baseMajor;
	/**学制*/
	private Integer baseEducationalSystem;
	/**联系电话*/
	private String basePhone;
	/**身份证号*/
	private String baseIdCardNumber;
	/**成绩排名*/
	private Integer stuMarkRank;
	/**总人数*/
	private Integer stuTotalNumber;
	/**是否有综合考评，1表示有，0表示没有*/
	private Integer stuIsHaveEvaluation;
	/**综合考评排名*/
	private Integer stuEvaluationRank;
	/**申请理由（200字）*/
	private String applicationReasons;
	/**推荐理由（100字）*/
	private String recommendReasons;
	/**院（系）意见*/
	private String departmentOpinion;
	/**备注*/
	private String remark;
	/**状态*/
	private Integer statu;
	/**创建时间*/
	private Date ctime;
	/**修改时间*/
	private Date mtime;
	/**是否有效,标记删除*/
	private Integer dr;
}
