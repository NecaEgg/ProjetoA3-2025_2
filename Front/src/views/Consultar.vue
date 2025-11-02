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

            <div class="resultado-container">
                
                <div class="resultado-card risk-high">
                    <div class="card-header">
                        <img class="card-icon" src=' ' alt="Alerta">
                        <div class="card-title">
                            <h3>(11) 98765-4321</h3>
                            <span>28 denúncias recebidas</span>
                        </div>
                        <span class="card-tag tag-high">ALTO RISCO</span>
                    </div>
                    <div class="card-body">
                        <p>"Usuários relatam tentativas de golpe se passando por banco. Solicitam dados pessoais e senhas."</p>
                        <span class="timestamp">Última denúncia: 2 dias atrás</span>
                    </div>
                </div>

                <div class="resultado-card risk-safe">
                    <div class="card-header">
                        <img class="card-icon" src=' ' alt="Seguro">
                        <div class="card-title">
                            <h3>(21) 99999-8888</h3>
                            <span>Nenhuma denúncia encontrada para este número.</span>
                        </div>
                        <span class="card-tag tag-safe">SEM DENÚNCIAS</span>
                    </div>
                    <div class="card-body">
                        <p>Se você recebeu uma ligação suspeita deste número, seja o primeiro a denunciar e ajude a proteger a comunidade.</p>
                    </div>
                </div>

                <div class="resultado-card risk-moderate">
                    <div class="card-header">
                        <img class="card-icon" src=' ' alt="Atenção">
                        <div class="card-title">
                            <h3>(31) 91234-5678</h3>
                            <span>2 denúncias recebidas</span>
                        </div>
                        <span class="card-tag tag-moderate">RISCO MODERADO</span>
                    </div>
                    <div class="card-body">
                        <p>"Ligação silenciosa, desligam após alguns segundos."</p>
                        <span class="timestamp">Última denúncia: 1 mês atrás</span>
                    </div>
                </div>

            </div>

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
    color: var(--secondary-text-color);
}

.container {
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
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
    background-color: var(--secondary-color);
    color: var(--primary-color);
    font-size: 16px;
    cursor: pointer;
}

.resultado-text {
    margin-top: 40px;
    margin-bottom: 20px;
    color: var(--secondary-text-color);
    font-size: 1.75rem;
    font-weight: 600;
}

.resultado-container {
    display: flex;
    flex-direction: column;
    gap: 20px;
    width: 1000px; 
    max-width: 100%;
}

.resultado-card {
    background-color: var(--primary-color);
    border: 1px solid #eee;
    border-radius: 12px;
    padding: 24px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.03);
    border-left-width: 4px; 
}

.card-header {
    display: flex;
    align-items: flex-start;
    gap: 16px;
    margin-bottom: 16px;
}

.card-icon {
    width: 32px;
    height: 32px;
    border-radius: 50%; 
    flex-shrink: 0; 
}

.card-title {
    flex-grow: 1; 
}

.card-title h3 {
    margin: 0 0 4px 0;
    font-size: 1.25rem;
    color: var(--primary-text-color);
}

.card-title span {
    font-size: 0.9rem;
    color: var(--primary-text-color);
}

.card-tag {
    font-size: 0.75rem;
    font-weight: 700;
    padding: 4px 8px;
    border-radius: 50px;
    flex-shrink: 0;
}

.card-body p {
    font-size: 1rem;
    color: var(--primary-text-color);
    margin: 0 0 8px 0;
    line-height: 1.5;
}

.card-body .timestamp {
    font-size: 0.8rem;
    color: #888;
}

.resultado-card.risk-high {
    border-left-color: #f04438;
}
.risk-high .card-icon {
    background-color: #fee4e2; 
}
.risk-high .card-tag {
    background-color: #fee4e2;
    color: #d92d20;
}

.resultado-card.risk-safe {
    border-left-color: #12b76a;
}
.risk-safe .card-icon {
    background-color: #d1fadf;
}
.risk-safe .card-tag {
    background-color: #d1fadf;
    color: #027a48;
}

.resultado-card.risk-moderate {
    border-left-color: #f79009;
}
.risk-moderate .card-icon {
    background-color: #fef0c7;
}
.risk-moderate .card-tag {
    background-color: #fef0c7;
    color: #b54708;
}
</style>