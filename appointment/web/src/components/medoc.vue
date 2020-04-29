<template>

  <div class="bkg row" id="mecdoc">
    <div style=" width:auto;height:auto;margin:0 auto">
      <a style="font-size: 25px">药品信息</a>
    </div>
    <div class="row mx-auto w-75" style="height: 15px"></div>
    <div class="row mx-auto w-75">
      <div class="col-6">
        <div class="btn-group">
          <button type="button" class="btn btn-outline-info btn-sm" data-toggle="modal" data-target="#myModal">新增</button>
          <button type="button" class="btn btn-outline-primary btn-sm" @click="saveRows">保存</button>
        </div>
        <button type="button" class="btn btn-outline-warning btn-sm" @click="delRows">删除</button>
      </div>
      <div class="col-6">
        <div class="input-group">
          <input type="text" class="form-control input-group-sm" placeholder="输入药品编号进行搜索">
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
            <th>  </th>
            <th>序号</th>
            <th>药品编号</th>
            <th>药品名称</th>
            <th>药品库存</th>
            <th>药品价格</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="(facility,index) in facilities">
            <td><input type="checkbox" :value="index" v-model="checkedRows"></td>

            <td>{{index+1}}</td>
            <td>{{facility.mecnum}}</td>
            <td>{{facility.mecname}}</td>
            <td>{{facility.mecnumber}}</td>
            <td>{{facility.mecprice}}</td>
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
            <h4 class="modal-title">新增药品信息</h4>
            <button type="button" class="close" data-dismiss="modal">&times;</button>
          </div>
          <div class="modal-body">
            <div class="row">
              <div class="col-3">药品编号：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品编号" v-model="newRow.mecnum">
              </div>
            </div>
            <div class="row">
              <div class="col-3">药品名称：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品名称" v-model="newRow.mecname">
              </div>
            </div>
            <div class="row">
              <div class="col-3">药品库存：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品库存" v-model="newRow.mecnumber">
              </div>
            </div>
            <div class="row">
              <div class="col-3">药品价格：</div>
              <div class="col-9">
                <input class="form-control" placeholder="药品价格" v-model="newRow.mecprice">
              </div>
            </div>

          </div>
          <div class="modal-footer">
            <button type="button" class="btn btn-outline-primary" data-dismiss="modal" @click="addRow">确认</button>
          </div>
        </div>
      </div>
    </div>
  </div>



</template>

<script>
import  mecdata from '../data/mecdatas'
let mecdatas = mecdata.datas


export default {
    name: 'nurse',

    data () {
      return {
        checkAll: false,
        checkedRows: [],
        facilities: mecdatas,
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

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

  .bkg{
    background-color: #eeee;
    width: 100%;
    height: auto;
    margin: 0 auto;

  }
  .background{
    background: #eee ;
    opacity: 0.8;
    max-width: 70vw;
    margin: 0 auto;
    padding: 20px 0;
  }



</style>
