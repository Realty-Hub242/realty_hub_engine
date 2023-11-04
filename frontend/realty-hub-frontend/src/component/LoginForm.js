import React, { useState } from 'react';
import axios from 'axios';

function LoginComponent() {
    const [formData, setFormData] = useState({
        usernameOrEmail: '',
        password: '',
    });

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8090/api/auth/signin', formData, {
                headers: {
                    'Content-Type': 'application/json',
                },
            });

            console.log('Успешно вошли в систему.');
            console.log('Ответ от сервера:', response.data);
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
                <button type="submit">Войти</button>
            </form>
        </div>
    );
}

export default LoginComponent;
