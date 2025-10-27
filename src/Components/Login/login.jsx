import {FaUser, FaLock} from 'react-icons/fa' 
import { useState } from 'react'    
import './login.css'      

const login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const handleSubmit = (event) => {
        preventdefault()

        alert(`E-mail: ${email} \nSenha: ${password}`)
    }

  return (
    <div className="container">
        <form onSubmit={handleSubmit}>
            <h1>Acesse sua conta</h1>
            <div className="input-field">
                <input 
                type="email" 
                placeholder='E-mail'
                required
                onChange={(e) => setEmail(e.target.value)} 
                />
                <FaUser className='icon'/>
            </div>
            <div className='input-field'>
                <input 
                type="password" 
                placeholder='Senha' 
                required
                onChange={(e) => setPassword(e.target.value)} 
                />
                <FaLock className='icon'/>
            </div>
            <button type="submit">Entrar</button>
            <div className='recall-forget'>
                <a href="#">Esqueci minha senha</a>
            </div>
            <div className="signup-link">
                <p>
                    Ainda não tem uma conta? <a href="#">Cadastre-se</a>
                </p>
            </div>
        </form>
    </div>
  )
}

export default login