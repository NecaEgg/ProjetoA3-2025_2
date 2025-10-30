<script>
export default {};
</script>
<template>
    <div id="denunciar">
        <div class="container">
            <h1 class="header-text">Ajude a combater fraudes - Denuncie uma Ligação suspeita!</h1>
            <form class="denunciar">
                <div class="input-field">
                    <p class="texto"> Número de Telefone do Golpista</p>
                    <input type="tel" placeholder='(XX) XXXXX-XXXX' required />

                </div>
                <div class="input-field">
                    <p class="texto"> Data da Ligação e Hora Aproximada da Ligação</p>
                    <input type="datetime-local" required />

                </div>
                <div class="input-field">
                    <label class="texto" for="empresa-select">Suposta Empresa ou Instuição</label>
                    <select id="empresa-select" name="instituicao" required>
                        <option value="" disabled selected>-- Selecione uma instituição --</option>

                        <option value="banco-do-brasil">Banco do Brasil</option>
                        <option value="bradesco">Bradesco</option>
                        <option value="caixa">Caixa Econômica Federal</option>
                        <option value="itau">Itaú</option>
                        <option value="santander">Santander</option>
                        <option value="nubank">Nubank</option>
                        <option value="banco-inter">Banco Inter</option>
                        <option value="c6-bank">C6 Bank</option>
                        <option value="mercado-pago">Mercado Pago</option>
                        <option value="picpay">PicPay</option>
                        <option value="banco-pan">Banco Pan</option>
                        <option value="bmg">BMG</option>
                        <option value="outro-banco">Outra Instituição Financeira (Não listada)</option>
                    </select>
                </div>
                <div class='input-field'>
                    <label class="texto" for="descricao-golpe">Descreva o que aconteceu (detalhes da ligação)</label>
                    <textarea style="resize: none" id="descricao-golpe" rows="5"
                        placeholder='Forneça o máximo de detalhes possível, como o que foi dito, se pediram informações pessoais, etc'
                        required>
                    </textarea>
                </div>
                <div class='input-field'>
                    <button type="submit">Denunciar</button>
                </div>
                <!-- <div class='recall-forget'>
                    <a href="#">Esqueci minha senha</a>
                </div>
                <div class="signup">
                    <p>
                        Ainda não tem uma conta?
                    </p>
                    <div class="signup-link">
                        <a href="#">Cadastre-se</a>
                    </div> 
                </div> -->
            </form>
        </div>
    </div>
</template>
<style>
#denunciar {
    display: flex;
    justify-content: center;
    align-items: flex-start; 
    padding-top: 0%; 
    min-height: 100vh; 
    box-sizing: border-box;
}

.header-text {
    text-align: center;
    margin-bottom: 20px;
    color: #ffffff;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    /* Mudar isso para paginas que nao e o denunciar (flex-start)*/
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


.denunciar {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 1000px;
    background-color: var(--secondary-bg-color);
    padding: 40px;
    border-radius: 10px;
    height: max-content;
}

.denunciar h1 {
    text-align: center;
    color: #333;
}

.denunciar .input-field {
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
}

.denunciar button {
    width: 85%;
    padding: 10px;
    border: none;
    border-radius: 10px;
    background-color: var(--primary-bg-color);
    color: var(--primary-color);
    font-size: 16px;
    cursor: pointer;
}

</style>