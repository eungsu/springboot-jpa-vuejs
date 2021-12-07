export default [
  {
    path: "/posts/form",
    name: "PostsForm",
    component: () => import('../views/posts/PostsForm.vue')
  },
  {
    path: "/posts/list",
    name: "PostsList",
    component: () => import('../views/posts/PostsList.vue')
  },
  {
    path: "/posts/detail/:id",
    name: "PostsDetail",
    component: () => import('../views/posts/PostsDetail.vue')
  },
  {
    path: '/posts/modify/:id',
    name: "PostsModifyForm",
    component: () => import('../views/posts/PostsModifyForm.vue')
  }
]