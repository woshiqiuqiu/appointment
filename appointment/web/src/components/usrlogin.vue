<template>
  <div>
    <div class="login">
      <div class="row">
        <div id="home" class="col-sm-12 text-center">
          <div class="background">
            <a style="margin: 50px auto;font-size: 30px">登陆</a>
            <p>
              <a>
                账号：
              </a>
              <input style="text-align:center;margin:50px auto 0;width: 180px" type="text" placeholder="账号">

            </p>
            <p>
              <a>
                密码：
              </a>
              <input style="text-align:center;margin:20px auto;;width: 180px" type="text" placeholder="密码">

            </p>
            <button type="button"  style="width: 260px;margin: 40px auto 0;background-color: #00EE76" class="btn btn-primary btn-block" @click="go">登陆</button>


          </div>
        </div>
      </div>
    </div>
  </div>


</template>

<script>
  export default {
    name: "usrlogin",
    data:function () {
      return{


      }
    },
    methods: {


      go: function () {
        this.$router.push('./home');

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
    height: 380px;
    margin: 0 auto;
    padding: 20px 0;
  }
</style>

