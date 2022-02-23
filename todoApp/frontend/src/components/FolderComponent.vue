<template>
  <div class="col-12">
    <form class="form flex-row">
      <div class="row custom-control custom-checkbox my-1 mr-sm-2">
        <label class="col-12 col-md-8 custom-control-label border-dark  text-dark" for="customControlInline">- {{
          folder.name
        }}</label>
  
        <router-link
          to="/"
          class=" col-12 col-md-2 align-text-left  py-1"
        >
          View Items
        </router-link>
        <button
          type="submit"
          v-on:click.stop.prevent="removeFolder()"
          class="col-12  col-md-2  align-text-left btn btn-link d-flex flex-start"
        >
          Remove
        </button>
      </div>
    </form>
  </div>
</template>

<script>
export default {
  name: "FolderComponent",
  props: {
    folder: Object,
  },
  methods: {
    removeFolder() {
      this.instance
        .delete("/api/todo/folders", { id: this.id })
        .then()
        .catch((error) => console.log(error));
      this.$router.push("/items");
    },
  },
};
</script>