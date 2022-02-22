<template>
  <div class="col-12">
    <form class="form-inline">
      <div class="custom-control custom-checkbox my-1 mr-sm-2">
        <input
          type="checkbox"
          class="custom-control-input"
          v-bind:checked="item.checked"
        />
        <label class="custom-control-label mx-3" for="customControlInline">{{
          item.name
        }}</label>
        <button type="submit" class="btn btn-outline-primary btn-sm my-1">
          Edit
        </button>
      </div>
    </form>
  </div>
</template>

<script>

export default {
  name: "TodoItem",
  props: {
    item: Object
  }
};
</script>