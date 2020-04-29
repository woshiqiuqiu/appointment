<template>
  <div style="height: 190px" class="card text-dark bg-light ">
    <div class="card-header">联系我们</div>
    <div style="margin-top: 5px" class="card-body">
      <div style="display: flex;justify-content:center ">
        <router-link :to="{name: 'locallink'}" class="nav-link" >地址</router-link>
       <router-link :to="{name: 'phonelink'}" class="nav-link" >电话</router-link>
        <router-link :to="{name: 'emaillink'}" class="nav-link" >邮箱</router-link>
        <router-link :to="{name: 'qqlink'}" class="nav-link" >qq</router-link>

      </div>

      <router-view></router-view>
    </div>
  </div>
</template>

<script>
    export default {
        name: "callus-s"
    }
</script>

<style scoped>

</style>
