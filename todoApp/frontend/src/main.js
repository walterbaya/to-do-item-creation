import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import LoginComponent from './components/LoginComponent.vue'
import FolderContainer from './components/FolderContainer.vue'
import TodoItemContainer from './components/TodoItemContainer.vue'
import TodoItemEditor from './components/TodoItemEditor.vue'

import App from './App.vue'

const routes = [
    {
      path: '/',
      name: 'LoginComponent',
      component: LoginComponent
    },
    {
        path: '/Folders',
        name: 'FolderContainer',
        component: FolderContainer
      },
      {
        path: '/Items',
        name: 'TodoItemContainer',
        component: TodoItemContainer
      },
      {
        path: '/ItemEditor',
        name: 'TodoItemEditor',
        component: TodoItemEditor
      },
  ]
  
  const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
  })

createApp(App)
  .use(router)
  .mount('#app')


