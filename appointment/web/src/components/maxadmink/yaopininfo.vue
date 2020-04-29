<template>
  <div class="container" id="admink-mec" >

    <div class="row mx-auto w-75">
      <div class="col-6">
        <div class="btn-group">
          <button type="button" class="btn btn-outline-info btn-sm" data-toggle="modal" data-target="#myModal2">新增</button>
          <button type="button" class="btn btn-outline-primary btn-sm" @click="savemecRows">保存</button>
        </div>
        <button type="button" class="btn btn-outline-warning btn-sm" @click="delmecRows">删除</button>
      </div>
      <div class="col-6">
        <div class="input-group">
          <input type="text" class="form-control input-group-sm" placeholder="输入药品名称进行搜索">
          <span class="input-group-btn">
                        <button class="btn btn-default" type="button"><i class="fa fa-search">搜索</i></button>
                    </span>
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
            <th>药品编号</th>
            <th>药品名称</th>
            <th>药品库存</th>
            <th>药品价格(元)</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(mecfacility,index) in mecfacilities">
            <td><input type="checkbox" :value="index" v-model="meccheckedRows"></td>
            <td>{{index+1}}</td>
            <td>{{mecfacility.mecnum}}</td>
            <td>{{mecfacility.mecname}}</td>
            <td>{{mecfacility.mecnumber}}</td>
            <td>{{mecfacility.mecprice}}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- 模态框 -->
    <div class="modal fade" id="myModal2">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">新增药品信息</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-3">药品编号：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品编号" v-model="mecnewRow.mecnum">
              </div>
            </div>
            <div class="row">
              <div class="col-3">药品名称：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品名称" v-model="mecnewRow.mecname">

              </div>
            </div>
            <div class="row">
              <div class="col-3">药品库存：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品库存" v-model="mecnewRow.mecnumber">
              </div>
            </div>
            <div class="row">
              <div class="col-3">药品价格：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品价格" v-model="mecnewRow.mecprice">
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-primary" data-dismiss="modal" @click="addmecRow">确认</button>
          </div>
        </div>
      </div>
    </div>
  </div>

</template>

<script>
  import mecdata from '../../data/mecdatas'
  let mecdatas=mecdata.datas;
    export default {
        name: "yaopininfo",
      data(){
          return{
            meccheckAll: false,
            meccheckedRows: [],
            mecfacilities: mecdatas,
            mecnewRow: {},
          }
      },
      methods:{
        addmecRow: function () {
          this.mecfacilities.push(this.mecnewRow);
          this.mecnewRow = {};
        },
        savemecRows:function () {//保存表格数据

        },
        delmecRows:function () {
          if (this.meccheckedRows.length <= 0){
            alert("您未选择需要删除的数据");
            return false;
          }
          if (!confirm("您确定要删除选择的数据吗？")){
            return false;
          }

          for(var i=0;i<this.meccheckedRows.length;i++){
            var meccheckedRowIndex = this.meccheckedRows[i];
            this.mecfacilities = $.grep(this.mecfacilities,function (mecfacility,j) {
              return j != meccheckedRowIndex;
            });
          }
          this.meccheckedRows = [];
        }
      }
    }
</script>

<style scoped>

</style>
