<template>
  <div class="appointment">
    <div class="row mx-auto w-75">
      <div class="col-12">
        <table class="table table-hover table-success">
          <thead class="thead-default">
          <tr>
            <th>序号</th>
            <th>科室</th>
            <th>医生</th>
            <th>正在就诊</th>
            <th>等待就诊</th>
            <th>排队数</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(facility,index) in facilities">
            <td>{{index+1}}</td>
            <td>{{facility.keshi}}</td>
            <td>{{facility.doc}}</td>
            <td>{{facility.docing}}</td>
            <td>{{facility.waitdoc}}</td>
            <td>{{facility.waitnum}}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>

  </div>

</template>

<script>

  import jiaohaodatas from '../data/jiaohaodatas'
  let datas=jiaohaodatas.datas;
    export default {
      name: "jiaohao",
      data() {
        return {
          facilities: datas,
          newRow: {},

        }
      },

      methods: {},
    }
</script>

<style scoped>
  .appointment{
    background: url("../../static/jiaohaobkg.jpg ");
    width: 1500px;
    height: 100vh;
    margin: 0 auto;
    padding: 10%;
  }

</style>
