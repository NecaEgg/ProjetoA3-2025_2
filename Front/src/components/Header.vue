<script>
export default {};
</script>

<template>
    <header class="navbar">
        <nav class="nav-container">
            <router-link to="/" class="logo">
                <span class="logo-icon">🛡️</span>
                SafeLine
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
                        <router-link  to="/login" class="nav-button">
                            Login
                        </router-link>
                        <router-link  to="/consultar" class="nav-button-destaque">
                            Consultar Número
                        </router-link>
                    </li>
                </ul>

            </div>
        </nav>
    </header>
</template>

<style>

/* 1. Container Principal da Navbar (a faixa branca) */
.navbar {
    width: 100%;
    height: 60px;
    background-color: var(--secondary-bg-color);
    /* A linha cinza clara na parte de baixo */
    padding: 15px;
    /* 15px de altura, 5% de espaço nas laterais */
    margin: 0;
}

/* 2. Container do Conteúdo (para alinhar tudo) */
.nav-container {
    display: flex;
    /* Joga o .logo para a esquerda e o .nav-right para a direita */
    justify-content: space-between;
    /* Alinha tudo verticalmente no centro */
    align-items: center;

    /* Limita a largura em telas grandes */
    max-width: 1300px;
    margin: 3 auto;
    /* Centraliza o .nav-container */
    height: 100%;
}

/* 3. Estilo do Logo */
.logo {
    display: flex;
    align-items: center;
    text-decoration: none;
    color: #333;
    /* Cor do texto escura */
    font-size: 22px;
    font-weight: 600;
    /* Texto em negrito */
}

.logo-icon {
    /* Cor azul do ícone da imagem */
    color: var(--primary-color);
    font-size: 24px;
    margin-right: 10px;
}

/* 4. Container da Direita (Links + Botão) */
.nav-right {
    display: flex;
    align-items: center;
    /* Espaço entre a lista de links e o botão */
    gap: 30px;
}

/* 5. Lista de Links de Navegação */
.nav-links li {
    display: flex;
    justify-content: center;
    align-items: center;
    list-style: none;
    /* Remove as bolinhas da lista */
    margin: 0;
    padding: 0;
    /* Espaço entre cada item (Início, Sobre, etc.) */
    gap: 30px;
}

/* Efeito ao passar o mouse */
.nav-links a:hover {
    color: var(--primary-color);
    /* Muda para azul */
}

.nav-button {
    text-decoration: none; 
    /* Cor de fundo */
    color: var(--primary-bg-color);
    /* cor do Texto */
    padding: 10px 5px;
    border-radius: 8px;
    /* Bordas arredondadas */
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
    max-height: 90%;
}

.nav-button + .rota-ativa {
    color: var(--secondary-color) !important;
}

/* 6. Botão "Sugerir Instituição" */
.nav-button-destaque {
    text-decoration: none;
    background-color: var(--primary-bg-color);
    /* Cor de fundo */
    color: var(--primary-color);
    /* cor do Texto */
    padding: 5px 10px;
    border-radius: 8px;
    /* Bordas arredondadas */
    font-size: 16px;
    font-weight: bold;
    transition: background-color 0.3s ease;
    /* font-size: 16px;
    line-height: 0.75em; */
}

/* Efeito ao passar o mouse */


.nav-button-destaque:hover {
    background-color: var(--text-color);
}
</style>