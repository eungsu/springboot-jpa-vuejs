<template>
  <div class="row mb-3">
    <div class="col">
      <table class="table">
        <thead>
          <tr>
            <th style="width: 15%;">번호</th>
            <th style="width: 45%;">제목</th>
            <th style="width: 20%;">작성자</th>
            <th style="width: 20%;">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="!postsList.length">
            <td class="text-center" colspan="4">게시글이 없습니다.</td>
          </tr> 
          <tr v-else v-for="(posts, index) in postsList" :key="index">
            <td>{{ posts.id }}</td>
            <td><router-link :to="{name:'PostsDetail', params: {id: posts.id}}">{{ posts.title }}</router-link></td>
            <td>{{ posts.author }}</td>
            <td>{{ posts.createdDate }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
export default {
  name: "List",
  props: ["postsList"]
}
</script>

<style>

</style>