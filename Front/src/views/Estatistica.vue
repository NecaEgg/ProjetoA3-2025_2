<script>
export default {};
</script>

<template>
    <div id="estatistica">
    <div class="dashboard-page">
        
        <section class="dashboard-header">
            <div class="header-title">
                <h1>Painel de Análise de Fraudes</h1>
                <p>Visão geral das denúncias e tendências de fraude.</p>
            </div>
            <!-- <div class="time-filter">
                <img src=' ' alt="Calendário" class="icon">
                <span>Últimos 30 Dias</span>
                <img src=' ' alt="Seta" class="icon-arrow">
            </div> -->
        </section>

        <section class="stats-grid">
            <div class="stat-card">
                <p class="stat-title">Total de Denúncias</p>
                <p class="stat-value">12.874</p>
                <span class="stat-change positive">+5,4%</span>
            </div>
            <div class="stat-card">
                <p class="stat-title">Fraudes Validadas</p>
                <p class="stat-value">9.231</p>
                <span class="stat-change positive">+2,1%</span>
            </div>
            <div class="stat-card">
                <p class="stat-title">Denúncias Hoje</p>
                <p class="stat-value">152</p>
                <span class="stat-change negative">-1,8%</span>
            </div>
            <div class="stat-card">
                <p class="stat-title">Principal Tipo de Fraude</p>
                <p class="stat-value type-main">Golpe Bancário</p>
                <span class="stat-change positive">+8,2%</span>
            </div>
        </section>

        <section class="charts-grid">
            <div class="chart-card">
                <h3>Denúncias por Tipo de Fraude</h3>
                <div class="bar-chart-container">
                    <div class="bar-wrapper">
                        <div class="bar" style="height: 160px;"></div>
                        <p class="label">PHISHING</p>
                    </div>
                    <div class="bar-wrapper">
                        <div class="bar" style="height: 100px;"></div>
                        <p class="label">SUPORTE TÉCNICO</p>
                    </div>
                    <div class="bar-wrapper">
                        <div class="bar highlight" style="height: 220px;"></div>
                        <p class="label">BANCÁRIO</p>
                    </div>
                    <div class="bar-wrapper">
                        <div class="bar" style="height: 140px;"></div>
                        <p class="label">GOVERNO</p>
                    </div>
                    <div class="bar-wrapper">
                        <div class="bar" style="height: 80px;"></div>
                        <p class="label">E-COMMERCE</p>
                    </div>
                    <div class="bar-wrapper">
                        <div class="bar" style="height: 60px;"></div>
                        <p class="label">OUTROS</p>
                    </div>
                </div>
            </div>
            
            <div class="chart-card">
                <h3>Tendência de Denúncias</h3>
                <div class="line-chart-placeholder">
                    <img src='../assets/images/zen_jOM3F9vaTd.png' alt="Gráfico de Tendência de Denúncias">
                </div>
                <div class="chart-labels">
                    <span>SEMANA 1</span>
                    <span>SEMANA 2</span>
                    <span>SEMANA 3</span>
                    <span>SEMANA 4</span>
                </div>
            </div>
        </section>

    </div>
    </div>
</template>

<style scoped>
#estatistica {
    display: flex;
    justify-content: center;
    align-items: flex-start; 
    box-sizing: border-box;
}

.dashboard-page {
    width: 100%;
    height: 100%;
    margin: 0 auto;
    padding: 20px; 
    box-sizing: border-box;
    display: flex;
    flex-direction: column;
    justify-content: flex-start;
}

.dashboard-header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 24px;
    flex-wrap: wrap;
    gap: 16px;
}

.header-title h1 {
    font-size: 2.25rem;
    font-weight: 700;
    color: var(--secondary-text-color);
    margin: 0 0 4px 0;
}

.header-title p {
    font-size: 1rem;
    color: var(--secondary-text-color);
    margin: 0;
}

.time-filter {
    display: flex;
    align-items: center;
    gap: 8px;
    background-color: var(--primary-color, #fff);
    color: var(--text-color);
    border: 1px solid #e0e0e0;
    border-radius: 8px;
    padding: 8px 12px;
    font-size: 0.9rem;
    font-weight: 500;
    cursor: pointer;
}

.time-filter .icon {
    width: 16px;
    height: 16px;
    background-color: #f0f0f0;
}
.time-filter .icon-arrow {
    width: 12px;
    height: 12px;
    background-color: #f0f0f0;
}

.stats-grid {
    display: grid;
    grid-template-columns: repeat(4, 1fr);
    gap: 20px;
    margin-bottom: 20px;
}

.stat-card {
    background-color: var(--primary-color, #fff);
    border-radius: 12px;
    padding: 24px;
    border: 1px solid #e0e0e0;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.03);
}

.stat-title {
    font-size: 0.9rem;
    color: var(--text-color-light, #666);
    margin: 0 0 8px 0;
}

.stat-value {
    font-size: 2rem;
    font-weight: 600;
    color: var(--text-color, #333);
    margin: 0 0 8px 0;
}

.stat-value.type-main {
    font-size: 1.5rem; 
}

.stat-change {
    font-size: 0.9rem;
    font-weight: 600;
}

.stat-change.positive {
    color: #12b76a; 
}

.stat-change.negative {
    color: #f04438; 
}

.charts-grid {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 20px;
}

.chart-card {
    background-color: var(--primary-color, #fff);
    border-radius: 12px;
    padding: 24px;
    border: 1px solid #e0e0e0;
    box-shadow: 0 2px 4px rgba(0, 0, 0, 0.03);
    min-height: 400px;
}

.chart-card h3 {
    font-size: 1.2rem;
    font-weight: 600;
    color: var(--text-color, #333);
    margin: 0 0 32px 0;
}

.bar-chart-container {
    display: flex;
    align-items: flex-end;
    justify-content: space-around;
    height: 300px;
    width: 100%;
}

.bar-wrapper {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 8px;
}

.bar {
    width: 30px;
    background-color: #a0c4e4;
    border-radius: 4px 4px 0 0;
}

.bar.highlight {
    background-color: var(--secondary-color, #007bff);
}

.label {
    font-size: 0.7rem;
    color: var(--text-color-light, #666);
    font-weight: 500;
}

.line-chart-placeholder {
    width: 100%;
}

.line-chart-placeholder img {
    width: 100%;
    height: 280px;
    border-radius: 8px;
    background-color: #f0f0f0;
}

.chart-labels {
    display: flex;
    justify-content: space-around;
    margin-top: 16px;
    font-size: 0.8rem;
    color: var(--text-color-light, #666);
}

@media (max-width: 1200px) {
    .stats-grid {
        grid-template-columns: repeat(2, 1fr);
    }
    .charts-grid {
        grid-template-columns: 1fr;
    }
}

@media (max-width: 768px) {
    .dashboard-header {
        flex-direction: column;
        align-items: flex-start;
    }
    .stats-grid {
        grid-template-columns: 1fr;
    }
    .bar {
        width: 20px;
    }
    .label {
        font-size: 0.6rem;
    }
}
</style>