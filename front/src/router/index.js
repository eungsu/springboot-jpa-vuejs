import { createRouter, createWebHistory } from 'vue-router'
import boardRouters from './board'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue')
  },
  ...boardRouters
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
