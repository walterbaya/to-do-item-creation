<template>
  <div class="col-12">
    <form class="form-inline">
      <div class="custom-control custom-checkbox my-1 mr-sm-2">
        <input
          type="checkbox"
          class="custom-control-input"
        />
        <label class="custom-control-label mx-3" for="customControlInline">{{
          item.name
        }}</label>
        <router-link to="/TodoItemContainer">View Items</router-link>
        <Button>Remove</Button>
      </div>
    </form>
  </div>
</template>

<script>

export default {
  name: "Folder",
  props: {
    item: Object
  },
  methods: {
    editTask(){
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
  }
};
</script>