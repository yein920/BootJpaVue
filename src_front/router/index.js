import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: () => import('@/components/Login.vue')
    },
    {
      path: '/Loginfail',
      name: 'fail',
      component: () => import('@/components/LoginFail.vue')
    },
    {
      path: '/LoginSuccess',
      name: 'success',
      component: ()=> import('@/components/LoginSuccessNdelete.vue')
    }
  ]
})
