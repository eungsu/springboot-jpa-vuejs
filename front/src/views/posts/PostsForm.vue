<template>
  <main class="mt-3">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-5 border p-3 shadow-sm">게시글 등록폼</h1>
      </div>
    </div>
    <div v-if="isFail" class="row mb-2">
      <div class="col">
        <div class="alert alert-danger" role="alert">
          게시글 등록 중 오류가 발생하였습니다.
        </div>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col">
        <div class="border p-3 bg-light shadow-sm">
          <div class="mb-3">
            <label for="title" class="form-label">제목</label>
            <input type="text" class="form-control" id="title" v-model="title" placeholder="제목을 입력하세요"/>
          </div>
          <div class="mb-3">
            <label for="author" class="form-label">작성자</label>
            <input type="text" class="form-control" id="author" v-model="author" placeholder="작성자를 입력하세요"/>
          </div>
          <div class="mb-3">
            <label for="content" class="form-label">내용</label>
            <textarea class="form-control" rows="5" id="content" v-model="content" placeholder="내용을 입력하세요"></textarea>
          </div>
          <div class="mb-3 text-end">
            <button type="button" class="btn btn-primary" :disabled="!canSubmit" @click="save">등록</button>
          </div>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
import PostsService from '../../services/PostsService'

export default {
  name: "BoardForm",
  data() {
    return {
      isFail: false,
      title: "",
      author: "",
      content: ""
    }
  },
  methods: {
    clearField: function() {
      this.title = "";
      this.author = "";
      this.content = "";
    },
    save: function() {
      var posts = {title: this.title, author: this.author, content: this.content};
      PostsService.save(posts)
        .then((response) => {
          if (response.data.success) {
            this.$router.push('/posts/list');
          } else {
            this.isFail = true;
            this.clearField();
          }
        })
    }
  },
  computed: {
    canSubmit() {
      return this.title && this.author && this.content;
    }
  }
}
</script>

<style>

</style>