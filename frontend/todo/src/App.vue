<template>
  <div>{{ info }}
    <TodoItem></TodoItem>
  </div>

</template>

<script>

import TodoItem from "./components/TodoItem.vue";



export default {
  name: 'App', 
  components: {
    TodoItem
  }
}
</script>

