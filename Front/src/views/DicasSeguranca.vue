<script>
export default {
};
</script>

<template>
    <div class="guia-seguranca-page">
        
        <section class="hero-section">
            <div class="hero-content">
                <h1>Guia de Segurança: Proteja-se Contra Golpes de Falsas Centrais</h1>
                <p>Aprenda a identificar e se proteger de fraudes online e por telefone com nossas dicas práticas e fáceis de entender.</p>
                
                <a href="#" class="btn btn-primary">Denunciar uma Fraude</a>
            </div>
            <div class="hero-image">
                <img src=' ' alt="Escudo de Segurança">
            </div>
        </section>

        <section class="info-section">
            <h2>Sinais de Alerta Comuns</h2>
            
            <div class="info-grid columns-3">
                <div class="info-card">
                    <img class="icon icon-yellow" src=' ' alt="Ícone de Alerta">
                    <h3>Pedidos Urgentes</h3>
                    <p>Fraudadores criam um senso de urgência para que você não pense com clareza. Desconfie de qualquer pedido para "agir agora".</p>
                </div>
                
                <div class="info-card">
                    <img class="icon icon-red" src=' ' alt="Ícone de Link">
                    <h3>Links Suspeitos</h3>
                    <p>Nunca clique em links recebidos por SMS ou e-mails não solicitados. Verifique sempre o remetente e o domínio.</p>
                </div>
                
                <div class="info-card">
                    <img class="icon icon-blue" src=' ' alt="Ícone de Dados">
                    <h3>Solicitação de Dados</h3>
                    <p>Empresas legítimas nunca pedem senhas, códigos de segurança ou dados de cartão de crédito por telefone ou mensagem.</p>
                </div>
            </div>
        </section>

        <section class="info-section">
            <h2>O Que Fazer se Suspeitar de Fraude</h2>
            
            <div class="info-grid columns-2">
                <div class="info-card">
                    <img class="icon icon-green" src=' ' alt="Ícone de Desligar">
                    <h3>Desligue a Chamada</h3>
                    <p>Se receber uma ligação suspeita, desligue imediatamente. Não forneça nenhuma informação pessoal.</p>
                </div>
                
                <div class="info-card">
                    <img class="icon icon-green" src=' ' alt="Ícone de Verificar">
                    <h3>Verifique a Fonte</h3>
                    <p>Procure o número de telefone oficial da empresa no site dela e entre em contato diretamente para confirmar a legitimidade da comunicação.</p>
                </div>

                <div class="info-card">
                    <img class="icon icon-green" src=' ' alt="Ícone de Bloquear">
                    <h3>Bloqueie o Número</h3>
                    <p>Bloqueie o número de telefone ou o remetente do e-mail para evitar futuros contatos.</p>
                </div>

                <div class="info-card">
                    <img class="icon icon-green" src=' ' alt="Ícone de Denunciar">
                    <h3>Denuncie a Tentativa</h3>
                    <p>Use nosso portal para denunciar a tentativa de fraude e ajude a alertar outras pessoas.</p>
                </div>
            </div>
        </section>

    </div>
</template>

<style scoped>
.guia-seguranca-page {
   width: 100%;
   padding: 60% 20px 20px 20px; 
   box-sizing: border-box;
}

.hero-section {
   display: flex;
   align-items: center;
   justify-content: space-between;
   gap: 40px;
   margin-bottom: 80px;
}

.hero-content {
   flex: 1; 
}

.hero-content h1 {
   font-size: 2.75rem; 
   font-weight: 700;
   color: var(--secondary-text-color);
   line-height: 1.2;
   margin-bottom: 16px;
}

.hero-content p {
   font-size: 1.125rem; 
   color: var(--secondary-text-color);
   line-height: 1.6;
   margin-bottom: 32px;
}

.hero-image {
   flex: 1; 
   text-align: center;
}

.hero-image img {
   max-width: 450px;
   width: 100%;
   border-radius: 12px;
   background-color: #e0e0e0; 
   min-height: 300px; 
}

.btn-primary {
   display: inline-block;
   background-color: var(--secondary-color);
   color: var(--primary-color);
   padding: 14px 32px;
   border-radius: 50px; 
   text-decoration: none;
   font-size: 1rem;
   font-weight: 600;
   transition: background-color 0.3s ease;
}

.btn-primary:hover {
   filter: brightness(1.1);
}

.info-section {
   margin-bottom: 60px;
}

.info-section h2 {
   font-size: 2rem; 
   font-weight: 700;
   color: var(--secondary-text-color);
   margin-bottom: 30px;
}

.info-grid {
   display: grid;
   gap: 24px;
}

.columns-3 {
   grid-template-columns: repeat(3, 1fr);
}

.columns-2 {
   grid-template-columns: repeat(2, 1fr);
}

.info-card {
   background-color: var(--primary-color);
   padding: 24px;
   border-radius: 12px;
   box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
   border: 1px solid #eee;
}

.info-card .icon {
   width: 40px;
   height: 40px;
   border-radius: 8px;
   margin-bottom: 16px;
   object-fit: contain; 
}

.icon-yellow { background-color: #fef0c7; } 
.icon-red { background-color: #fee4e2; } 
.icon-blue { background-color: #d1e9ff; } 
.icon-green { background-color: #d1fadf; } 


.info-card h3 {
   font-size: 1.25rem; 
   font-weight: 600;
   color: var(--text-color, #333);
   margin-bottom: 8px;
}

.info-card p {
   font-size: 0.95rem; 
   color: var(--text-color-light, #666);
   line-height: 1.5;
   margin: 0;
}


@media (max-width: 1024px) {
   .columns-3 {
       grid-template-columns: repeat(2, 1fr); 
   }
}

@media (max-width: 768px) {
   .hero-section {
       flex-direction: column-reverse; 
       text-align: center;
       margin-bottom: 40px;
   }

   .hero-content h1 {
       font-size: 2rem; 
   }

   .hero-content p {
       font-size: 1rem; 
   }

   .info-section h2 {
       font-size: 1.75rem; 
       text-align: center;
   }

   .columns-3,
   .columns-2 {
       grid-template-columns: 1fr;
   }
}
</style>