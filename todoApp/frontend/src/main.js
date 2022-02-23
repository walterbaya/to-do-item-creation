import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import LoginComponent from './components/LoginComponent.vue'
import App from './App.vue'

const routes = [
    {
      path: '/',
      name: 'LoginComponent',
      component: LoginComponent
    },
  ]
  
  const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
  })

createApp(App)
  .use(router)
  .mount('#app')


