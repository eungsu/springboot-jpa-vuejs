<template>
  <main class="mt-3">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-5 border p-3 shadow-sm">게시글 리스트</h1>
      </div>
    </div>
    <List :postsList="postsList"/>
  </main>
</template>

<script>
import PostsService from '../../services/PostsService'
import List from '../../components/List.vue'

export default {
  name: "PostsList",
  components: {
    List
  },
  data() {
    return {
      postsList: []
    }
  },
  created() {
    PostsService.findAll()
      .then(response => {
        if (response.data.success) {
          this.postsList = response.data.items;
        }
      })
  }
}
</script>

<style>

</style>