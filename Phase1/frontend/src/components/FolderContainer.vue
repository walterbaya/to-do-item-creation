<template>
  <div class="container">
    <div class="row mt-5">
      <div class="col-12">
        <h1 class="h1">Folders</h1>
      </div>
    </div>
    <div class="row my-1" v-for="folder in folders" v-bind:key="folder.id">
      <FolderComponent v-bind:folder="folder"></FolderComponent>
    </div>
    <div class="row">
      <div class="col-12">
        <form class="form-inline d-flex" @submit.prevent="addTask">
          <input
            type="text"
            class="form-control w-25 input-sm"
            placeholder="New Folder"
            v-model="folderName"
          />
          <button type="submit" class="btn btn-primary mx-3">Add</button>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import FolderComponent from "./FolderComponent.vue";

export default {
  name: "FolderContainer",
  components: {
    FolderComponent
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