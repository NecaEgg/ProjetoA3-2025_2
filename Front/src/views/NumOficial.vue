<script>
export default {
    data() {
        return {
            searchQuery: '',
            banks: [
                {
                    id: 1,
                    name: 'Itaú Unibanco',
                    logoSrc: 'https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fcompanieslogo.com%2Fimg%2Forig%2FITUB-1ebef8c5.png%3Ft%3D1649084582&f=1&nofb=1&ipt=7d24bb3543862ea575e16df91ff98126a7e6a5c961bf0b3e0280e36fcb05beb5', 
                    contacts: [
                        { title: 'Capitais e Regiões Metrop.', number: '4004 4828' },
                        { title: 'Demais Localidades', number: '0800 970 4828' },
                        { title: 'SAC', number: '0800 728 0728' }
                    ]
                },
                {
                    id: 2,
                    name: 'Banco do Brasil',
                    logoSrc: 'https://play-lh.googleusercontent.com/1-aNhsSPNqiVluwNGZar_7F5PbQ4u1zteuJ1jumnArhe8bfYHHaVwu4aVOF5-NAmLaA=w240-h480', 
                    contacts: [
                        { title: 'Central de Atendimento', number: '4004 0001 / 0800 729 0001' },
                        { title: 'WhatsApp Oficial', number: '(61) 4004 0001' },
                        { title: 'Ouvidoria', number: '0800 729 5678' }
                    ]
                },
                {
                    id: 3,
                    name: 'Nubank',
                    logoSrc: 'https://play-lh.googleusercontent.com/NPkx0aiwABB31gBw_CuZO9Rwukhir-BwemxfNlAVjT6smwk6QgUbb3XrmsSSClfzk0dY=w240-h480', 
                    contacts: [
                        { title: 'Capitais e Regiões Metrop.', number: '4020 0185' },
                        { title: 'Demais Localidades', number: '0800 591 2117' },
                        { title: 'Ouvidoria', number: '0800 887 0463' }
                    ]
                },
                {
                    id: 4,
                    name: 'Bradesco',
                    logoSrc: 'https://play-lh.googleusercontent.com/ReQEaxm44OuduIlJEVO_-xs9iZXSyRNdzGKrONYoLSgAdOzyhPKTb1xuuoPXK6tABm0=w240-h480',
                    contacts: [
                        { title: 'Fone Fácil', number: '4002 0022 / 0800 570 0022' },
                        { title: 'SAC', number: '0800 704 8383' },
                        { title: 'Ouvidoria', number: '0800 727 9933' }
                    ]
                },
                {
                    id: 5,
                    name: 'Santander',
                    logoSrc: 'https://play-lh.googleusercontent.com/g_QDzrOlw8Belx8qb47fUu0MPL6AVFzDdbOz_NJZYQDNLveHYxwiUoe09Wvkxf-_548q=w240-h480',
                    contacts: [
                        { title: 'Central de Atendimento', number: '4004 3535 / 0800 702 3535' },
                        { title: 'SAC', number: '0800 762 7777' },
                        { title: 'Ouvidoria', number: '0800 726 0322' }
                    ]
                },
                {
                    id: 6,
                    name: 'Caixa Econômica Federal',
                    logoSrc: 'https://play-lh.googleusercontent.com/ubV0x2kGJIEe10shxuFnH9Cy21OgHARwVUZ89nyE0YOZN9c25ov_dyHdk1rMgbPvoDI=w240-h480',
                    contacts: [
                        { title: 'Alô Caixa', number: '4004 0104 / 0800 104 0104' },
                        { title: 'WhatsApp', number: '0800 104 0104' },
                        { title: 'SAC', number: '0800 726 0101' }
                    ]
                },
                {
                    id: 7,
                    name: 'Banco Inter',
                    logoSrc: 'https://play-lh.googleusercontent.com/DABQ3z4xA93QNsK9wqR2LdnamoDHkaKc-h1AueqJrVE7pP9GkIvZqf_URfxOIiNbFyzK=w240-h480',
                    contacts: [
                        { title: 'Capitais e Regiões Metrop.', number: '3003 4070' },
                        { title: 'Demais Localidades', number: '0800 940 0007' },
                        { title: 'SAC', number: '0800 940 9999' }
                    ]
                },
                {
                    id: 8,
                    name: 'C6 Bank',
                    logoSrc: 'https://play-lh.googleusercontent.com/qYXhGgBxFLr5xgnv0AGhqW9v7tyedb_i5AVoebI6pow5pWPNZH1qEHnslmSHNkVpB-g=w240-h480',
                    contacts: [
                        { title: 'WhatsApp', number: '(11) 2832 6088' },
                        { title: 'Capitais', number: '3003 6116' },
                        { title: 'Demais Localidades', number: '0800 660 6116' }
                    ]
                },
                {
                    id: 9,
                    name: 'PicPay',
                    logoSrc: 'https://play-lh.googleusercontent.com/pTvc9kCumx_24eJDwGUpvcBwljcIBkrsL3qHwhBW2NalMQ-XxTtHRV9YAJanBxkV0Rw=w240-h480',
                    contacts: [
                        { title: 'Central de Atendimento', number: '0800 025 8000' },
                        { title: 'Ouvidoria', number: '0800 025 2000' }
                    ]
                },
                {
                    id: 10,
                    name: 'Mercado Pago',
                    logoSrc: 'https://play-lh.googleusercontent.com/UrB8aayxpFSw0zzKNFSWGgqXbxfpQ_U_DLPCnjYVAlWN8GsnMkprpD80l3k6c0hEOKQRpnTxGtGeddgV3wFq7w=w240-h480',
                    contacts: [
                        { title: 'Central de Atendimento', number: '0800 637 7246' },
                        { title: 'WhatsApp', number: '(11) 98803-2875' }
                    ]
                },
                {
                    id: 11,
                    name: 'BTG Pactual',
                    logoSrc: 'https://play-lh.googleusercontent.com/0y84dcSeljAid36WeCs-9FWY4fENzxVilh1TS9G4jV30VHsFHJ3lGofMeS3w5hpvRk0D=s48',
                    contacts: [
                        { title: 'Capitais e Regiões Metrop.', number: '4007 2511' },
                        { title: 'Demais Localidades', number: '0800 001 2511' },
                        { title: 'Ouvidoria', number: '0800 722 0048' }
                    ]
                },
                {
                    id: 12,
                    name: 'Banco Pan',
                    logoSrc: 'https://play-lh.googleusercontent.com/XMa2dHPpQlze89nhfDQP6LV9Az01_ayRyxfOw5IQUu6oyBJLLNczL26Oa-UUFwQf4A=w240-h480',
                    contacts: [
                        { title: 'Capitais e Regiões Metrop.', number: '4003 0101' },
                        { title: 'Demais Localidades', number: '0800 888 0101' },
                        { title: 'SAC', number: '0800 776 8000' }
                    ]
                },
            ]
        };
    },
    computed: {
        filteredBanks() {
            if (!this.searchQuery) {
                return this.banks;
            }
            
            const query = this.searchQuery.toLowerCase();
            return this.banks.filter(bank => 
                bank.name.toLowerCase().includes(query)
            );
        }
    },
    methods: {
        copyToClipboard(text) {
            if (navigator.clipboard) {
                navigator.clipboard.writeText(text).then(() => {
                    alert('Número copiado!');
                }).catch(err => {
                    console.error('Falha ao copiar: ', err);
                });
            }
        }
    }
};
</script>

