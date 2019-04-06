package org.jeecg.modules.list.student.info.service.impl;

import org.jeecg.modules.list.student.info.entity.StudentInfo;
import org.jeecg.modules.list.student.info.mapper.StudentInfoMapper;
import org.jeecg.modules.list.student.info.service.IStudentInfoService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 学生基本信息
 * @author： jeecg-boot
 * @date：   2019-04-06
 * @version： V1.0
 */
@Service
public class StudentInfoServiceImpl extends ServiceImpl<StudentInfoMapper, StudentInfo> implements IStudentInfoService {

}
