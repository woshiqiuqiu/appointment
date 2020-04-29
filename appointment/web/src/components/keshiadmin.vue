<template>
  <div style="background-color: #eeee">
  <div style="width: 1200px;margin: auto">
    <div class="row">
      <div style="margin-top: 40px" class="col-md-3">
        <!--导航-->
        <div   class="list-group ">
          <router-link style="margin: 10px 0"class="list-group-item list-group-item-primary carditem" :to="{name:'future7yuyuelink'}">
            未来七天预约更新
          </router-link>
          <router-link  style="margin: 10px 0"  class="list-group-item list-group-item-success carditem" :to="{name:'future7doclink'}" >
            未来一周就诊安排
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
        name: "keshiadmin"
    }
</script>

<style scoped>

</style>
