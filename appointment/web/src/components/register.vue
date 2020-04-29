<template>
    <div class="bkg">
      <div style="width: auto;">
        <a style="font-size: 30px;margin: 10px 40px">注册</a>
      </div>
      <div style="margin-top: 50px" class="row">
        <div class="col-md-5" style="text-align: right">
          <p style="height: 40px;font-weight: bold">
            请输入您的姓名：
          </p>
          <p style="height: 40px;font-weight: bold">
            请输入手机号：
          </p>
          <p style="height: 40px;font-weight: bold">
            请输入验证码：
          </p>
          <p style="height: 40px;font-weight: bold">
            设置密码：
          </p>
          <p style="height: 40px;font-weight: bold">
            确认密码：
          </p>
          <p style="height: 40px;font-weight: bold">
            您的身份：
          </p>
          <p style="height: 40px;font-weight: bold">
            您的工号：
          </p>
        </div>

        <div class="col-md-7">
          <p style="height: 40px">
            <input style=";text-align:center;margin:0 auto" v-model="mesname" type="text" placeholder="姓名">

          </p>
          <p style="height: 40px">
            <input style=";text-align:center;margin:0 auto" v-model="mesphone" type="text" placeholder="手机号">
          </p>
          <p style="height: 40px">
            <input style=";text-align:center;margin:0 auto" type="text" placeholder="验证码">
            <button style="width: 100px ; margin-left: 10px" :disabled="disabled" @click="sendcode">
              {{btntxt}}
            </button>

          </p>
          <p style="height: 40px">
            <input id="inputpsw1" style=";text-align:center;margin:0 auto" type="password" v-model="mespass" placeholder="密码">
            <img  style="margin-left: 10px" id="pswimg1" @click="hideShowPsw()" src="../../static/visible.png">

          </p>
          <p style="height: 40px">
            <input style=";text-align:center;margin:0 auto" type="text" placeholder="确认密码">

          </p>
          <p style="height: 40px">
            <input type="checkbox" v-model="checkeded"     value="患者" id="huanzhe"/>
            <label for="huanzhe">患者</label>
            <input type="checkbox" v-model="checkeded"   value="本院工作人员" id="worker"/>
            <label for="worker">本院工作人员</label>

          </p>
          <p style="height: 40px">
            <input style=";text-align:center;margin:0 auto" type="text" placeholder="工号">
            <a style="font-size: 15px;color: red;margin-left: 30px">*患者无需填写</a>
          </p>
        </div>
      </div>


      <div style="width: 700px; height: 200px; border-style: outset;background:#fffff7;margin: 20px auto">
        <div class="row">
          <div class="col-md-6">
            <p style="margin-left: 10px; margin-top:10px;height: 20px ;tab-size: 50px;font-style:italic">您的信息卡</p>


            <p style="margin-left: 10px;margin-top: 40px">姓名：{{mesname}}</p>
            <p style="margin-left: 10px;">密码：{{mespass}}</p>

          </div>
          <div class="col-md-6">
            <p style="margin-top: 70px">手机号：{{mesphone}}</p>
            <p>身份：{{checkeded}}</p>
          </div>

        </div>



      </div>

      <div style="width: 700px;text-align: center;margin: 20px auto">
        <router-link :to="{name:'homelink'}" >
          <button class="btn btn-primary btn-block" @click="sucgo">立即注册</button>
        </router-link>
      </div>
    </div>


</template>

<script>
  export default {
    name: "register",
    data() {
      return {
        btntxt: "获取验证码",
        disabled: false,
        time: 0,
        mesname: '',
        mesphone: '',
        mespass: '',
        checkeded: [],


      }
    },
    methods: {
      // checkbox1:function(){
      //   if(worker.checked=false){
      //     huanzhe.disable=false;
      // }else{
      //     huanzhe.disable=true
      //
      //   }
      // },
      // checkbox2:function(){
      //   if(huanzhe.checked=false){
      //     worker.disable=false;
      //     value="sds"
      //
      //   }else {worker.disable=true;
      //     value="患者"
      //
      //   }
      // },


      hideShowPsw:function(){
        if (inputpsw1.type == "password") {
          inputpsw1.type = "text";
          pswimg1.src = "../../static/invisible.png";
        }else {
          inputpsw1.type = "password";
          pswimg1.src = "../../static/visible.png";
        }
      },
      sucgo:function(){
        alert("您已注册成功！")
      },
//验证手机号码部分
      sendcode: function () {

        this.time = 35;
        this.disabled = true;
        this.timer();

      },
      timer: function () {
        if (this.time > 0) {
          this.time--;
//                 console.log(this.time);
          this.btntxt = this.time + "(s)";
          setTimeout(this.timer, 1000);
        } else {
          this.time = 0;
          this.btntxt = "获取验证码";
          this.disabled = false;
        }
      }
    }

  }
</script>

<style scoped>
  .bkg{
    background: url("../../static/regsiter.jpg ");
    width: 100%;
    height: 1000px;
    margin: 0 auto;

  }

</style>
