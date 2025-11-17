<script>
export default {
    data() {
        return {
            name: "",
            email: "",
            password: "",
            confirmPassword: "",
            loading: false
        };
    },
    methods: {
        async register() {
            // Validações
            if (!this.name || !this.email || !this.password || !this.confirmPassword) {
                alert("Por favor, preencha todos os campos.");
                return;
            }

            if (this.password !== this.confirmPassword) {
                alert("As senhas não coincidem.");
                return;
            }

            if (this.password.length < 6) {
                alert("A senha deve ter no mínimo 6 caracteres.");
                return;
            }

            this.loading = true;

            try {
                const response = await fetch('http://localhost:8080/api/v1/auth/register', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        name: this.name,
                        email: this.email,
                        password: this.password
                    })
                });

                if (response.status === 201) {
                    alert("Cadastro realizado com sucesso! Faça login para acessar.");
                    this.$router.push('/login');
                } else if (response.status === 400) {
                    const data = await response.json();
                    alert(data.message || "Erro ao registrar. Verifique os dados.");
                } else if (response.status === 409) {
                    alert("Email já cadastrado no sistema. Tente outro email.");
                } else {
                    alert("Erro ao registrar. Tente novamente.");
                }
            } catch (error) {
                alert("Erro na conexão: " + error.message);
            } finally {
                this.loading = false;
            }
        }
    }
};
</script>
<template>
    <div id="cadastrar">
        <div class="container">
            <form class="cadastrar" @submit.prevent="register">
                <h1>Cadastre-se</h1>
                <div class="input-field">
                    <p class="texto">Digite seu Nome:</p>
                    <div class="input-wrapper">
                        <input type="text" placeholder='Nome' required v-model="name" />
                        <img class="icon" src="../assets/icons/user-solid-full.svg">
                    </div>
                </div>
                <div class="input-field">
                    <p class="texto">Digite seu Email:</p>
                    <div class="input-wrapper">
                        <input type="email" placeholder='E-mail' required v-model="email" />
                        <img class="icon" src="../assets/icons/envelope-solid-full.svg">
                    </div>
                </div>
                <div class='input-field'>
                    <p class="texto">Digite sua Senha:</p>
                    <div class="input-wrapper">
                        <input type="password" placeholder='Senha' required v-model="password" />
                        <img class="icon" src="../assets/icons/lock-solid-full.svg">
                    </div>
                </div>
                <div class='input-field'>
                    <p class="texto">Confirme sua senha:</p>
                    <div class="input-wrapper">
                        <input type="password" placeholder='Confirme sua Senha' required v-model="confirmPassword" />
                        <img class="icon" src="../assets/icons/lock-solid-full.svg">
                    </div>
                </div>
                <div class='input-field'>
                    <button type="submit" :disabled="loading">
                        {{ loading ? 'Registrando...' : 'Cadastrar' }}
                    </button>
                </div>
            </form>
        </div>
    </div>
</template>
<style scoped>
#cadastrar {
    display: flex;
    justify-content: center;
    align-items: flex-start; 
    padding-top: 0%; 
    min-height: 100vh; 
    box-sizing: border-box;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: center;
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

.cadastrar {
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

.cadastrar h1 {
    text-align: center;
    color: #333;
}

.cadastrar .input-field {
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
    font-size: 16px;
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

.cadastrar .recall-forget {
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

.cadastrar button {
    width: 85%;
    padding: 10px;
    border: none;
    border-radius: 10px;
    background-color: var(--secondary-color);
    color: var(--primary-color);
    font-size: 16px;
    cursor: pointer;
}

.cadastrar button:disabled {
    opacity: 0.6;
    cursor: not-allowed;
}

.cadastrar .signup {
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


.cadastrar .signup .signup-link {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
    background-color: var(--secondary-color);
    padding: 5px 10px;
    border-radius: 10px;
}

.cadastrar .signup .signup-link a {
    text-decoration: none;
    color: var(--primary-color);
    margin: 0;
    padding: 0;
}

.cadastrar .signup .signup-link:hover {
    transition: background-color 0.3s ease;
    background-color: var(--primary-bg-color);
}

.cadastrar button[type="submit"]:hover {
    transition: background-color 0.3s ease;
    background-color: var(--primary-bg-color);
}
</style>