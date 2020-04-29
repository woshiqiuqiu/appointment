<template>
  <div style="background-color: #eeee">
    <div style="width: 1200px;margin: auto">
      <div class="row">
        <div style="margin-top: 40px" class="col-md-3">
          <!--导航-->
          <div   class="list-group ">
            <router-link style="margin: 10px 0"class="list-group-item list-group-item-primary carditem" :to="{name:'jiaohaodoclink'}">
              叫号
            </router-link>
            <router-link  style="margin: 10px 0"  class="list-group-item list-group-item-success carditem" :to="{name:'chufanglink'}" >
              诊断方案
            </router-link>





          </div>
        </div>
        <div class="col-md-9">
          <!--导航内容-->
          <router-view style="margin-top: 45px ;margin-left: 30px;height: 1000px" ></router-view>

        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "doc"
  }
</script>

<style scoped>

</style>