<template>
    <div id="num-oficial">
    <div class="bank-directory-page">

        <div class="directory-header">
            <h1>Contatos Oficiais de Bancos e Instituições Financeiras</h1>
            <p class="subtitle">
                Verifique aqui os números de telefone oficiais e proteja-se contra fraudes da falsa central de atendimento.
            </p>
            
            <div class="search-bar-wrapper">
                <div class="input-wrapper">
                    <img class="icon" src='../assets/icons/magnifying-glass-solid-full.svg' alt="Buscar" />
                    <input type="text" 
                           placeholder="Busque por um banco ou instituição" 
                           v-model="searchQuery">
                </div>
            </div>
        </div>

        <div class="phone-list-container" v-if="filteredBanks.length > 0">
            <div class="bank-card" v-for="bank in filteredBanks" :key="bank.id">
                <div class="card-header">
                    <img :src="bank.logoSrc" :alt="'Logo ' + bank.name" />
                    <h3>{{ bank.name }}</h3>
                </div>
                
                <div class="contact-list">
                    <div class="contact-item" v-for="contact in bank.contacts" :key="contact.title">
                        <div class="contact-info">
                            <p class="contact-title">{{ contact.title }}</p>
                            <p class="contact-number">{{ contact.number }}</p>
                        </div>
                        <button class="copy-button" @click="copyToClipboard(contact.number)">
                            <img src='../assets/icons/copy-solid-full.svg' alt="Copiar" />
                        </button>
                    </div>
                </div>
            </div>
        </div>

        <div class="no-results" v-else>
            <p>Nenhum banco ou instituição encontrado com o termo "{{ searchQuery }}".</p>
        </div>

    </div>
