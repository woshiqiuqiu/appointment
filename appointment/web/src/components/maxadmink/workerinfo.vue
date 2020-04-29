<template>

  <div class="container" id="admink-doc" >

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
          <input type="text" class="form-control input-group-sm" placeholder="输入医生姓名进行搜索">
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
            <th>工作编号</th>
            <th>工作密码</th>
            <th>员工姓名</th>
            <th>员工性别</th>
            <th>员工年龄</th>
            <th>工作科室</th>
            <th>职位</th>


          </tr>
          </thead>
          <tbody>
          <tr v-for="(docfacility,index) in docfacilities">
            <td><input type="checkbox" :value="index" v-model="doccheckedRows"></td>
            <td>{{index+1}}</td>
            <td>{{docfacility.docid}}</td>
            <td>{{docfacility.docpsw}}</td>
            <td>{{docfacility.docname}}</td>
            <td>{{docfacility.docgender}}</td>
            <td>{{docfacility.docage}}</td>
            <td>{{docfacility.docoffice}}</td>
            <td>{{docfacility.doccarrer}}</td>


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
            <h4 class="modal-title">新增医生信息</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-3">工作编号：</div>
              <div class="col-9">
                <input class="form-control" placeholder="工作编号" v-model="docnewRow.docid">
              </div>
            </div>
            <div class="row">
              <div class="col-3">工作密码：</div>
              <div class="col-9">
                <input class="form-control" placeholder="工作密码" v-model="docnewRow.docpsw">

              </div>
            </div>
            <div class="row">
              <div class="col-3">员工姓名：</div>
              <div class="col-9">
                <input class="form-control" placeholder="员工姓名" v-model="docnewRow.docname">
              </div>
            </div>
            <div class="row">
              <div class="col-3">员工性别：</div>
              <div class="col-9">
                <input class="form-control" placeholder="员工性别" v-model="docnewRow.docgender">
              </div>
            </div>
            <div class="row">
              <div class="col-3">员工年龄：</div>
              <div class="col-9">
                <input class="form-control" placeholder="员工年龄" v-model="docnewRow.docage">
              </div>
            </div>
            <div class="row">
              <div class="col-3">工作科室：</div>
              <div class="col-9">
                <input class="form-control" placeholder="工作科室" v-model="docnewRow.docoffice">
              </div>
            </div>
            <div class="row">
              <div class="col-3">职位：</div>
              <div class="col-9">
                <input class="form-control" placeholder="员工职位" v-model="docnewRow.doccarrer">
              </div>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-outline-primary" data-dismiss="modal" @click="adddocRow">确认</button>
            </div>
          </div>

        </div>


    </div>

    </div>
    </div>




</template>

<script>
  import docdata from '../../data/docdatas'
  let docdatas=docdata.datas;
    export default {
        name: "workerinfo",
      data(){
          return{
            doccheckAll: false,
            doccheckedRows: [],
            docfacilities: docdatas,
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
