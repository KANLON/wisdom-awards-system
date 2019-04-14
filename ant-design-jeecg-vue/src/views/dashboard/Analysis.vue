<template>
  <div class="page-header-index-wide">
    <a-card :loading="loading" :bordered="false" :body-style="{padding: '0'}">
      <div class="salesCard">
        <a-tabs default-active-key="1" size="large" :tab-bar-style="{marginBottom: '24px', paddingLeft: '16px'}">
          <!-- <div class="extra-wrapper" slot="tabBarExtraContent">
            <div class="extra-item">
              <a>今日</a>
              <a>本周</a>
              <a>本月</a>
              <a>本年</a>
            </div>
            <a-range-picker :style="{width: '256px'}" />
          </div>-->
          <a-tab-pane loading="true" tab="消息公告" key="1">
            <a-row>
              <a-col :xl="24" :lg="24" :md="24" :sm="24" :xs="24">
                <rank-time-list :list="rankTimeList"/>
              </a-col>
            </a-row>
          </a-tab-pane>
        </a-tabs>
      </div>
    </a-card>

    <a-row :gutter="12">
      <a-col :xl="12" :lg="24" :md="24" :sm="24" :xs="24">
        <a-card :loading="loading" :bordered="false" title="实时访问统计" :style="{ marginTop: '24px' }">
          <a-dropdown :trigger="['click']" placement="bottomLeft" slot="extra">
          <!--  <a class="ant-dropdown-link" href="#">
              <a-icon type="ellipsis" />
            </a>
             <a-menu slot="overlay">
              <a-menu-item>
                <a href="javascript:;">操作一</a>
              </a-menu-item>
              <a-menu-item>
                <a href="javascript:;">操作二</a>
              </a-menu-item>
            </a-menu>-->

          </a-dropdown>
          <div style="height: 105px">
            <a-row>
              <a-col :span="8">
                <div class="head-info">
                  <span>今日IP</span>
                  <p><a>{{ loginfo.todayIp }}</a></p>
                </div>
              </a-col>
              <a-col :span="8">
                <div class="head-info">
                  <span>今日访问</span>
                  <p><a>{{ loginfo.todayVisitCount }}</a></p>
                </div>
              </a-col>
              <a-col :span="8">
                <div class="head-info" >
                  <span>访问总览</span>
                  <p><a>{{ loginfo.totalVisitCount }}</a></p>
                </div>
              </a-col>
            </a-row>
          </div>
        </a-card>
      </a-col>

      <a-col :xl="12" :lg="24" :md="24" :sm="24" :xs="24">
        <a-card :loading="loading" :bordered="false" title="申请情况" :style="{ marginTop: '24px' }">
          <a-dropdown :trigger="['click']" placement="bottomLeft" slot="extra">
            <a class="ant-dropdown-link" href="#">
              <a-icon type="ellipsis" />
            </a>

            <a-menu slot="overlay">
              <a-menu-item>
                <a href="javascript:;">查看详情</a>
              </a-menu-item>
              <!-- <a-menu-item>
                <a href="javascript:;">操作二</a>
              </a-menu-item> -->
            </a-menu>

          </a-dropdown>
          <p>励志奖学金申请次数</p>
          <p>助学金申请次数</p>
          <p>国家奖学金申请次数</p>
          <p>助学贷款申请次数</p>
        </a-card>
      </a-col>

    </a-row>
  </div>
</template>

<script>
  import ChartCard from '@/components/ChartCard'
  import ACol from "ant-design-vue/es/grid/Col"
  import ATooltip from "ant-design-vue/es/tooltip/Tooltip"
  import MiniArea from '@/components/chart/MiniArea'
  import MiniBar from '@/components/chart/MiniBar'
  import MiniProgress from '@/components/chart/MiniProgress'
  import RankTimeList from '@/components/chart/RankTimeList'
  import Bar from '@/components/chart/Bar'
  import Trend from '@/components/Trend'
  import {getLoginfo} from '@/api/api.js'
  import {getAction} from '@/api/manage'

  const rankTimeList = []
  //获取消息的url
  const messageUrl = "/list.message/message/list";

  export default {
    name: "Analysis",
    components: {
      ATooltip,
      ACol,
      ChartCard,
      MiniArea,
      MiniBar,
      MiniProgress,
      RankTimeList,
      Bar,
      Trend
    },
    data() {
      return {
        loading: true,
        rankTimeList,
        loginfo:{},
      }
    },
    created() {
      setTimeout(() => {
        this.loading = !this.loading
      }, 1000)
      this.initLogInfo();
      this.initMessageList();
    },
    methods: {
      initLogInfo () {
        getLoginfo(null).then((res)=>{
          if(res.success){
            this.loginfo = res.result;
          }
        })
      },
      initMessageList(){
        getAction(messageUrl, null).then((res) => {
          if (res.success) {
            for(let i = 0; i < res.result.records.length; i++){
              rankTimeList.push({
                name: res.result.records[i].title,
                time: res.result.records[i].ctime
              })
            }
          }
        })
      }
    }
  }
</script>

<style lang="scss" scoped>
  .extra-wrapper {
    line-height: 55px;
    padding-right: 24px;

    .extra-item {
      display: inline-block;
      margin-right: 24px;

      a {
        margin-left: 24px;
      }
    }
  }

  /* 首页访问量统计 */
  .head-info {
    position: relative;
    text-align: left;
    padding: 0 32px 0 0;
    min-width: 125px;

    span {
      color: rgba(0, 0, 0, .45);
      display: inline-block;
      font-size: .95rem;
      line-height: 42px;
      margin-bottom: 4px;
    }
    p {
      line-height: 42px;
      margin: 0;
      a {
        font-weight: 600;
        font-size: 1rem;
      }
    }
  }
</style>






