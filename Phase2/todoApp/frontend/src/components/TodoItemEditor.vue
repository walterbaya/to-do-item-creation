<template>
  <div class="container">
    <div class="row mt-5">
      <div class="col-12">
        <h1 class="h1">Editing Task</h1>
      </div>
    </div>
    <div class="row mt-3">
      <div class="col-12">
        <form class="d-flex flex-column flex-md-row" action="items">
          <input
            type="text"
            class="form-control w-50 input-sm"
            placeholder="New Task"
            v-model="name"
          />
          <button type="submit" v-on:click.stop.prevent="updateTask()" class="btn btn-outline-primary mx-md-3 mt-3 mt-md-0 w-25">
            Save
          </button>
          <router-link to="/items" class="btn btn-outline-primary mx-md-3 mt-3 mt-md-0 w-25"
            >Cancel</router-link
          >
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "TodoItemEditor",
  props: {
    id: Object,
  },
  methods: {
    updateTask() {
      this.instance
        .put("/api/todo", { id: this.id, name: this.name })
        .then()
        .catch((error) => console.log(error));
        this.$router.push("/items");
    },
  },
  data() {
    return {
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