<template>
  <a-modal
    :title="title"
    :width="800"
    :visible="visible"
    :confirmLoading="confirmLoading"
    @ok="handleOk"
    @cancel="handleCancel"
    cancelText="关闭">

    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="姓名">
          <a-input placeholder="请输入姓名" v-decorator="['baseRealName', validatorRules.baseRealName ]"/>
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
          label="身份证号">
          <a-input placeholder="请输入身份证号" v-decorator="['baseIdCardNumber', validatorRules.baseIdCardNumber ]"/>
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
          label="政治面貌">
          <a-input placeholder="请输入政治面貌" v-decorator="['basePolitical', validatorRules.basePolitical ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="民族">
          <a-input placeholder="请输入民族" v-decorator="['baseNation', validatorRules.baseNation ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="入学年月">
          <a-input placeholder="请输入入学年月" v-decorator="['baseComeSchoolDay', validatorRules.baseComeSchoolDay ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="班级">
          <a-input placeholder="请输入班级" v-decorator="['baseClass', validatorRules.baseClass ]"/>
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
          label="贫困等级">
          <a-input placeholder="请输入贫困等级" v-decorator="['basePoorGrade', validatorRules.basePoorGrade ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="户口类型">
          <a-input placeholder="请输入户口类型" v-decorator="['baseResidence', {}]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="家庭住址">
          <a-input placeholder="请输入家庭住址" v-decorator="['baseAddress', {}]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="宿舍地址">
          <a-input placeholder="请输入宿舍地址" v-decorator="['baseDormitory', {}]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="专业">
          <a-input placeholder="请输入专业" v-decorator="['baseMajor', {}]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="学院">
          <a-input placeholder="请输入学院" v-decorator="['baseDepartment', {}]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="学校">
          <a-input placeholder="请输入学校" v-decorator="['baseSchool', validatorRules.baseSchool ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="出生日期">
          <a-input placeholder="请输入出生日期" v-decorator="['birthday', validatorRules.birthday ]"/>
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

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import {httpAction} from '@/api/manage'
  import pick from 'lodash.pick'

  export default {
    name: "StudentInfoModal",
    data() {
      return {
        title: "操作",
        visible: false,
        model: {},
        labelCol: {
          xs: {span: 24},
          sm: {span: 5},
        },
        wrapperCol: {
          xs: {span: 24},
          sm: {span: 16},
        },

        confirmLoading: false,
        form: this.$form.createForm(this),
        validatorRules: {
          baseRealName: {rules: [{required: true, message: '请输入姓名!'}]},
          baseStudentId: {rules: [{required: true, message: '请输入学号!'}]},
          baseIdCardNumber: {rules: [{required: true, message: '请输入身份证号!'}]},
          baseSex: {rules: [{required: true, message: '请输入性别，0表示女，1表示男!'}]},
          basePolitical: {rules: [{required: true, message: '请输入政治面貌!'}]},
          baseNation: {rules: [{required: true, message: '请输入民族!'}]},
          baseComeSchoolDay: {rules: [{required: true, message: '请输入入学年月!'}]},
          baseClass: {rules: [{required: true, message: '请输入班级!'}]},
          basePhone: {rules: [{required: true, message: '请输入联系电话!'}]},
          basePoorGrade: {rules: [{required: true, message: '请输入贫困等级!'}]},
          baseSchool: {rules: [{required: true, message: '请输入学校!'}]},
          birthday: {rules: [{required: true, message: '请输入出生日期!'}]},
          statu: {rules: [{required: true, message: '请输入状态!'}]},
        },
        url: {
          add: "/list.student.info/studentInfo/add",
          edit: "/list.student.info/studentInfo/edit",
        },
      }
    },
    created() {
    },
    methods: {
      add() {
        this.edit({});
      },
      edit(record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model, 'baseRealName', 'baseStudentId', 'baseIdCardNumber', 'baseSex', 'basePolitical', 'baseNation', 'baseComeSchoolDay', 'baseClass', 'basePhone', 'basePoorGrade', 'baseResidence', 'baseAddress', 'baseDormitory', 'baseMajor', 'baseDepartment', 'baseSchool', 'birthday', 'remark', 'statu'))
          //时间格式化
        });

      },
      close() {
        this.$emit('close');
        this.visible = false;
      },
      handleOk() {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if (!this.model.id) {
              httpurl += this.url.add;
              method = 'post';
            } else {
              httpurl += this.url.edit;
              method = 'put';
            }
            let formData = Object.assign(this.model, values);
            //时间格式化

            console.log(formData)
            httpAction(httpurl, formData, method).then((res) => {
              if (res.success) {
                that.$message.success(res.message);
                that.$emit('ok');
              } else {
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })


          }
        })
      },
      handleCancel() {
        this.close()
      },


    }
  }
</script>

<style scoped>

</style>