<template>
  <a-card :body-style="{padding: '24px 32px'}" :bordered="false">
    <a-form @submit="handleSubmit" :form="form">
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="正式姓名">
        <a-input placeholder="请输入正式姓名" v-decorator="['baseRealName', validatorRules.baseRealName ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="学号">
        <a-input placeholder="请输入学号" v-decorator="['baseStudentId', validatorRules.baseStudentId ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="性别，0表示女，1表示男">
        <a-input placeholder="请输入性别，0表示女，1表示男" v-decorator="['baseSex', validatorRules.baseSex ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="出生年月">
        <a-input placeholder="请输入出生年月" v-decorator="['baseBirthMonth', validatorRules.baseBirthMonth ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="政治面貌">
        <a-input placeholder="请输入政治面貌" v-decorator="['basePolitical', validatorRules.basePolitical ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="民族">
        <a-input placeholder="请输入民族" v-decorator="['baseNation', {}]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="入学时间">
        <a-input placeholder="请输入入学时间" v-decorator="['baseComeSchoolDay', validatorRules.baseComeSchoolDay ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="专业">
        <a-input placeholder="请输入专业" v-decorator="['baseMajor', validatorRules.baseMajor ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="学制">
        <a-input placeholder="请输入学制" v-decorator="['baseEducationalSystem', validatorRules.baseEducationalSystem ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="联系电话">
        <a-input placeholder="请输入联系电话" v-decorator="['basePhone', validatorRules.basePhone ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="身份证号">
        <a-input placeholder="请输入身份证号" v-decorator="['baseIdCardNumber', validatorRules.baseIdCardNumber ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="成绩排名">
        <a-input-number v-decorator="[ 'stuMarkRank', validatorRules.stuMarkRank ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="总人数">
        <a-input-number v-decorator="[ 'stuTotalNumber', validatorRules.stuTotalNumber ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="是否有综合考评，1表示有，0表示没有">
        <a-input
          placeholder="请输入是否有综合考评，1表示有，0表示没有"
          v-decorator="['stuIsHaveEvaluation', validatorRules.stuIsHaveEvaluation ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="综合考评排名">
        <a-input-number v-decorator="[ 'stuEvaluationRank', validatorRules.stuEvaluationRank ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="申请理由（200字）">
        <a-input
          placeholder="请输入申请理由（200字）"
          v-decorator="['applicationReasons', validatorRules.applicationReasons ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="推荐理由（100字）">
        <a-input placeholder="请输入推荐理由（100字）" v-decorator="['recommendReasons', validatorRules.recommendReasons ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="院（系）意见">
        <a-input placeholder="请输入院（系）意见" v-decorator="['departmentOpinion', validatorRules.departmentOpinion ]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="备注">
        <a-input placeholder="请输入备注" v-decorator="['remark', {}]"/>
      </a-form-item>
      <a-form-item
        :labelCol="labelCol"
        :wrapperCol="wrapperCol"
        label="状态">
        <a-input placeholder="请输入状态" v-decorator="['statu', validatorRules.statu ]"/>
      </a-form-item>
      <a-form-item
        :wrapperCol="{ span: 24 }"
        style="text-align: center"
      >
        <a-button htmlType="submit" type="primary">提交</a-button>
        <a-button style="margin-left: 8px">保存</a-button>
      </a-form-item>

    </a-form>
  </a-card>
</template>

<script>
  import {httpAction} from '@/api/manage'
  import pick from 'lodash.pick'

  export default {
    name: 'BaseForm',
    data() {
      return {
        description: '国家奖学金申请提交页',
        value: 1,
        model: {},
        // form
        form: this.$form.createForm(this),
        validatorRules: {
          baseRealName: { rules: [{ required: true, message: '请输入正式姓名!' }] },
          baseStudentId: { rules: [{ required: true, message: '请输入学号!' }] },
          baseSex: { rules: [{ required: true, message: '请输入性别，0表示女，1表示男!' }] },
          baseBirthMonth: { rules: [{ required: true, message: '请输入出生年月!' }] },
          basePolitical: { rules: [{ required: true, message: '请输入政治面貌!' }] },
          baseComeSchoolDay: { rules: [{ required: true, message: '请输入入学时间!' }] },
          baseMajor: { rules: [{ required: true, message: '请输入专业!' }] },
          baseEducationalSystem: { rules: [{ required: true, message: '请输入学制!' }] },
          basePhone: { rules: [{ required: true, message: '请输入联系电话!' }] },
          baseIdCardNumber: { rules: [{ required: true, message: '请输入身份证号!' }] },
          stuMarkRank: { rules: [{ required: true, message: '请输入成绩排名!' }] },
          stuTotalNumber: { rules: [{ required: true, message: '请输入总人数!' }] },
          stuIsHaveEvaluation: { rules: [{ required: true, message: '请输入是否有综合考评，1表示有，0表示没有!' }] },
          stuEvaluationRank: { rules: [{ required: true, message: '请输入综合考评排名!' }] },
          applicationReasons: { rules: [{ required: true, message: '请输入申请理由（200字）!' }] },
          recommendReasons: { rules: [{ required: true, message: '请输入推荐理由（100字）!' }] },
          departmentOpinion: { rules: [{ required: true, message: '请输入院（系）意见!' }] },
          statu: { rules: [{ required: true, message: '请输入状态!' }] }
        },
        url: {
          add: '/list.national.scholarship/nationalScholarship/add',
          edit: '/list.national.scholarship/nationalScholarship/edit'
        }
      }
    },
    methods: {
      add() {
        this.edit({})
      },
      edit(record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'baseRealName', 'baseStudentId', 'baseSex', 'baseBirthMonth', 'basePolitical', 'baseNation', 'baseComeSchoolDay', 'baseMajor', 'baseEducationalSystem', 'basePhone', 'baseIdCardNumber', 'stuMarkRank', 'stuTotalNumber', 'stuIsHaveEvaluation', 'stuEvaluationRank', 'applicationReasons', 'recommendReasons', 'departmentOpinion', 'remark', 'statu'))
          //时间格式化
        })
      },

      // handler
      handleSubmit(e) {
        e.preventDefault();
        this.form.validateFields((err, values) => {
          if (!err) {
            // eslint-disable-next-line no-console
            this.add();
            console.log('Received values of form: ', values);
            let httpurl = '';
            let method = '';
            if (!this.model.id) {
              httpurl += this.url.add;
              method = 'post'
            } else {
              httpurl += this.url.edit;
              method = 'put'
            }
            let formData = Object.assign(this.model, values);
            //时间格式化
            console.log(formData);
            httpAction(httpurl, formData, method).then((res) => {
              if (res.success) {
                this.$message.success(res.message);
                this.$emit('ok');
              } else {
                this.$message.warning(res.message);
              }
            })
          }
        })
      }
    }
  }
</script>


