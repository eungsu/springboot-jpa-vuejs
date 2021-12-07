<template>
  <main class="mt-3">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-5 border p-3 shadow-sm">게시글 수정폼</h1>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col">
        <div class="border p-3 bg-light shadow-sm">
          <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" v-model="posts.title" placeholder="제목을 입력하세요"/>
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" rows="5" id="content" v-model="posts.content" placeholder="내용을 입력하세요"></textarea>
          </div>
          <div class="mb-3 text-end">
            <router-link :to="`/posts/detail/${posts.id}`" class="btn btn-secondary me-2">취소</router-link>
            <button type="button" class="btn btn-primary" :disabled="!canSubmit" @click="update(posts)">수정</button>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import PostsService from '../../services/PostsService';

export default {
  name: "PostsModifyForm",
  data() {
    return {
      posts: {
        id: '',
        title: '',
        content: ''
      }
    }
  },
  methods: {
    update: function(posts) {
      PostsService.update(posts)
        .then(response => {
          if (response.data.success) {
            this.$router.push(`/posts/detail/${posts.id}`)
          }
        })
    }
  },
  computed: {
    canSubmit() {
      return this.posts.title && this.posts.content;
    }
  }, 
  created() {
    if (!(this.$route.params.id)) {
      this.$router.push("/");
      return;
    }
    PostsService.findById(this.$route.params.id)
      .then(response => {
        if (response.data.success) {
          this.posts = response.data.item
        }
      });
  }
}
</script>

<style>

</style>