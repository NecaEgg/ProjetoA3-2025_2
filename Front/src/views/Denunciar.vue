<script>
export default {};
</script>
<template>
    <div id="denunciar">
        <div class="container">
            <h1 class="header-text">Ajude a combater fraudes - Denuncie uma Ligação suspeita!</h1>
            <form class="denunciar">
                <div class="denunciar-input-field">
                    <p class="texto"> Número de Telefone do Golpista</p>
                    <div class="denunciar-input-wrapper">
                            <input type="tel" placeholder='(XX) XXXXX-XXXX' required />
                            <img class="icon" src="../assets/icons/phone-solid-full.svg">
                        </div>
                    

                </div>
                <div class="denunciar-input-field">
                    <p class="texto"> Data da Ligação e Hora Aproximada da Ligação</p>
                    <input type="datetime-local" required />

                </div>
                <div class="denunciar-input-field">
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
                <div class='denunciar-input-field'>
                    <label class="texto" for="descricao-golpe">Descreva o que aconteceu (detalhes da ligação)</label>
                    <textarea style="resize: none" id="descricao-golpe" rows="5"
                        placeholder='Forneça o máximo de detalhes possível, como o que foi dito, se pediram informações pessoais, etc'
                        required></textarea>
                </div>
                <div class='denunciar-input-field'>
                    <button type="submit">Denunciar</button>
                </div>
            </form>
        </div>
    </div>
</template>
<style scoped>
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
    color: var(--secondary-text-color);
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
    width: 85%;
    background-color: var(--secondary-bg-color);
    padding: 40px;
    border-radius: 10px;
    height: max-content;
}

.denunciar h1 {
    text-align: center;
    color: #333;
}

.denunciar .denunciar-input-field {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    margin-bottom: 20px;
    width: 100%;
    margin: margin-bottom;
}

.denunciar-input-field input, #descricao-golpe, #empresa-select {
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

#descricao-golpe, #empresa-select {
    padding: 10px;
}

.denunciar button {
    width: 85%;
    padding: 10px;
    border: none;
    border-radius: 10px;
    background-color: var(--secondary-color);
    color: var(--primary-color);
    font-size: 16px;
    cursor: pointer;
}

.denunciar-input-wrapper {
    position: relative;
    width: 100%; 
    font-size: 16px; /* <-- CONTROLA O TAMANHO DA FONTE E DO ÍCONE */
}

.denunciar-input-field .icon {
    position: absolute;
    top: 50%;
    left: 10px;
    transform: translateY(-50%);
    color: #666;
    width: 16px;
    height: 16px;
}

.denunciar-input-field button[type="submit"]:hover {
    transition: background-color 0.3s ease;
    background-color: var(--primary-bg-color);
}
</style>