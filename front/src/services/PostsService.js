import axios from 'axios';

const http = axios.create({
  baseURL: 'http://localhost/api/v1',
  withCredentials: false,
  headers: {
    Accept: 'application/json',
    'Content-Type': 'application/json'
  }
});

export default {
  save(posts) {
    return http.post('/posts', posts);
  },
  findAll() {
    return http.get("/posts");
  },
  findById(id) {
    return http.get(`/posts/${id}`)
  },
  delete(id) {
    return http.delete(`/posts/${id}`)
  },
  update(posts) {
    return http.put(`/posts/${posts.id}`, posts);
  }

}
