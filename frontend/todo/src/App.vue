<template>
  <div>{{ info }}</div>
</template>

<script>
import axios from 'axios';




export default {
  name: 'App',
  mounted() {
    const instance = axios.create({
      headers: {
        'Access-Control-Allow-Origin': '*',
      },
      baseURL: 'http://localhost:8080'
    });
    
    instance.post('/humanPlay', { 'row': 1, 'col': 1 })
      .then(response => (this.info = response.data))
      .catch(error => console.log(error))
  }, 
  updated(){
    console.log(this.info.row);
  },
  data() {
    return {
      info: null,
      circle: "circle",
      cross: "cross"
    }
  },
}
</script>

