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
    path: "/posts/detail",
    name: "PostsDetail",
    component: () => import('../views/posts/PostsDetail.vue')
  }
]