<script>
export default {};
</script>
<template>
    <div id="consultar">
        <div class="container">
            <h1 class="consultar-header-text">Verifique se um número é fraudulento</h1>
            <form class="consultar">
                <div class="consultar-input-field">
                    <p class="texto"> Número de Telefone</p>
                    <input type="tel" placeholder='(XX) XXXXX-XXXX' required />
                </div>
                <div class='consultar-input-field'>
                    <button type="submit">Consultar</button>
                </div>
            </form>
            <h2 class="resultado-text">Resultados da Busca</h2>
        </div>
    </div>
</template>
<style>
#consultar {
    display: flex;
    justify-content: center;
    align-items: flex-start; 
    padding-top: 0%; 
    min-height: 100vh; 
    box-sizing: border-box;
}

.consultar-header-text {
    text-align: center;
    margin-bottom: 20px;
    color: #ffffff;
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    /* Mudar isso para paginas que nao e o consultar (flex-start)*/
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


.consultar {
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

.consultar h1 {
    text-align: center;
    color: #333;
}

.consultar .consultar-input-field {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    text-align: center;
    margin-bottom: 20px;
    width: 100%;
    margin: margin-bottom;
}

.consultar-input-field input {
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

.consultar button {
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