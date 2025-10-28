<script>
export default {};
</script>
<template>
    <div class="container">
        <form class="login">
            <h1>Acesse sua conta</h1>
            <div class="input-field">
                <input type="email" placeholder='E-mail' required />

            </div>
            <div class='input-field'>
                <input type="password" placeholder='Senha' required />

            </div>
            <div class='input-field'>
            <button type="submit">Entrar</button>
            </div>
            <div class='recall-forget'>
                <a href="#">Esqueci minha senha</a>
            </div>
            <div class="signup-link">
                <p>
                    Ainda não tem uma conta? <a href="#">Cadastre-se</a>
                </p>
            </div>
        </form>
    </div>
    

</template>
<style>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
.login {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 400px;
    background-color: #c2c2c2;
    padding: 40px;
    border-radius: 10px;
}

.login h1 {
    text-align: center;
    margin-bottom: 40px;
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
    margin: 30px auto;
}

.input-field input {
    outline: none;
    width: 85%;
    height: 100%;
    padding: 10px 35px;
    border: none;
    border-radius: 10px;
    background-color: #e6e6e6;
    font-size: 16px;
}

.input-field .icon {
    position: absolute;
    top: 50%;
    left: 10px;
    transform: translateY(-50%);
    color: #666;
}

.login .recall-forget {
    display: flex;
    justify-content: space-between;
    margin-bottom: 30px;
    margin: auto;
}

.recall-forget a {
    font-size: 14px;
    color: #333;
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
    background-color: #333;
    color: #fff;
    font-size: 16px;
    cursor: pointer;
}

.login .signup-link {
    text-align: center;
    margin-top: 20px;
}
</style>