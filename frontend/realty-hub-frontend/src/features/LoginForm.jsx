import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import Cookies from 'js-cookie';

const LoginComponent = () => {

    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        username: '',
        password: '',
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8090/public/generate_token', formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            
            Cookies.set('token', response.data);
            navigate('/partner_page', {state : {username : formData.username}});

        } catch (error) {
            console.error('Ошибка при входе в систему:', error);
        }
    };

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };


    return (
        <div>
            <a href="/">back</a>
            <h2>Форма входа</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Имя пользователя или Email:
                    <input
                        type="text"
                        name="username"
                        value={formData.username}
                        onChange={handleChange}
                    />
                </label>
                <br />
                <label>
                    Пароль:
                    <input
                        type="password"
                        name="password"
                        value={formData.password}
                        onChange={handleChange}
                    />
                </label>
                <br />
                <button onClick={handleSubmit}>Войти</button>
            </form>
        </div>
    );
}

export default LoginComponent;
