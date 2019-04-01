
SELECT REPLACE(UUID(),'-','') FROM demo;


SHOW TABLES;

/*创建自定义的表，国家奖学金信息表*/

DROP TABLE IF EXISTS wisdom_national_scholarship;
CREATE TABLE wisdom_national_scholarship(
  id VARCHAR(32) PRIMARY KEY NOT NULL COMMENT 'uuid',
  base_real_name VARCHAR(20) NOT NULL COMMENT '正式姓名',
  base_sex TINYINT(1) NOT NULL DEFAULT 1 COMMENT '基本情况—性别，0表示女，1表示男',
  base_birth_month CHAR(7) NOT NULL COMMENT '基本情况出生年月',
  base_political VARCHAR(10) NOT NULL DEFAULT '汉' COMMENT '政治面貌',
  base_nation VARCHAR(10) COMMENT '民族',
  base_come_school_day VARCHAR(10) NOT NULL COMMENT '基本情况-入学时间',
  base_major VARCHAR(40) NOT NULL COMMENT '专业',
  base_educational_system TINYINT(1) NOT NULL DEFAULT 4 COMMENT '学制',
  base_phone VARCHAR(20) NOT NULL  COMMENT '联系电话',
  base_id_card_number VARCHAR(18) NOT NULL COMMENT '身份证号',
  stu_mark_rank INT(5) NOT NULL COMMENT '成绩排名',
  stu_total_number INT(5) NOT NULL COMMENT '总人数',
  stu_is_have_evaluation TINYINT(1) NOT NULL DEFAULT 1 COMMENT '学习情况-是否有综合考评，1表示有，0表示没有',
  stu_evaluation_rank INT(5) NOT NULL COMMENT '学习情况-综合考评排名',
  application_reasons VARCHAR(255) NOT NULL COMMENT '申请理由（200字）',
  recommend_reasons VARCHAR(200) NOT NULL COMMENT '推荐理由（100字）',
  department_opinion VARCHAR(200) NOT NULL COMMENT '院（系）意见',
  -- 由于不能同时创建两个default timestamp默认值所以将创建时间的默认值修改为'0000-00-00 00:00:00'
  ctime TIMESTAMP NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建时间',
  mtime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '修改时间',
  dr INT(1) NOT NULL DEFAULT 0 COMMENT '是否有效,标记删除'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='国家奖学金信息表';


/*创建自定义的表，国家励志奖学金信息表*/
DROP TABLE IF EXISTS wisdom_encouragement_scholarship;
CREATE TABLE wisdom_encouragement_scholarship(
  id VARCHAR(32) PRIMARY KEY NOT NULL COMMENT 'uuid',
  base_real_name VARCHAR(20) NOT NULL COMMENT '姓名',
  base_sex TINYINT(1) NOT NULL DEFAULT 1 COMMENT '性别，0表示女，1表示男',
  base_political VARCHAR(10) NOT NULL DEFAULT '团员' COMMENT '政治面貌',
  base_nation VARCHAR(10)  NOT NULL DEFAULT '汉' COMMENT '民族',
  base_come_school_day VARCHAR(10) NOT NULL COMMENT '入学年月',
  base_student_id VARCHAR(10) NOT NULL COMMENT '学号',
  base_class VARCHAR(10) NOT NULL  COMMENT '班级',
  base_phone VARCHAR(20) NOT NULL  COMMENT '联系电话',
  base_id_card_number VARCHAR(18) NOT NULL COMMENT '身份证号',
  base_poor_grade VARCHAR(10) NOT NULL DEFAULT '一般困难' COMMENT '贫困等级',
  stu_total_number INT(5) NOT NULL COMMENT '总人数',
  stu_sum_type VARCHAR(10) NOT NULL DEFAULT '按班级' COMMENT '总人数的统计种类',
  stu_mark_rank INT(5) NOT NULL COMMENT '成绩排名',
  stu_is_have_evaluation TINYINT(1) NOT NULL DEFAULT 1 COMMENT '学习情况-是否有综合考评，1表示有，0表示没有',
  stu_evaluation_rank INT(5) NOT NULL COMMENT '学习情况-综合考评排名',
  application_reasons VARCHAR(255) NOT NULL COMMENT '申请理由（150字）',
  -- 由于不能同时创建两个default timestamp默认值所以将创建时间的默认值修改为'1991-01-01 00:00:00'
  ctime TIMESTAMP NOT NULL DEFAULT '1991-01-01 00:00:00' COMMENT '创建时间',
  mtime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '修改时间',
  dr INT(1) NOT NULL DEFAULT 0 COMMENT '是否有效,标记删除'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='励志奖学金信息表';


/*创建自定义的表，国家助学金信息表，还要修改*/
DROP TABLE IF EXISTS wisdom_encouragement_scholarship;
CREATE TABLE wisdom_encouragement_scholarship(
  id VARCHAR(32) PRIMARY KEY NOT NULL COMMENT 'uuid',
  base_real_name VARCHAR(20) NOT NULL COMMENT '姓名',
  base_sex TINYINT(1) NOT NULL DEFAULT 1 COMMENT '性别，0表示女，1表示男',
  base_political VARCHAR(10) NOT NULL DEFAULT '团员' COMMENT '政治面貌',
  base_nation VARCHAR(10)  NOT NULL DEFAULT '汉' COMMENT '民族',
  base_come_school_day VARCHAR(10) NOT NULL COMMENT '入学年月',
  base_student_id VARCHAR(10) NOT NULL COMMENT '学号',
  base_class VARCHAR(10) NOT NULL  COMMENT '班级',
  base_phone VARCHAR(20) NOT NULL  COMMENT '联系电话',
  base_id_card_number VARCHAR(18) NOT NULL COMMENT '身份证号',
  base_poor_grade VARCHAR(10) NOT NULL DEFAULT '一般困难' COMMENT '贫困等级',
  stu_total_number INT(5) NOT NULL COMMENT '总人数',
  stu_sum_type VARCHAR(10) NOT NULL DEFAULT '按班级' COMMENT '总人数的统计种类',
  stu_mark_rank INT(5) NOT NULL COMMENT '成绩排名',
  stu_is_have_evaluation TINYINT(1) NOT NULL DEFAULT 1 COMMENT '学习情况-是否有综合考评，1表示有，0表示没有',
  stu_evaluation_rank INT(5) NOT NULL COMMENT '学习情况-综合考评排名',
  application_reasons VARCHAR(255) NOT NULL COMMENT '申请理由（150字）',
  -- 由于不能同时创建两个default timestamp默认值所以将创建时间的默认值修改为'1991-01-01 00:00:00'
  ctime TIMESTAMP NOT NULL DEFAULT '1991-01-01 00:00:00' COMMENT '创建时间',
  mtime TIMESTAMP NOT NULL DEFAULT NOW() COMMENT '修改时间',
  dr INT(1) NOT NULL DEFAULT 0 COMMENT '是否有效,标记删除'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='励志奖学金信息表';

















