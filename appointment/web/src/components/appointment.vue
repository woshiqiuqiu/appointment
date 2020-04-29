<template>
  <div class="appointment">
    <div class="row">
      <div id="home" class="col-sm-12 text-center">
        <div class="background">
          <h1>感谢您选择本医院！</h1>
          <h3>通过线上预约您可以获得更加便捷高效的医疗服务体验</h3>

          <h3>请在拥有本医院线上账号后，进行预约操作</h3>
<router-link :to="{name:'appointmentmainlink'}">
  <button  style="margin-top: 20px" class="btn btn-success">立即预约</button>

</router-link>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "appointment"
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
  h1,h2{
    margin: 6%;
  }
  .background{
    background: #eee ;
    opacity: 0.8;
    max-width: 70vw;
    margin: 0 auto;
    padding: 20px 0;
  }
</style>
