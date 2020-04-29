<template>
  <div class="container" id="keshi" >

    <div class="row mx-auto w-75">
      <div class="col-6">
        <div class="btn-group">
          <button type="button" class="btn btn-outline-info btn-sm" data-toggle="modal" data-target="#myModal">新增</button>
          <button type="button" class="btn btn-outline-primary btn-sm" @click="savedocRows">保存</button>
        </div>
        <button type="button" class="btn btn-outline-warning btn-sm" @click="deldocRows">删除</button>
      </div>
      <div class="col-6">
        <div class="input-group">
          <input type="text" class="form-control input-group-sm" placeholder="输入科室名称进行搜索">
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
            <th>科室编号</th>
            <th>科室名称</th>
            <th>科室位置</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(docfacility,index) in docfacilities">
            <td><input type="checkbox" :value="index" v-model="doccheckedRows"></td>
            <td>{{index+1}}</td>
            <td>{{docfacility.keshiid}}</td>
            <td>{{docfacility.keshiname}}</td>
            <td>{{docfacility.keshilocation}}</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <!-- 模态框 -->
    <div class="modal fade" id="myModal">
      <div class="modal-dialog">
        <div class="modal-content">
          <div class="modal-header">
            <h4 class="modal-title">新增科室信息</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-3">科室编号：</div>
              <div class="col-9">
                <input class="form-control" placeholder="编号" v-model="docnewRow.keshiid">
              </div>
            </div>
            <div class="row">
              <div class="col-3">科室名称：</div>
              <div class="col-9">
                <input class="form-control" placeholder="名称" v-model="docnewRow.keshiname">

              </div>
            </div>
            <div class="row">
              <div class="col-3">科室位置：</div>
              <div class="col-9">
                <input class="form-control" placeholder="位置" v-model="docnewRow.keshilocation">
              </div>
            </div>
          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-primary" data-dismiss="modal" @click="adddocRow">确认</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import keshidata from '../../data/keshidatas'
  let keshidatas=keshidata.datas;
  export default {
    name: "keshi",
    data(){
      return{
        doccheckAll: false,
        doccheckedRows: [],
        docfacilities: keshidatas,
        docnewRow: {},
      }

    },
    methods:{
      adddocRow: function () {
        this.docfacilities.push(this.docnewRow);
        this.docnewRow = {};
      },
      savedocRows:function () {//保存表格数据

      },
      deldocRows:function () {
        if (this.doccheckedRows.length <= 0){
          alert("您未选择需要删除的数据");
          return false;
        }
        if (!confirm("您确定要删除选择的数据吗？")){
          return false;
        }

        for(var i=0;i<this.doccheckedRows.length;i++){
          var doccheckedRowIndex = this.doccheckedRows[i];
          this.docfacilities = $.grep(this.docfacilities,function (docfacility,j) {
            return j != doccheckedRowIndex;
          });
        }
        this.doccheckedRows = [];
      },
    }
  }
</script>

<style scoped>

</style>
