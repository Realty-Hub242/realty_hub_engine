import { useEffect, useState } from "react";
import axios from 'axios';
import { Link, useLocation } from "react-router-dom";
import Cookies from "js-cookie";
import ClientsList from "./ClientsList";


const PartnerPage = () => {

    const location = useLocation();
    const userData = location.state || {};
    const [data, setData] = useState(null);
    const API_URL = "http://localhost:8090/private";
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = Cookies.get('token');
                const response = await axios.get(`${API_URL}/get_user/${userData.username}`, {
                    headers: {
                        'Authorization': `Bearer ${token}`
                    }
                });
                setData(response.data);
            } catch (error) {
                setError(error.message || 'Что-то пошло не так');
            } finally {
                setLoading(false);
            }
        };

        if (userData.username) {
            fetchData();
        }
    }, [userData.username]);

    if (loading) {
        return <div>Загрузка...</div>;
    }

    if (error) {
        return <div>Ошибка: {error}</div>;
    }

    return(
        <div className="partner">
            <p>{data}, добро пожаловать!</p>
            <br />
            <Link to="/create_build">Добавить новый объект</Link>
            <br />
            <Link to = "/create_user">Добавить сотрудника</Link>
            <br />
            <Link to = "/create_client">Добавить клиента</Link>
            <br />
            <Link to = "/all_builds">Просмотреть все объекты</Link>
            <br />
            <Link to = "/all_clients">Наши клиенты</Link>
            <br />
            <p>Ваши клиенты:</p>
            <br />
            <ClientsList username={data}/>
        </div>
    )
}

export default PartnerPage;