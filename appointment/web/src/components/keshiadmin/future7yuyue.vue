<template>
  <div class="container" id="fu7yu">

    <div class="row mx-auto w-75" style="height: 15px"></div>
    <div class="row mx-auto w-75">
    </div>
    <div class="row mx-auto w-75" style="height: 15px"></div>
    <div class="row mx-auto w-75">
      <div class="col-12">
        <table class="table table-hover table-success">
          <thead class="thead-default">
          <tr>
            <th>  </th>
            <th>序号</th>
            <th>预约患者身份证号</th>
            <th>患者姓名</th>
            <th>预约时间</th>
            <th>预约医生</th>

            <th>预约科室</th>
            <th>预约号</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(facility,index) in facilities">
            <td><input type="checkbox" :value="index" v-model="checkedRows"></td>
            <td>{{index+1}}</td>
            <td>{{facility.yuyuepatid}}</td>
            <td>{{facility.yuyuepatname}}</td>
            <td>{{facility.yuyuetime}}</td>
            <td>{{facility.yuyuedoc}}</td>
            <td>{{facility.yuyuekeshi}}</td>
            <td>{{facility.yuyueid}}</td>

          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- 模态框 -->
  </div>

</template>

<script>
  import fu7yudatas from '../../data/guahao'
  let fu7yudata = fu7yudatas.datas
    export default {
        name: "future7yuyue",
      data () {
        return {
          checkAll: false,
          checkedRows: [],
          facilities: fu7yudata,
          newRow:{}
        }
      },

      methods: {
        addRow: function () {
          this.facilities.push(this.newRow);
          this.newRow = {};
        },
        saveRows:function () {//保存表格数据

        },
        delRows:function () {
          if (this.checkedRows.length <= 0){
            alert("您未选择需要删除的数据");
            return false;
          }
          if (!confirm("您确定要删除选择的数据吗？")){
            return false;
          }

          for(var i=0;i<this.checkedRows.length;i++){
            var checkedRowIndex = this.checkedRows[i];
            this.facilities = $.grep(this.facilities,function (facility,j) {
              return j != checkedRowIndex;
            });
          }
          this.checkedRows = [];
        }
      }

    }
</script>

<style scoped>

</style>
