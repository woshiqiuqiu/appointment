<template>
  <div class="bkg row">
    <div class="container" id="doc-pat" >
      <div style=" width:auto;height:auto;margin: 5px auto">
        <a style="font-size: 25px">挂号患者信息</a>
      </div>
      <div class="row mx-auto w-75" style="height: 30px"></div>
      <div class="row mx-auto w-75">
        <div class="col-6">
          <div class="btn-group">
            <button type="button" class="btn btn-outline-primary btn-sm" @click="jiaohaodoc">叫号</button>
          </div>
          <button type="button" class="btn btn-outline-warning btn-sm" @click="delRows">删除</button>
        </div>
        <div class="col-6">
          <div class="input-group">
            <a style="margin-left: 10px;font-size: 15px">该患者已被叫号{{count}}次</a>
            <!--<input type="text" class="form-control input-group-sm" placeholder="输入患者名称进行搜索">-->
            <!--<span class="input-group-btn">-->
                        <!--<button class="btn btn-default" type="button"><i class="fa fa-search">搜索</i></button>-->
                    <!--</span>-->
          </div>
        </div>
      </div>
      <div class="row mx-auto w-75" style="height: 15px"></div>
      <div class="row mx-auto w-75">
        <div class="col-12">
          <table class="table table-hover table-success">
            <thead class="thead-default">
            <tr>
              <th>   </th>
              <th>序号</th>
              <th>挂号编号</th>
              <th>患者姓名</th>
              <th>预约医生</th>
              <th>预约科室</th>

            </tr>
            </thead>
            <tbody>
            <tr v-for="(facility,index) in facilities">
              <td><input type="checkbox" :value="index" v-model="checkedRows"></td>
              <td>{{index+1}}</td>
              <td>{{facility.treatnumber}}</td>
              <td>{{facility.name}}</td>
              <td>{{facility.dname}}</td>
              <td>{{facility.office}}</td>

            </tr>

            </tbody>
          </table>
        </div>
      </div>
      <!-- 模态框 -->

    </div>



  </div>
</template>

<script>
  import guahaopatdata from '../../data/guahao'
  let guahaopatdatas=guahaopatdata.datas;
  // var swapItems = function(arr, index1, index2){
  //   arr[index1] = arr.splice(index2,1,arr[index1])[0]
  //   return arr
  // }

  export default {
    name: "jiaohaodoc",
    data(){
      return{
        checkAll: false,
        checkedRows: [],
        facilities: guahaopatdatas,
        newRow: {},
        count:0,

      }
    },
    methods:{
      addRow: function () {
        this.facilities.push(this.newRow);
        this.newRow = {};
      },
      jiaohaodoc:function () {//叫号
        this.count++;
        console.log("您已叫号"+this.count+"次");
        if(this.count>=4) {
          confirm("您确定使该患者过号？")
          for (var i = 0; i < this.checkedRows.length; i++) {
            var checkedRowIndex = this.checkedRows[i];
            this.facilities = $.grep(this.facilities, function (facility, j) {
              return j != checkedRowIndex;
            });
          }
          this.count=0;
          this.checkedRows = [];

        }
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
   .bkg{
     background-color: #eeee;
     width: 100%;
     height: auto;
     margin: 0 auto;

  }
  .background{
    background: #eeee;
    opacity: 0.8;
    margin: 40px auto;
    width: 1200px;
    padding: 20px 0;
  }
</style>

