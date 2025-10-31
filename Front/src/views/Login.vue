<script>
export default {};
</script>
<template>
    <div id="login">
        <div class="container">
            <form class="login">
                <h1>Acesse sua conta</h1>
                <div class="input-field">
                    <p class="texto"> Digite seu Email:</p>
                        <div class="input-wrapper">
                            <input type="email" placeholder='E-mail' required />
                            <img class="icon" src="../assets/icons/user-solid-full.svg">
                        </div>
                </div>
                <div class='input-field'>
                    <p class="texto"> Digite sua Senha:</p>
                        <div class="input-wrapper">
                            <input type="password" placeholder='Senha' required />
                            <img class="icon" src="../assets/icons/lock-solid-full.svg">
                        </div>
                </div>
                <div class='input-field'>
                    <button type="submit">Entrar</button>
                </div>
                <div class='recall-forget'>
                    <a href="#">Esqueci minha senha</a>
                </div>
                <div class="signup">
                    <p>
                        Ainda não tem uma conta?
                    </p>
                    <div class="signup-link">
                        <a href="#">Cadastre-se</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
</template>
<style>
#login {
    display: flex;
    justify-content: center;
    align-items: center;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
    /* Mudar isso para paginas que nao e o login (flex-start)*/
    align-items: center;
    width: 100%;
    height: 100%;
}

.container .texto {
    font-weight: bold;
    width: 100%;
    display: flex;
    font-size: 16px;
    color: var(--text-color);
    margin-bottom: 1px;
}

.login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 400px;
    background-color: var(--secondary-bg-color);
    padding: 40px;
    border-radius: 10px;
    height: max-content;
}

.login h1 {
    text-align: center;
    color: #333;
}

.login .input-field {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    margin-bottom: 20px;
    width: 100%;
    margin: margin-bottom;
}

.input-field input {
    outline: none;
    width: 100%;
    height: 100%;
    padding: 10px 35px;
    border: none;
    border-radius: 10px;
    background-color: var(--primary-color);
    font-size: 16px;
    color: var(--text-color);
    box-sizing: border-box; 
}
.input-wrapper {
    position: relative;
    width: 100%; 
    font-size: 16px; /* <-- CONTROLA O TAMANHO DA FONTE E DO ÍCONE */
}

.input-field .icon {
    position: absolute;
    top: 50%;
    left: 10px;
    transform: translateY(-50%);
    color: #666;
    width: 16px;
    height: 16px;
}

.login .recall-forget {
    display: flex;
    justify-content: space-between;
    margin-bottom: 30px;
    margin: auto;
}

.recall-forget a {
    font-size: 14px;
    color: var(--text-color);
    text-decoration: none;
    padding: 10px 1px;
}

.recall-forget a:hover {
    text-decoration: underline;
}

.login button {
    width: 85%;
    padding: 10px;
    border: none;
    border-radius: 10px;
    background-color: var(--secondary-color);
    color: var(--primary-color);
    font-size: 16px;
    cursor: pointer;
}

.login .signup {
    text-align: center;
    color: var(--text-color);
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    padding: 0;
    height: 20px;
    gap: 5px
}


.login .signup .signup-link {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: var(--secondary-color);
    padding: 5px 10px;
    border-radius: 10px;
}

.login .signup .signup-link a {
    text-decoration: none;
    color: var(--primary-color);
    margin: 0;
    padding: 0;
}

.login .signup .signup-link:hover {
    transition: background-color 0.3s ease;
    background-color: var(--secondary-bg-color);
}
</style>