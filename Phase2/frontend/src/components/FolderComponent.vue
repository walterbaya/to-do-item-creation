<template>
  <div class="col-12">
    <form class="form flex-row">
      <div class="row custom-control custom-checkbox my-1 mr-sm-2">
        <label
          class="col-12 col-sm-8 custom-control-label border-dark text-dark"
          for="customControlInline"
          >- {{ folder.name }}</label
        >

        <router-link
          class="col-12 col-sm-2 align-text-left align-self-center py-1"
          v-bind:to="{
            name: 'items',
            params: {
              folderId: this.folder.id,
            },
          }"
        >
          View Items
        </router-link>
        <button
          type="submit"
          v-on:click.stop.prevent="removeFolder()"
          class="col-12 col-sm-2 align-text-left btn btn-link d-flex flex-start"
        >
          Remove
        </button>
      </div>
    </form>
  </div>
</template>

<script>
import axios from "axios";

export default {
  name: "FolderComponent",
  props: {
    folder: Object,
  },
  methods: {
    removeFolder() {
      this.instance
        .delete("/api/todo/folders/" + this.folder.id)
        .then()
        .catch((error) => console.log(error))
        .then(() => this.$router.go(this.$route.fullPath));
    },
  },
  data() {
    return {
      info: null,
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