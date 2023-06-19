import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    component: () => import('@/layouts/home/Layout.vue'),
    children: [
      {
        path: '',
        name: 'Home',
        component: () => import('@/views/home/Home.vue'),
      },
      {
        path: 'essay',
        name: 'Essay',
        component: () => import('@/views/home/Essay.vue'),
        // 文章id参数
        props: true,
      },
      {
        path: 'idea',
        name: 'Idea',
        component: () => import('@/views/home/Idea.vue'),
      },
    ],
  },
  {
    path: '/auth',
    component: () => import('@/layouts/auth/Layout.vue'),
    children: [
      {
        path: 'login',
        name: 'Login',
        component: () => import('@/views/auth/Login.vue'),
      },
      {
        path: 'register',
        name: 'Register',
        component: () => import('@/views/auth/Register.vue'),
      },
    ]
  },
  {
    path: '/admin',
    component: () => import('@/layouts/admin/Layout.vue'),
    children: [
      {
        path: '',
        name: 'Dashboard',
        component: () => import('@/views/admin/Dashboard.vue'),
      },
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