</div>
</template>

<style scoped>
#num-oficial {
    display: flex;
    justify-content: center;
    align-items: center;
}

.bank-directory-page {
    width: 100%;
    padding: 20px; 
    box-sizing: border-box;

    display: flex;
    flex-direction: column;
    justify-content: flex-start;
    align-items: center;
    width: 100%;
    height: 100%;
}

.directory-header {
    width: 100%;
    text-align: center;
    margin-bottom: 40px;
}

.directory-header h1 {
    font-size: 2.5rem;
    font-weight: 700;
    color: var(--secondary-text-color);
    margin: 0;
}

.directory-header .subtitle {
    font-size: 1.125rem;
    color: var(--secondary-text-color);
    max-width: 600px;
    margin: 10px auto 0 auto;
    line-height: 1.5;
}

.search-bar-wrapper {
    max-width: 700px;
    margin: 30px auto 0 auto;
}

.input-wrapper {
    position: relative;
    width: 100%;
    font-size: 1rem;
}

.input-wrapper .icon {
    position: absolute;
    top: 50%;
    left: 20px;
    transform: translateY(-50%);
    width: 1em;
    height: 1em;
    opacity: 0.5;
    background-color: #f0f0f0;
}

.input-wrapper input[type="text"] {
    width: 100%;
    padding: 16px 20px 16px 50px; 
    border: 1px solid #ddd;
    border-radius: 50px; 
    font-size: inherit;
    background-color: #fff;
    box-sizing: border-box;
    font-family: inherit;
    color: var(--text-color, #333);
}

.input-wrapper input[type="text"]:focus {
    outline: none;
    border-color: var(--secondary-color, #007bff);
    box-shadow: 0 0 0 3px rgba(0,123,255,0.25);
}

.no-results {
    text-align: center;
    width: 100%;
    padding: 50px 20px;
    color: var(--text-color-light, #666);
    font-size: 1.2rem;
}
.no-results p {
    margin: 0;
}

.phone-list-container {
    display: grid;
    grid-template-columns: repeat(3, 1fr); 
    gap: 24px;
    width: 100%;
    box-sizing: border-box;
}

.bank-card {
    background-color: var(--primary-color, #ffffff);
    border-radius: 12px;
    padding: 24px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
    border: 1px solid #eee;
    box-sizing: border-box;
    display: flex; 
    flex-direction: column;
}

.card-header {
    display: flex;
    align-items: center;
    gap: 12px;
    margin-bottom: 24px;
    border-bottom: 1px solid #f0f0f0;
    padding-bottom: 16px;
}

.card-header img {
    width: 40px;
    height: 40px;
    object-fit: contain;
    border-radius: 4px;
    background-color: #f0f0f0; 
}

.card-header h3 {
    font-size: 1.25rem; 
    font-weight: 600;
    color: var(--text-color, #333);
    margin: 0;
}

.contact-list {
    display: flex;
    flex-direction: column;
    gap: 16px; 
    flex-grow: 1; 
}

.contact-item {
    display: flex;
    justify-content: space-between; 
    align-items: center;
    margin-top: auto; 
}

.contact-info p {
    margin: 0;
}

.contact-title {
    font-size: 0.875rem; 
    color: var(--text-color-light, #666);
    margin-bottom: 2px;
    text-align: left;
}

.contact-number {
    font-size: 1.125rem;
    font-weight: 600;
    color: var(--text-color, #333);
    text-align: left;
}

.copy-button {
    background: none;
    border: none;
    cursor: pointer;
    padding: 4px;
    border-radius: 4px;
}

.copy-button img {
    width: 16px;
    height: 16px;
    opacity: 0.6;
    background-color: #f0f0f0; 
}

.copy-button:hover {
    background-color: #f0f0f0;
}
.copy-button:hover img {
    opacity: 1;
}

@media (max-width: 1024px) {
    .phone-list-container {
        grid-template-columns: repeat(2, 1fr);
    }
    .directory-header h1 {
        font-size: 2rem;
    }
}

@media (max-width: 767px) {
    .phone-list-container {
        grid-template-columns: 1fr;
    }
    .directory-header h1 {
        font-size: 1.75rem;
    }
    .directory-header .subtitle {
        font-size: 1rem;
    }
}
</style>