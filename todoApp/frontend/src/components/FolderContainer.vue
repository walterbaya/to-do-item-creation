<template>
  <div class="container">
    <div class="row mt-5">
      <div class="col-12">
        <h1 class="h1 mb-5">Folders</h1>
      </div>
    </div>
    <div class="row my-1" v-for="folder in folders" v-bind:key="folder.id">
      <FolderComponent v-bind:folder="folder"></FolderComponent>
    </div>
    <div class="row mt-5">
      <div class="col-12">
        <form class="form-inline d-flex" @submit.prevent="addFolder">
          <input
            type="text"
            class="form-control w-75 input-sm"
            placeholder="New Folder"
            v-model="folderName"
          />
          <button type="submit" class="btn btn-primary mx-3">Add</button>
        </form>
      </div>
    </div>
    {{this.folders}}
  </div>
</template>

<script>
import axios from "axios";
import FolderComponent from "./FolderComponent.vue";

export default {
  name: "FolderContainer",
  components: {
    FolderComponent,
  },
  created() {
    this.getAllFolders();
  },
  updated() {
    this.getAllFolders();
  },
  methods: {
    addFolder() {
      this.instance
        .post("/api/todo/folders", { name: this.folderName })
        .then((response) => {
          console.log("se creo una tabla")
          this.info = response.data;
          this.folders.push({
            id: response.data.id,
            name: response.data.name,
            items: response.data.items,
          });
        })
        .catch((error) => console.log(error));
    },

    getAllFolders() {
      this.instance
        .get("/api/todo/folders")
        .then((response) => {
          this.folders = response.data;
        })
        .catch((error) => console.log(error));
    },
  },
  data() {
    return {
      info: null,
      folders: [],
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