<script>
export default {
    methods: {
        logout(){
            localStorage.removeItem('token');
            //remove access_token and refresh_token from cookies
            function removeCookie(tabs) {
                let removing = browser.cookies.remove({
                url: tabs[0].url,
                name: "favorite-color",
            });

            let getActive = browser.tabs.query({ active: true, currentWindow: true });
            getActive.then(removeCookie);

            window.location.href = '/login';
            }
        }
    }
};
</script>

<template>
    <header class="navbar">
        <nav class="nav-container">
            <router-link to="/" class="logo">
                <img src="/safeline.png" alt="Logo SafeLine">
            </router-link>

            <div class="nav-right">

                <ul class="nav-links">
                    <li>
                        <router-link  to="/numoficial" class="nav-button">
                            Números Oficiais
                        </router-link>
                        <router-link  to="/estatistica" class="nav-button">
                            Estatísticas
                        </router-link>
                        <router-link  to="/denunciar" class="nav-button">
                            Denunciar
                        </router-link>
                        <router-link  to="/consultar" class="nav-button-destaque">
                            Consultar Número
                        </router-link>
                        <a class="nav-button" @click="logout">
                            Logout
                        </a>
                    </li>
                </ul>

            </div>
        </nav>
    </header>
</template>

<style>

.navbar {
    width: 100%;
    height: 60px;
    background-color: var(--secondary-bg-color);
    padding: 15px;
    margin: 0;
}

.nav-container {
    display: flex;
    justify-content: space-between;
    align-items: center;
   /* max-width: 1300px;
    margin: auto;*/
    height: 100%;
}

.logo {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: #333;
    font-size: 22px;
    font-weight: 600;
}

.logo img {
    height: 30px;
    width: auto;
    display: block;
}

.nav-right {
    display: flex;
    align-items: center;
    gap: 30px;
}

.nav-links li {
    display: flex;
    justify-content: center;
    align-items: center;
    list-style: none;
    margin: 0;
    padding: 0;
    gap: 30px;
}

.nav-links a:hover {
    color: var(--primary-color);
}

.nav-button {
    text-decoration: none; 
    color: var(--primary-bg-color);
    padding: 10px 5px;
    border-radius: 10px;
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
    max-height: 90%;
    cursor: pointer;
}

.nav-button.rota-ativa {
    color: var(--primary-color) !important;
}

.nav-button-destaque {
    text-decoration: none;
    background-color: var(--secondary-color);
    color: var(--primary-color);
    padding: 5px 10px;
    border-radius: 8px;
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
}
.nav-button-destaque:hover {
    background-color: var(--text-color);
}
</style>