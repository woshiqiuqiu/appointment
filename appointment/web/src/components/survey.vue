<template>
  <div>
    <div style="width: auto;height: auto;margin:40px 40px">
      <i class="web-font">医好口腔医院</i>
    </div>
    <div class="row">

      <div class="col-md-8">

        <div class="row" style="height: auto;width: auto;margin: 20px 80px">
          <div class="col-md-3">
            <h4 style="margin-left: 10px">医院简介:</h4>
          </div>
          <div class="col-md-9">
            <a>天津市医好口腔医院始建于1947年，是中国中西医结合外科和内镜外科的发源地。是以国家级重点学科、中西医结合临床为平台，以中西医结合急腹症防治和微创技术为特色，以中西医结合外科、中西医结合护理学、脾胃病科、胆胰疾病科、脑病科、急诊科、妇科等国家级重点专科建设项目群为支撑，以中西医结合全科为基础，研究型三级甲等综合医院。

              医院始终恪守“中西合璧 日新月异 德高医粹
              至仁至信”的院训，以优质高效的医疗服务、开展世界前沿水平的临床研究、提供建设规范系统的临床教学体系为目标。是我国最具综合实力的中西医结合医院之一。著名中西医结合外科专家吴咸中院士任名誉院长，王西墨教授任院长。

              1970年底，中西医结合治疗急腹症被确定为全国典型，成为第一个中西医结合临床示范基地；作为内镜、腹腔镜技术的发源地。</a>
          </div>
          <div style="margin-top: 40px">
            <h4 style="margin-left: 30px">地理位置:</h4>

          </div>

          <div class="mapbox">




            <baidu-map :center="center" :zoom="zoom" @ready="handler" style="height:400px;width: 800px" @click="getClickInfo">
              <bm-navigation anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-navigation>
              <bm-map-type :map-types="['BMAP_NORMAL_MAP', 'BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
              <bm-geolocation anchor="BMAP_ANCHOR_BOTTOM_RIGHT" :showAddressBar="true" :autoLocation="true"></bm-geolocation>
              <bm-city-list anchor="BMAP_ANCHOR_TOP_LEFT"></bm-city-list>

            </baidu-map>











          </div>



        </div>

      </div>

      <div class="col-md-4">
        <div style="float:left;margin-top: 100px;width: 1px;height: 800px; background: #000000;"></div>
        <div style="margin-left: 30px;margin-top: 20px">
          <h4>科室介绍:</h4>
          <a>
            门诊部：内科、外科、儿科、妇科、眼科、耳鼻喉科、口腔科、皮肤科、中医科、针灸推拿科、心理咨询室等。
            住院部：呼吸内科、消化内科、泌尿内科、心内科、血液科、内分泌科、神经内科、小儿科、感染科、普外科、骨科、神经外科、肝胆外科、泌尿外科、烧伤科、妇科、产科、血透室、重症监护室等。
            急诊部：内科、外科、妇产科、儿科等。
            药房：门诊药房、急诊药房、住院药房、药房仓库等。
            收费室：门诊收费窗口、住院收费窗口、急诊收费窗口等。
            化验室：生化室、检验室、病理室等。
            放射科：拍片室、CT室、透视室、磁共振室、ECT室等。

          </a>


        </div>

      </div>

    </div>
  </div>
</template>

<script>
  export default {
    name: "survey",
    data() {
      return {
        center: {lng: 0, lat: 0},

        zoom: 16,
      }
    },
    methods: {
      handler({BMap, map}) {
        console.log(BMap, map)
        this.center.lng = 117.305577
        this.center.lat = 39.065843
        this.zoom = this.zoom
      }, getClickInfo(e) {
        console.log(e.point.lng)
        console.log(e.point.lat)
        this.center.lng = e.point.lng
        this.center.lat = e.point.lat

      }
    }

  }
</script>

<style scoped>
  @font-face {
    font-family: 'webfont';
    font-display: swap;
    src: url('../css/webfont.eot'); /* IE9 */
    src: url('../css/webfont.eot?#iefix') format('embedded-opentype'), /* IE6-IE8 */ url('../css/webfont.woff2') format('woff2'),
    url('../css/webfont.woff') format('woff'), /* chrome、firefox */ url('../css/webfont.ttf') format('truetype'), /* chrome、firefox、opera、Safari, Android, iOS 4.2+*/ url('../css/webfont.svg#webfont') format('svg'); /* iOS 4.1- */
  }

  .web-font {
    font-family: "webfont" !important;
    font-size: 30px;
    font-style: normal;
    padding-left: 20px;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
  }
  .mapbox{
    margin-left: 60px;
    margin-top: 30px;
    width: 900px;
    height: 400px;
  }
</style>
