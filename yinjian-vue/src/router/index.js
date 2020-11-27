import Vue from 'vue'
import Router from 'vue-router'
import IndexPage from '@/views/indexPage'
import Login from '@/views/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'login',
      component: Login
    },
    {
      path: '/main',
      name: 'indexPage',
      component: IndexPage
    }
  ]
})
