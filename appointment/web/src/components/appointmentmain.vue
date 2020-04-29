<template>
<div class="appointment">
  <div class="row">
    <div id="home" class="col-sm-12 text-center">
      <div class="background">
        <div style="margin-top: 50px" class="row">
          <div class="col-md-5" style="text-align: right">
            <p style="height: 40px">
              科室：
            </p>
            <p style="height: 40px">
              时间：
            </p>
            <p style="height: 40px">
              医生：
            </p>
            <p style="height: 40px">
              手机号码：
            </p>
            <p style="height: 40px">
              验证码：
            </p>

          </div>

          <div class="col-md-7">
            <p style="height: 40px;text-align: left">
              <select name="select01" id="selectkeshi" v-model="selectedkeshi" >

                <option value="">--请选择--</option>
                <option v-for='item in optionListkeshi'>{{ item }}</option>
              </select>


            </p>
            <p style="height: 40px;text-align: left">
              <el-date-picker
                v-model="selectedtime"
                type="datetime"
                format="yyyy-MM-dd hh:mm"
                value-format="yyyy-MM-dd hh:mm"
                placeholder="选择日期时间">
              </el-date-picker>
              <el-button type="primary" @click="clickBtn">选择预约时间</el-button>

            </p>
            <p style="height: 40px;text-align: left">
              <select name="select03" id="select01" v-model="selecteddoc" >

                <option value="">--请选择--</option>
                <option v-for='item in optionListdoc'>{{ item }}</option>

              </select>

            </p>
            <p style="height: 40px;text-align: left">
                <input id="inputpsw1" style=";text-align:center;margin:0 auto"   placeholder="手机号" v-model="phone">
              <button style="width: 100px ; margin-left: 10px" :disabled="disabled"  @click="sendcodeapp">
                {{btntxtapp}}
              </button>
            </p>
            <p style="height: 40px;text-align: left">
              <input style=";text-align:center;margin:0 auto" type="text" placeholder="验证码" v-model="incheck">

            </p>
          </div>
        </div>
        <router-link :to="{name:'homelink'}">

          <button  style="margin-top: 20px" class="btn btn-success" @click="sucalert">提交</button>

        </router-link>

      </div>
    </div>
  </div>





</div>
</template>

<script>
    export default {
        name: "appointmentmain",
      data(){
          return{
            btntxtapp: "获取验证码",
            disabled: false,
            timeapp: 0,
            selecteddoc: '',
            optionListdoc: ['张一','张二', '张三', '张四'],
            selectedkeshi: '',
            optionListkeshi: ['神经外科','耳鼻喉科', '内分泌科', '骨科'],
            selectedtime:'',
            incheck:'',
            phone:''

          }
      },
      methods:{
        clickBtn: function () {
          console.log(this.selectedtime);
          console.log(this.selecteddoc);
          console.log(this.selectedkeshi);
          console.log(this.incheck);
          console.log(this.phone);




        },
        sendcodeapp: function () {

          this.timep = 35;
          this.disabled = true;
          this.timerapp();

        },
        timerapp: function () {
          if (this.timep > 0)   {
            this.timep--;
//                 console.log(this.time);
            this.btntxtapp = this.timep + "(s)";
            setTimeout(this.timerapp, 1000);
          } else {
            this.timep = 0;
            this.btntxtapp = "获取验证码";
            this.disabled = false;
          }
        },
        getValue01: function(){
          console.log('您选择了', this.selecteddoc)

        },
        sucalert:function(){
          alert("您已预约成功！");

        },
      }

    }
</script>

<style scoped>
  .appointment{
    background: url("../../static/app-backg.jpg ");
    width: 1200px;
    height: 85vh;
    margin: 10px auto;
    padding: 10%;
  }
  .background{
    background: #eee ;
    opacity: 0.8;
    max-width: 50vw;
    height: auto;
    margin: 0 auto;
    padding: 20px 0;
  }
</style>
