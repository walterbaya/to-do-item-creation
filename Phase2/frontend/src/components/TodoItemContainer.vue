<template>
  <div class="container">
    <div class="row my-4">
      <div class="col-12">
        <h1 class="h1">Todo List</h1>
      </div>
    </div>
    <div class="row" v-for="item in items" v-bind:key="item.id">
      <TodoItem v-bind:item="item"></TodoItem>
    </div>
    <div class="row mt-4">
      <div class="col-12">
        <form class="form-inline d-flex mb-5" @submit.prevent="addTask">
          <input
            type="text"
            class="form-control w-75 input-sm"
            placeholder="New Task"
            v-model="name"
          />
          <button type="submit" class="btn btn-primary mx-3">Add</button>
        </form>
      </div>
    </div>
    {{ this.folder }}
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
  props: {
    folderId: Number,
  },

mounted() {
    //this.getAllItems();
    //this.getFolder();
},

  methods: {
    addTask() {
      //Add task
      this.instance
        .post("/api/todo", {
          name: this.name,
          completed: false,
          folder: this.folder,
        })
        .then((response) => {
          if(this.items == undefined){
            this.items = [response.data];
          }
          else{
            this.items.push(response.data);
          }
        })
        .catch((error) => console.log(error));

      //this.getFolder();
      
      //update items in folder
      this.instance
        .put("/api/todo/folders/" + this.folderId, {
          items: this.items,
        })
        .then((response) => this.folder = response.data);
        console.log(this.folderId)
    },
    getAllItems() {
      this.instance
        .get("/api/todo/folders/" + this.folderId)
        .then((response) => {
          this.items = response.data.items;
        })
        .catch((error) => console.log(error));
    },
    getFolder() {
      this.instance
        .get("/api/todo/folders/" + this.folderId)
        .then((response) => {this.folder = response.data;
        this.items = response.data.items;})
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      info: null,
      items: [],
      folder: null,
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