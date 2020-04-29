<template>
  <div  >
    <div class="bottom1 bg-info">


      <div style="margin-top:10px;display: flex" class="row">
        <div class="col-md-2"></div>

        <div class="col-md-2">
          <div style="margin-top:20px">
          <img src="../../static/local.png">
          <a style="margin-right: 30px;margin-left: 10px"> 地址：大沽南路1234号 </a>
          </div>
        </div>
        <div style="float:left;margin-top: 20px;width: 1px;height: 30px; background: #000000;"></div>
        <div class="col-md-2">
          <div style="margin-top:20px">
          <img src="../../static/email.png">
          <a style="margin-right: 30px;margin-left: 10px;margin-top: 10px"> 邮箱:hzz@163.com </a>
          </div>
        </div>
        <div style="float:left;margin-top: 20px;width: 1px;height: 30px; background: #000000;"></div>

        <div class="col-md-2">
          <div style="margin-top:20px">
          <img src="../../static/qq.png">
          <a style="margin-right: 30px;margin-left: 10px"> qq：1440980958 </a>
          </div>
        </div>
        <div style="float:left;margin-top: 20px;width: 1px;height: 30px; background: #000000;"></div>

        <div class="col-md-2">
          <div style="margin-top:20px">
          <img src="../../static/phone.png">
          <a style="margin-right: 30px;margin-left: 10px;margin-top: 10px"> 电话：022-2323 2323 </a>
          </div>
        </div>

      </div>


      <hr class="hrbo">

    </div>
    <div class="bottom2">
      <div style="text-align:center">2019/06/27 design by @zzx</div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "bottom"
  }
</script>

<style scoped>
  .hrbo {
    width: 70%;
    background: black;

  }

  .bottom1 {
    width: 100%;
    height: 70px;

  }

  .bottom2 {
    width: 100%;
    height: 30px;
    background-color: #003f80;
  }
</style>
