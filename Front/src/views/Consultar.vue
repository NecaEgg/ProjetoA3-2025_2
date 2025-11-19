<script>
const NivelRisco = {
    'Baixo': 'safe',
    'Moderado': 'moderate',
    'Alto': 'high'
}

export default {
    data() {
        return {
            resultados: [{
                phone: '11999999999',
                callDate: "17/11/2025 14:30",
                company: "Safe Line Telecom",
                description: "sim"
            }, {
                phone: '11999999999',
                callDate: "17/11/2025 15:30",
                company: "Safe Line Telecom",
                description: "sim"
            },
            {
                phone: '11999999999',
                callDate: "17/11/2025 16:30",
                company: "Safe Line Telecom",
                description: "sim"
            },
            {
                phone: '11999999999',
                callDate: "17/11/2025 16:30",
                company: "Kami LTDA",
                description: "sim"
            }]
        };
    },
    methods: {
        formatarData(data) {
            if (data) {
                const ultimoAcesso = luxon.DateTime.fromFormat(data, "dd/LL/yyyy HH:mm")

                return ultimoAcesso.toRelativeCalendar()[0].toUpperCase() + ultimoAcesso.toRelativeCalendar().slice(1);
            } else {
                return 'Sem Registro';
            }
        },
        // denunciaMaisRecente(resultados) {
        //     let denunciaMaisrecente = null

        //     for (let resultado of resultados) {
        //         const callDate = luxon.DateTime.fromFormat(resultado.callDate, "dd/LL/yyyy HH:mm")

        //         if (!denunciaMaisRecente || callDate > denunciaMaisrecente) {
        //             denunciaMaisrecente = callDate.toFormat("dd/LL/yyyy HH:mm")
        //         }
        //     }

        //     return denunciaMaisrecente
        // },
        nivelRisco(quantidadeDenuncias) {
            if (quantidadeDenuncias <= 5) {
                return 'Baixo'
            } else if (quantidadeDenuncias > 5 && quantidadeDenuncias <= 10) {
                return 'Moderado'
            } else if (quantidadeDenuncias > 10) {
                return 'Alto'
            } else {
                return 'Não Avaliado'
            }
        }
    },
    mounted() {
    }
};
</script>
<template>
    <div id="consultar">
        <div class="container">
            <h1 class="consultar-header-text">Verifique se um número é fraudulento</h1>
            <form class="consultar">
                <div class="consultar-input-field">
                    <p class="texto"> Número de Telefone</p>
                    <div class="consultar-input-wrapper">
                        <input type="tel" placeholder='(XX) XXXXX-XXXX' required />
                        <img class="icon" src="../assets/icons/phone-solid-full.svg">
                    </div>
                </div>
                <div class='consultar-input-field'>
                    <button type="submit">Consultar</button>
                </div>
            </form>

            <h2 class="resultado-text">Resultados da Busca</h2>

            <div class="resultado-estatisticas">
                <h4>{{ resultados.length }} Denúncias</h4>
                <!-- <h4>Última Denúncia: {{ denunciaMaisRecente(resultados) }}</h4> -->
            </div>

            <div class="resultado-container" v-for="resultado of resultados">

                <div class="resultado-card risk-high">
                    <div class="card-header">
                        <!-- <img class="card-icon card-icon-vermelho" src='../assets/icons/square-xmark-solid-full.svg'
                            alt="Alerta"> -->
                        <div class="card-title">
                            <h3>{{ resultado.phone }}</h3>
                            <p>{{ resultado.company }}.</p>
                            <!-- <span>{{ resultado.reports }} denúncias recebidas</span> -->
                        </div>
                        <!-- <span class="card-tag tag-high">{{ resultado.risco }}</span> -->
                    </div>
                    <div class="card-body">
                        <p>"{{ resultado.description }}"</p>
                        <span class="timestamp">Última denúncia: {{ formatarData(resultado.callDate) }}</span>
                    </div>
                </div>
                <!-- 
                <div class="resultado-card risk-safe">
                    <div class="card-header">
                        <img class="card-icon card-icon-verde" src='../assets/icons/circle-check-solid-full.svg'
                            alt="Seguro">
                        <div class="card-title">
                            <h3>(21) 99999-8888</h3>
                            <span>Nenhuma denúncia encontrada para este número.</span>
                        </div>
                        <span class="card-tag tag-safe">SEM DENÚNCIAS</span>
                    </div>
                    <div class="card-body">
                        <p>Se você recebeu uma ligação suspeita deste número, seja o primeiro a denunciar e ajude a
                            proteger a comunidade.</p>
                    </div>
                </div>

                <div class="resultado-card risk-moderate">
                    <div class="card-header">
                        <img class="card-icon card-icon-amarelo"
                            src='../assets/icons/triangle-exclamation-solid-full.svg' alt="Atenção">
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
                </div> -->

            </div>

        </div>
    </div>
</template>
<style scoped>
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
    width: 85%;
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

.resultado-estatisticas {
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: space-between;
    width: 80%;
}

.resultado-estatisticas h4 {
    color: var(--secondary-text-color);
    font-size: 1rem;
    font-weight: 600;
}

.resultado-container {
    display: flex;
    flex-direction: column;
    gap: 20px;
    width: 85%;
    max-width: 100%;
}

.resultado-card {
    background-color: var(--primary-color);
    border: 1px solid #eee;
    border-radius: 12px;
    padding: 24px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.03);
    border-left-width: 4px;
    margin: 10px 0;
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
    flex-shrink: 0;
}

.card-title {
    display: flex;
    flex-direction: column;
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
    background-color: var(--secondary-bg-color);
}

.risk-high .card-tag {
    background-color: #fee4e2;
    color: #d92d20;
}

.resultado-card.risk-safe {
    border-left-color: #12b76a;
    background-color: var(--secondary-bg-color);
}

.risk-safe .card-tag {
    background-color: #d1fadf;
    color: #027a48;
}

.resultado-card.risk-moderate {
    border-left-color: #f79009;
    background-color: var(--secondary-bg-color);
}

.risk-moderate .card-tag {
    background-color: #fef0c7;
    color: #b54708;
}


.card-icon-vermelho {
    filter: brightness(0) saturate(100%) invert(16%) sepia(74%) saturate(6831%) hue-rotate(3deg) brightness(103%) contrast(125%);
}

.card-icon-verde {
    filter: brightness(0) saturate(100%) invert(90%) sepia(7%) saturate(6859%) hue-rotate(70deg) brightness(100%) contrast(100%);
}

.card-icon-amarelo {
    filter: brightness(0) saturate(100%) invert(89%) sepia(57%) saturate(576%) hue-rotate(358deg) brightness(95%) contrast(95%);
}

.consultar-input-wrapper {
    position: relative;
    width: 100%;
    font-size: 16px;
    /* <-- CONTROLA O TAMANHO DA FONTE E DO ÍCONE */
}

.consultar-input-field .icon {
    position: absolute;
    top: 50%;
    left: 10px;
    transform: translateY(-50%);
    color: #666;
    width: 16px;
    height: 16px;
}

.consultar-input-field button[type="submit"]:hover {
    transition: background-color 0.3s ease;
    background-color: var(--primary-bg-color);
}
</style>