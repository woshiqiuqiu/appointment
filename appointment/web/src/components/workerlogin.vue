<template>
    <div class="login">
      <div class="row">
        <div id="home" class="col-sm-12 text-center">
          <div class="background">
            <a style="margin: 20px auto;font-size: 30px">登陆</a>
            <p>
              <a>
                工号：
              </a>
              <input style="text-align:center;margin:40px auto 0;width: 180px" type="text" placeholder="工号">

            </p>
            <p>
              <a>
                密码：
              </a>
              <input style="text-align:center;margin:20px auto;;width: 180px" type="text" placeholder="密码">

            </p>
            <p>
              <a>
                身份：
              </a>
              <select name="select01" id="select01" v-model="selected" @change='getValue01'>

                <option value="">--请选择--</option>
                <option v-for='item in optionList'>{{ item }}</option>

              </select>
              <!--<select  style="width: 180px" name="yourName" id="yourId">-->
              <!--<option value="1">患者</option>-->
              <!--<option value="2">管理员</option>-->
              <!--<option value="3">医生</option>-->
              <!--<option value="4">药师</option>-->
              <!--</select>-->
            </p>
            <button type="button"  style="width: 260px;margin: 70px auto 0;background-color: #00EE76" class="btn btn-primary btn-block" @click="go">登陆</button>


          </div>
        </div>
      </div>
    </div>


</template>

<script>
  export default {
    name: "workerlogin",
    data:function () {
      return{
        selected: '',
        optionList: [ '管理员', '科室管理员','医生', '药师','导诊'],
      }
    },
    methods: {
      getValue01: function(){
        console.log('您选择了', this.selected)

      },

      go:function () {
        switch (this.selected) {

          case "管理员":
            this.$router.push('./admink');
            break;
          case "科室管理员":
            this.$router.push('./keshiadmin');
            break;
          case "医生":
            this.$router.push('./doc');
            break;
          case "药师":
            this.$router.push('./medoc');
            break;
          case "导诊":
            this.$router.push('./nurse');
            break;


        };
      }
    }





  }
</script>

<style scoped>
  .login {
    background: url("../../static/login-bkg.jpg ");
    width: 100%;
    height: 100vh;
    margin: 0 auto;
    padding: 10%;
  }

  .background {
    background: #eee;
    opacity: 0.8;
    max-width: 30vw;
    height: 500px;
    margin: 0 auto;
    padding: 20px 0;
  }
</style>

