<template>
  <div>
    <div style="display: flex;justify-content:center">

      <img style="margin-right: 100px" src="../../../static/localmap.png"/>
      <a>地址：天津市河西区大沽南路1234号</a>
      <router-link :to="{name:'surveylink'}">-->地图</router-link>


    </div>


  </div>

</template>

<script>
  export default {
    name: "local"
  }
</script>

<style scoped>

</style>
