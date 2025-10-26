import {FaUser, FaLock} from 'react-icons/fa' 
import { useState } from 'react'    
import './login.css'      

const login = () => {

    const [email, setEmail] = useState('')
    const [password, setPassword] = useState('')

    const handleSubmit = (e) => {
        setEmail(e.target.value)
    }

  return (
    <div className="container">
        <form onSubmit={handleSubmit}>
            <h1>Acesse sua conta</h1>
            <div>
                <input 
                type="email" 
                placeholder='E-mail'
                onChange={(e) => setEmail(e.target.value)} 
                />
                <FaUser className='icon'/>
            </div>
            <div>
                <input type="password" placeholder='Senha' />
                <FaLock className='icon'/>
            </div>
            <button type="submit">Entrar</button>
            <div>
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