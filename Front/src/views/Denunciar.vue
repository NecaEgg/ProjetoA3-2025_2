<script>
 import { vMaska } from 'maska/vue'
export default {
     directives: {
        maska: vMaska
    },
    data() {
        return {
            bancos: [
                { value: "banco-do-brasil", text: "Banco do Brasil" },
                { value: "bradesco", text: "Bradesco" },
                { value: "caixa", text: "Caixa Econômica Federal" },
                { value: "itau", text: "Itaú" },
                { value: "santander", text: "Santander" },
                { value: "nubank", text: "Nubank" },
                { value: "banco-inter", text: "Banco Inter" },
                { value: "c6-bank", text: "C6 Bank" },
                { value: "mercado-pago", text: "Mercado Pago" },
                { value: "picpay", text: "PicPay" },
                { value: "banco-pan", text: "Banco Pan" },
                { value: "bmg", text: "BMG" },
                { value: "outro-banco", text: "Outra Instituição Financeira (Não listada)" }
            ],
            formData: {
                phone: '',
                callDate: '',
                company: '',
                description: ''
            },
            loading: false,
            error: null
        }
    },
    methods: {
        async submitReport(e) {
            e.preventDefault();
            this.loading = true;
            this.error = null;

            try {
                const response = await fetch('http://localhost:8080/api/reports', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify({
                        phone: this.formData.phone,
                        callDate: this.formData.callDate,
                        company: this.formData.company,
                        description: this.formData.description
                    })
                });

                if (!response.ok) {
                    throw new Error(`Erro: ${response.status}`);
                }

                const data = await response.json();
                alert('Denúncia feita com sucesso!');
                this.resetForm();
            } catch (error) {
                this.error = 'Erro ao enviar denúncia: ' + error.message;
                alert(this.error);
            } finally {
                this.loading = false;
            }
        },
        resetForm() {
            this.formData = { phone: '', callDate: '', company: '', description: '' };
        }
    },
    mounted() {
        const outroIndex = this.bancos.findIndex(banco => banco.value === 'outro-banco');
        let outroBancoItem = null;
        if (outroIndex > -1) {
            outroBancoItem = this.bancos.splice(outroIndex, 1)[0];
        }
        this.bancos.sort((a, b) => a.text.localeCompare(b.text));
        if (outroBancoItem) {
            this.bancos.push(outroBancoItem);
        }
    }
};
</script>

<template>
    <div id="denunciar">
        <div class="container">
            <h1 class="header-text">Ajude a combater fraudes - Denuncie uma Ligação suspeita!</h1>
            <form class="denunciar" @submit="submitReport">
                <div class="denunciar-input-field">
                    <p class="texto">Número de Telefone do Golpista</p>
                    <div class="denunciar-input-wrapper">
                        <input v-maska="'(##) #####-####'" type="text" placeholder="(XX) XXXXX-XXXX" required>
                        <img class="icon" src="../assets/icons/phone-solid-full.svg">
                    </div>
                </div>
                <div class="denunciar-input-field">
                    <p class="texto">Data da Ligação e Hora Aproximada da Ligação</p>
                    <input type="datetime-local" v-model="formData.callDate" required />
                </div>
                <div class="denunciar-input-field">
                    <label class="texto" for="empresa-select">Suposta Empresa ou Instituição</label>
                    <select id="empresa-select" v-model="formData.company" required>
                        <option value="" disabled selected>-- Selecione uma instituição --</option>
                        <option v-for="banco in bancos" :key="banco.value" :value="banco.value">
                            {{ banco.text }}
                        </option>
                    </select>
                </div>
                <div class='denunciar-input-field'>
                    <label class="texto" for="descricao-golpe">Descreva o que aconteceu (detalhes da ligação)</label>
                    <textarea style="resize: none" id="descricao-golpe" v-model="formData.description" rows="5"
                        placeholder='Forneça o máximo de detalhes possível, como o que foi dito, se pediram informações pessoais, etc'
                        required></textarea>
                </div>
                <div class='denunciar-input-field'>
                    <button type="submit" :disabled="loading">
                        {{ loading ? 'Enviando...' : 'Denunciar' }}
                    </button>
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

.denunciar-input-field input,
#descricao-golpe,
#empresa-select {
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

#descricao-golpe,
#empresa-select {
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
    font-size: 16px;
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