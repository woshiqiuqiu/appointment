<template>
  <div style="background-color: #eeee">
  <div class="bkg container">
    <div class=" row ">
      <div style="margin-top: 40px" class=" col-md-3">
        <!--导航-->
        <div   class="list-group ">
          <router-link  style="margin: 10px 0"  class="list-group-item list-group-item-success carditem" :to="{name:'workerinfolink'}" >
            管理职工名单
          </router-link>
          <router-link style="margin: 10px 0"class="list-group-item list-group-item-primary carditem" :to="{name:'yaopininfolink'}">
            管理药品名单
          </router-link>
          <router-link style="margin: 10px 0" class="list-group-item list-group-item-warning carditem" :to="{name:'keshiinfolink'}">
            管理科室名单
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
        name: "admin",




    }
</script>

<style scoped>
  .bkg{
    width: 100%;
    height: auto;
    margin: 0 auto;

  }
</style>
