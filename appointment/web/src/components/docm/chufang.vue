<template>
<div class="container" >
  <div style="display: flex;justify-content:left;margin-top: 50px">
    <a style="font-size: 18px">患者挂号单号： </a>
    <textarea style="width: 500px;height: 25px"></textarea>

  </div>
  <div style="display: flex;justify-content:left;margin-top: 20px">
    <a style="font-size: 18px">患者病情描述： </a>
    <textarea style="width: 500px;height:200px"></textarea>

  </div>
  <div style="display: flex;justify-content:left;margin-top: 20px">
    <a style="font-size: 18px">患者治疗药物： </a>
    <textarea style="width: 500px;height:50px"></textarea>

  </div>
  <div style="display: flex;justify-content:left;margin-top: 20px">
    <a style="font-size: 18px">使用药品数量： </a>
    <textarea style="width: 500px;height:50px"></textarea>

  </div>
  <div style="display: flex;justify-content:left;margin-top: 20px">
    <a style="font-size: 18px">患者治疗方式： </a>
    <textarea style="width: 500px;height:200px"></textarea>

  </div>

  <button type="button"  style="width: 500px;margin-left: 125px;margin-top:30px;background-color: #00EE76" class="btn btn-primary btn-block" >提交</button>






</div>
</template>

<script>
    export default {
        name: "chufang"
    }
</script>

<style scoped>

</style>
