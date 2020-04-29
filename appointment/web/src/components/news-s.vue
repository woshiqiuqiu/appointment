<template>
  <div style="height: 190px" class="card text-dark bg-light ">
    <div class="card-header">预约</div>
    <div class="card-body">

      <p class="card-text">您需要先注册本医院个人账号之后再进行线上预约</p>
      <router-link :to="{name:'registerlink'}">
        <a>--->注册</a>
      </router-link>
      <router-link :to="{name:'appointmentlink'}">
        <a style="margin-left: 10px">--->预约</a>
      </router-link>
    </div>
  </div>
</template>

<script>
    export default {
        name: "news-s"
    }
</script>

<style scoped>

</style>
