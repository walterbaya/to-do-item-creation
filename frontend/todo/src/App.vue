<template>
  <div>
    <TodoItemContainer></TodoItemContainer>
  </div>

</template>

<script>

import TodoItemContainer from "./components/TodoItemContainer.vue"


export default {
  name: 'App', 
  components: {
    TodoItemContainer
  }
}
</script>

