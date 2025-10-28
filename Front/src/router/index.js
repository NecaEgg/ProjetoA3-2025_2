import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    { path : '/', name:'DicasSeguranca', component: () => import('../views/DicasSeguranca.vue') },
    { path : '/login', name:'Login', component: () => import('../views/Login.vue') },
    ]

const router = createRouter({
    history: createWebHistory(),
    routes,
    linkActiveClass: 'rota-ativa'
});

export default router;