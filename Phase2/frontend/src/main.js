import { createApp } from 'vue'
import { createRouter, createWebHistory } from 'vue-router'
import FolderContainer from './components/FolderContainer.vue'
import TodoItemContainer from './components/TodoItemContainer.vue'
import TodoItemEditor from './components/TodoItemEditor.vue'
import App from './App.vue'

const routes = [{
        path: '/',
        name: 'start',
        component: FolderContainer
    },
    {
        path: '/editor',
        name: 'editor',
        component: TodoItemEditor,
        props: true
    },
    {
        path: '/items',
        name: 'items',
        component: TodoItemContainer,
        props: true
    },
    {
        path: '/folders',
        name: 'folders',
        component: FolderContainer
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

createApp(App)
    .use(router)
    .mount('#app')