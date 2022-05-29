<template>
  <div class="container">
    <div class="row my-4">
      <div class="col-12">
        <h1 class="h1">Todo List</h1>
      </div>
    </div>
    <div class="row" v-for="item in items" v-bind:key="item.id">
      <TodoItem v-bind:item="item[1]" v-bind:folder_id="folderId"></TodoItem>
    </div>
    <div class="row mt-4">
      <div class="col-12">
        <form class="form-inline d-flex mb-5" @submit.prevent="addItem">
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
    folderId: String,
  },

  created() {
    this.getAllItems();
    this.getFolder();
  },

  methods: {
    addItem() {
      //Add item
      this.instance
        .post("/api/todo", {
          name: this.name,
          completed: false,
          folder: this.folder,
        })
        .then((response) => {
          let element = response.data;
          this.items.set(element.id, {
            id: element.id,
            name: element.name,
            completed: element.completed,
          });
        })
        .catch((error) => console.log(error));

      //update items in folder
      this.instance
        .put("/api/todo/folders/" + this.folderId, {
          id: this.folder.id,
          name: this.folder.name,
          items: this.items[1]
        })
        .then((response) => (console.log(response.data)));
    },
    getAllItems() {
      this.instance
        .get("/api/todo/folders/" + this.folderId)
        .then((response) => {
          response.data.items.forEach((element) => {
            this.items.set(element.id, {
              id: element.id,
              name: element.name,
              completed: element.completed,
            });
          });
        })
        .catch((error) => console.log(error));
    },
    getFolder() {
      this.instance
        .get("/api/todo/folders/" + this.folderId)
        .then((response) => this.folder = response.data)
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      info: null,
      items: new Map(),
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