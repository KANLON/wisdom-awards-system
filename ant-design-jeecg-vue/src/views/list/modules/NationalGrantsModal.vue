<template>
  <a-modal
    :confirmLoading="confirmLoading"
    :title="title"
    :visible="visible"
    :width="800"
    @cancel="handleCancel"
    @ok="handleOk"
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
          label="性别">
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
          label="学号">
          <a-input placeholder="请输入学号" v-decorator="['baseStudentId', validatorRules.baseStudentId ]"/>
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
          label="身份证号">
          <a-input placeholder="请输入身份证号" v-decorator="['baseIdCardNumber', validatorRules.baseIdCardNumber ]"/>
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
          label="学年">
          <a-input placeholder="请输入学年" v-decorator="['studyYear', validatorRules.studyYear ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="学期">
          <a-input placeholder="请输入学期" v-decorator="['studyTeam', validatorRules.studyTeam ]"/>
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
          label="困难等级">
          <a-input placeholder="请输入困难等级" v-decorator="['poorLevel', validatorRules.poorLevel ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="应发金额">
          <a-input-number v-decorator="[ 'amountPayable', validatorRules.amountPayable ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="发放日期">
          <a-input placeholder="请输入发放日期" v-decorator="['payDate', validatorRules.payDate ]"/>
        </a-form-item>
        <a-form-item
          :labelCol="labelCol"
          :wrapperCol="wrapperCol"
          label="申请理由（150字）">
          <a-input placeholder="请输入申请理由（150字）"
                   v-decorator="['applicationReasons', validatorRules.applicationReasons ]"/>
        </a-form-item>

      </a-form>
    </a-spin>
  </a-modal>
</template>

<script>
  import {httpAction} from '@/api/manage'
  import pick from 'lodash.pick'

  export default {
    name: "NationalGrantsModal",
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
          baseSex: {rules: [{required: true, message: '请输入性别，0表示女，1表示男!'}]},
          basePolitical: {rules: [{required: true, message: '请输入政治面貌!'}]},
          baseNation: {rules: [{required: true, message: '请输入民族!'}]},
          baseComeSchoolDay: {rules: [{required: true, message: '请输入入学年月!'}]},
          baseStudentId: {rules: [{required: true, message: '请输入学号!'}]},
          baseClass: {rules: [{required: true, message: '请输入班级!'}]},
          basePhone: {rules: [{required: true, message: '请输入联系电话!'}]},
          baseIdCardNumber: {rules: [{required: true, message: '请输入身份证号!'}]},
          basePoorGrade: {rules: [{required: true, message: '请输入贫困等级!'}]},
          studyYear: {rules: [{required: true, message: '请输入学年!'}]},
          studyTeam: {rules: [{required: true, message: '请输入学期!'}]},
          birthday: {rules: [{required: true, message: '请输入出生日期!'}]},
          poorLevel: {rules: [{required: true, message: '请输入困难等级!'}]},
          amountPayable: {rules: [{required: true, message: '请输入应发金额!'}]},
          payDate: {rules: [{required: true, message: '请输入发放日期!'}]},
          applicationReasons: {rules: [{required: true, message: '请输入申请理由（150字）!'}]},
        },
        url: {
          add: "/list.national.grants/nationalGrants/add",
          edit: "/list.national.grants/nationalGrants/edit",
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
          this.form.setFieldsValue(pick(this.model, 'baseRealName', 'baseSex', 'basePolitical', 'baseNation', 'baseComeSchoolDay', 'baseStudentId', 'baseClass', 'basePhone', 'baseIdCardNumber', 'basePoorGrade', 'studyYear', 'studyTeam', 'birthday', 'poorLevel', 'amountPayable', 'payDate', 'applicationReasons'))
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

            console.log(formData);
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