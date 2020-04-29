import Vue from 'vue'
import Router from 'vue-router'
import home from '../components/home'
import survey from '../components/survey'
import surveys from '../components/survey-s'
import  calluss from '../components/callus-s'
import newss from  '../components/news-s'
import keshis from '../components/keshi-s'
import phone from '../components/callusss/phone'
import email from  '../components/callusss/email'
import local from '../components/callusss/local'
import qq from '../components/callusss/qq'
import appointment from '../components/appointment'
import appointmentmain from '../components/appointmentmain'
import  register from '../components/register'
import login from '../components/login'
import  admink from '../components/admink'
import doc from '../components/doc'
import medoc from '../components/medoc'
import jiaohao from '../components/jiaohao'
import keshiinfo from '../components/maxadmink/keshiinfo'
import workerinfo from '../components/maxadmink/workerinfo'
import yaopininfo from '../components/maxadmink/yaopininfo'
import keshiadmin from '../components/keshiadmin'
import future7doc from  '../components/keshiadmin/future7doc'
import future7yuyue from  '../components/keshiadmin/future7yuyue'
import usrlogin from '../components/usrlogin'
import workerlogin from '../components/workerlogin'
import  chufang from '../components/docm/chufang'
import jiaohaodoc from  '../components/docm/jiaohaodoc'
import nurse from '../components/nurse'



Vue.use(Router);

export default new Router({
  routes: [

    {path:'/',name:'homelink',redirect:'/calluss',component:home,children:[
        {path:'/calluss',name:'callusslink',redirect:'/local',component:calluss,children:[
            {path:'/phone',name:'phonelink',component:phone},
            {path:'/local',name:'locallink',component:local},
            {path:'/qq',name:'qqlink',component:qq},
            {path:'/email',name:'emaillink',component:email},

          ]},
        {path:'/newss',name:'newsslink',component:newss},
        {path:'/keshis',name:'keshislink',component:keshis},
        {path:'/surveys',name:'surveyslink',component:surveys}
      ]},
    {path:'/survey',name:'surveylink',component:survey},
    {path:'/appointment',name:'appointmentlink',component:appointment},
    {path:'/appointmentmain',name:'appointmentmainlink',component:appointmentmain,
      // beforeEnter:(to,from,next)=>{
      //   // 路由独享
      //   alert("您还没有登陆，不能使用此功能");
      //   next(false )
      //   // 判断
      //   store.gettes.isLogin ===false
      //   if(to.path =='/login' || to.path == '/patient'){
      //     next();
      //   }else {
      //     alert("还没有登陆，请先登陆！");
      //     next('/login');
      //   }
      // }
     },
    {path:'/patient',name:'registerlink',component:register},
    {path:'/login',name:'loginlink',component:login},
    {path:'/admink',name:'adminklink',redirect:'/workerinfo',component:admink,children:[
            {path:'/keshiinfp',name:'keshiinfolink',component:keshiinfo},
        {path:'/workerinfo',name:'workerinfolink',component:workerinfo},
        {path:'/yaopininfo',name:'yaopininfolink',component:yaopininfo},
      ]},
    {path:'/doc',name:'doclink',component:doc,redirect:'/jiaohaodoc',children:[
        {path:'/jiaohaodoc',name:'jiaohaodoclink',component:jiaohaodoc},
        {path:'/chufang',name:'chufanglink',component:chufang},







      ]},
    {path:'/medoc',name:'medoclink',component:medoc},
    {path:'/jiaohao',name:'jiaohaolink',component:jiaohao},
    {path:'/keshiadmin',name:'keshiadminlink',redirect:'/future7yuyue',component:keshiadmin,children:[
        {path:'/future7yuyue',name:'future7yuyuelink',component:future7yuyue},
        {path:'/future7doc',name:'future7doclink',component:future7doc},
      ]},
    {path:'/usrlogin',name:'usrloginlink',component:usrlogin},
    {path:'/workerlogin',name:'workerloginlink',component:workerlogin},
    {path:'/nurse',name:'nurselink',component:nurse},











    {path: '*', redirect: '/'}, //如果用户输错路由，默认跳入主页




  ]
})
