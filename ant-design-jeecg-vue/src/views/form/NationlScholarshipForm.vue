<template>
  <a-card :body-style="{padding: '24px 32px'}" :bordered="false">
    <a-form @submit="handleSubmit" :form="form">
      <a-form-item
        label="姓名"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseRealName',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseRealName"
          placeholder="请输入姓名" />
      </a-form-item>
      <a-form-item
        label="学号"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseStudentId',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseStudentId"
          placeholder="请输入学号" />
      </a-form-item>
      <a-form-item
        label="性别"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseSex',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseSex"
          placeholder="请输入性别" />
      </a-form-item>
      <a-form-item
        label="出生年月"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseBirthMonth',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseBirthMonth"
          placeholder="请输入出生年月" />
      </a-form-item>
      <a-form-item
        label="政治面貌"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'basePolitical',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="basePolitical"
          placeholder="请输入政治面貌" />
      </a-form-item>
      <a-form-item
        label="民族"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseNation',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseNation"
          placeholder="请输入民族" />
      </a-form-item>
      <a-form-item
        label="入学时间"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseComeSchoolDay',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseComeSchoolDay"
          placeholder="请输入入学时间" />
      </a-form-item>
      <a-form-item
        label="专业"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseMajor',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseMajor"
          placeholder="请输入专业" />
      </a-form-item>
      <a-form-item
        label="学制"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseEducationalSystem',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseEducationalSystem"
          placeholder="请输入学制"/>

      </a-form-item>
      <a-form-item
        label="联系电话"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'basePhone',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="basePhone"
          placeholder="请输入联系电话" />
      </a-form-item>
      <a-form-item
        label="身份证号"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'baseIdCardNumber',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="baseIdCardNumber"
          placeholder="请输入身份证号" />
      </a-form-item>
      <a-form-item
        label="成绩排名"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'stuMarkRank',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="stuMarkRank"
          placeholder="请输入成绩排名" />
      </a-form-item>
      <a-form-item
        label="总人数"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'stuTotalNumber',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="stuTotalNumber"
          placeholder="请输入总人数" />
      </a-form-item>
      <a-form-item
        label="是否有综合考评"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'stuIsHaveEvaluation',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="stuIsHaveEvaluation"
          placeholder="请输入是否有综合考评" />
      </a-form-item>

      <a-form-item
        label="综合考评排名"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'stuEvaluationRank',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="stuEvaluationRank"
          placeholder="请输入综合考评排名" />
      </a-form-item>
      <a-form-item
        label="申请理由"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'applicationReasons',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="applicationReasons"
          placeholder="请输入申请理由（200字）" />
      </a-form-item>
      <a-form-item
        label="推荐理由"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'recommendReasons',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="recommendReasons"
          placeholder="请输入推荐理由（100字）" />
      </a-form-item>
      <a-form-item
        label="院系意见"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'departmentOpinion',
            {rules: [{ required: true, message: '请输入对应内容' }]}
          ]"
          name="departmentOpinion"
          placeholder="请输入院系意见" />
      </a-form-item>
      <a-form-item
        label="备注"
        :labelCol="{lg: {span: 7}, sm: {span: 7}}"
        :wrapperCol="{lg: {span: 10}, sm: {span: 17} }">
        <a-input
          v-decorator="[
            'remark',
            {rules: [{ required: false, message: '请输入对应内容' }]}
          ]"
          name="remark"
          placeholder="请输入备注" />
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
  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'

  export default {
    name: 'BaseForm',
    data () {
      return {
        description: '国家奖学金申请提交页',
        value: 1,
        model: {},
        // form
        form: this.$form.createForm(this),

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
        this.form.resetFields()
        this.model = Object.assign({}, record)
        this.visible = true
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'baseRealName', 'baseStudentId', 'baseSex', 'baseBirthMonth', 'basePolitical', 'baseNation', 'baseComeSchoolDay', 'baseMajor', 'baseEducationalSystem', 'basePhone', 'baseIdCardNumber', 'stuMarkRank', 'stuTotalNumber', 'stuIsHaveEvaluation', 'stuEvaluationRank', 'applicationReasons', 'recommendReasons', 'departmentOpinion', 'remark', 'statu'))
          //时间格式化
        })
      },

      // handler
      handleSubmit (e) {
        e.preventDefault()
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
            let formData = Object.assign(this.model, values)
            //时间格式化
            console.log(formData)
            httpAction(httpurl, formData, method).then((res) => {
              if (res.success) {
                this.$message.success(res.message)
                this.$emit('ok')
              } else {
                this.$message.warning(res.message)
              }
            })
          }
        })
      }
    }
  }
</script>


