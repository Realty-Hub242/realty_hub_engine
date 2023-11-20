import React, { useState } from 'react';
import { Navigate } from 'react-router-dom';
import axios from 'axios';

const LoginComponent = () => {
    const [formData, setFormData] = useState({
        usernameOrEmail: '',
        password: '',
    });

    let [loggedIn, setLoggedIn] = useState(false);

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8090/private/api/auth/signin', formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });
            console.log('Успешно вошли в систему.');
            console.log('Ответ от сервера:', response.data);
            setLoggedIn(true)
            loggedIn = true;
            
            if (loggedIn) {
                return <Navigate path=""/>
            }

        } catch (error) {
            console.error('Ошибка при входе в систему:', error);
        }
    };

    const handleChange = (e) => {
        setFormData({ ...formData, [e.target.name]: e.target.value });
    };

    return (
        <div>
            <h2>Форма входа</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Имя пользователя или Email:
                    <input
                        type="text"
                        name="usernameOrEmail"
                        value={formData.usernameOrEmail}
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
