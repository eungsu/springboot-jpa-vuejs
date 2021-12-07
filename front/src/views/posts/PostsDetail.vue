<template>
  <main class="mt-3">
    <div class="row mb-3">
      <div class="col">
        <h1 class="fs-5 border p-3 shadow-sm">게시글 상세정보</h1>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col">
        <table class="table table-bordered shadow-sm">
          <tbody>
            <tr>
              <th style="width: 15%;">아이디</th>
              <td style="width: 35%;">{{ posts.id }}</td>
              <th style="width: 15%;">작성자</th>
              <td style="width: 35%;">{{ posts.author }}</td>
            </tr>
            <tr>
              <th>제목</th>
              <td colspan="3">{{ posts.title }}</td>
            </tr>
            <tr>
              <th>등록일</th>
              <td>{{ posts.createdDate }}</td>
              <th>최종 수정일</th>
              <td>{{ posts.modifiedDate }}</td>
            </tr>
            <tr>
              <th>내용</th>
              <td colspan="3">{{ posts.content }}</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="row mb-3">
      <div class="col-6">
        <router-link :to="`/posts/modify/${posts.id}`" class="btn btn-outline-warning me-2">수정</router-link>
        <button @click="deletePosts" class="btn btn-outline-danger">삭제</button>
      </div>
      <div class="col-6 text-end">
        <router-link to="/posts/list" class="btn btn-primary">목록</router-link>
      </div>
    </div>
  </main>
</template>

<script>
import PostsService from '../../services/PostsService'

export default {
  name: "PostsDetail",
  data() {
    return {
      posts: {
        id: '',
        title: '',
        author: '',
        content: '',
        createdDate: '',
        modifiedDate: ''
      }
    }
  },
  methods: {
    deletePosts() {
      PostsService.delete(this.posts.id)
        .then(response => {
          if (response.data.success) {
            this.$router.push('/posts/list');
          }
        })
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
          this.posts = response.data.item;
        }
      })
  } 
}
</script>

<style>

</style>