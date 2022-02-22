<template>
  <div class="container">
    <div class="row mt-5">
      <div class="col-12">
        <h1 class="h1">Todo List</h1>
      </div>
    </div>
    <div class="row my-5" v-for="item in items" v-bind:key="item.id">
      <TodoItem v-bind:item="item"></TodoItem>
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
          <button type="submit" class="btn btn-primary mx-3">Add</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import TodoItem from "./TodoItem.vue";

export default {
  name: "TodoItemContainer",
  components: {
    TodoItem,
  },
  updated() {
    console.log(this.info.row);
  },
  methods: {
    addTask() {
      this.instance
        .post("/api/todo", {name: this.name, completed: false})
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