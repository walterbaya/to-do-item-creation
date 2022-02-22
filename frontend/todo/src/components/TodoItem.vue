<template>
  <div class="container">
    <div class="row">
      <div class="col-12">
        <form class="form-inline">
          <div class="custom-control custom-checkbox my-1 mr-sm-2">
            <input type="checkbox" class="custom-control-input">
            <label class="custom-control-label mx-5" for="customControlInline">{{text}}</label>
            <button type="submit" class="btn btn-outline-primary btn-sm my-1">Edit</button>
          </div>
        </form>
      </div>
    </div>
  </div>
</template>

<script>
import axios from 'axios';




export default {
  name: 'TodoItem',
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
      text: "Buy Groceries",
      checked: false
    }
  },
}
</script>