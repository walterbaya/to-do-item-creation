<template>
  <div class="container">
    <div class="row mt-5">
      <div class="col-12">
        <h1 class="h1">Editing Task {{item.name}}</h1>
      </div>
    </div>
    <div class="row">
      <div class="col-12">
        <form class="form-inline d-flex" @submit.prevent="addTask">
          <input
            type="text"
            class="form-control w-25 input-sm"
            placeholder="New Task"
            v-model="name"
          />
          <button type="submit" class="btn btn-primary mx-3">Save</button>
          <router-link to="/TodoItemContainer" type="submit" class="btn btn-primary mx-3">Cancel</router-link>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import TodoItem from "./TodoItem.vue";

export default {
  name: "TodoItemEditor",
  components: {
    TodoItem,
  },
  updated() {
    console.log(this.info.row);
  },
  methods: {
    updateTask() {
      this.instance
        .put("/api/todo", {name: this.name, completed: false})
        .then((response) => {
          this.items.push({
            id: response.data.id,
            name: response.data.name,
            checked: response.data.completed,
          });
        })
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      info: null,
      items: [],
      instance: axios.create({
        headers: {
          "Access-Control-Allow-Origin": "*",
        },
        baseURL: "http://localhost:8080",
      }),
    };
  },
};
</script>