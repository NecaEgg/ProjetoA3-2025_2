import { createRouter, createWebHistory } from 'vue-router';

const routes = [
    { path : '/', name:'DicasSeguranca', component: () => import('../views/DicasSeguranca.vue') },
    { path : '/login', name:'Login', component: () => import('../views/Login.vue') },
    { path : '/cadastrar', name:'Cadastrar', component: () => import('../views/Cadastrar.vue') },
    { path : '/denunciar', name:'Denunciar', component: () => import('../views/Denunciar.vue') },
    { path : '/numoficial', name:'NumOficial', component: () => import('../views/NumOficial.vue') },
    { path : '/estatistica', name:'Estatistica', component: () => import('../views/Estatistica.vue') },
    { path : '/consultar', name:'Consultar', component: () => import('../views/Consultar.vue') },
    ]

const router = createRouter({
    history: createWebHistory(),
    routes,
    linkActiveClass: 'rota-ativa'
});

const signedRoutes = ['Denunciar'];
router.beforeEach((to, from, next) => {
    const token = localStorage.getItem('token'); 
    if (signedRoutes.includes(to.name)) {
        if (!token) {
            next({ name: 'Login' });
        } else {
            next();
        }
    }
    else {
        next();
    }
})

export default router;