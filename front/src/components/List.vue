<template>
  <div class="row mb-3">
    <div class="col">
      <table class="table">
        <thead>
          <tr class="d-flex">
            <th class="col-2">번호</th>
            <th class="col-6">제목</th>
            <th class="col-2">작성자</th>
            <th class="col-2">등록일</th>
          </tr>
        </thead>
        <tbody>
          <tr v-if="!postsList.length" class="d-flex">
            <td class="col-12 text-center">게시글이 없습니다.</td>
          </tr> 
          <tr v-else class="d-flex" v-for="(posts, index) in postsList" :key="index">
            <td class="col-2">{{ posts.id }}</td>
            <td class="col-6"><router-link :to="{name:'PostsDetail', params: {id: posts.id}}">{{ posts.title }}</router-link></td>
            <td class="col-2">{{ posts.author }}</td>
            <td class="col-2">{{ posts.createdDate }}</td>
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