import { createRouter, createWebHistory } from 'vue-router'
import postsRoutes from './posts'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue')
  },
  ...postsRoutes
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
