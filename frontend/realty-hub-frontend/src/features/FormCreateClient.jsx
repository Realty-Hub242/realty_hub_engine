import { useState } from "react";
import axios from 'axios';
import Cookies from "js-cookie";

const FormCreateClient = () => {
    const[msg, setMsg] = useState("");
    const API_URL = "http://localhost:8090/private";

    const [Client, setClient] = useState({
        firstName : "",
        lastName : "",
        email : "",
        numberPhone : "",
        type : "",
        income : "",
        description : "",
        manager : ""
    })

    

    const handleChange = e => {
        const {name, value} = e.target;
        setClient({...Client, [name]:value})
    }

    const save = (client) => {
        const token = Cookies.get('token');
        console.log(Client);
        console.log("token " + token);
        return axios.post(API_URL+"/add_new_client", client, {
            headers : {
                'Authorization': `Bearer ${token}` 
            }
        });
    }

    const createClient = e => {
        e.preventDefault();
        const formData = new FormData();
        formData.append("firstName", Client.firstName);
        formData.append("lastName", Client.lastName);
        formData.append("email", Client.email);
        formData.append("numberPhone", Client.numberPhone);
        formData.append("type", Client.type);
        formData.append("income", Client.income);
        formData.append("description", Client.description);
        formData.append("manager", Client.manager);

        save(formData).then((res) => {
            setMsg("User Added Successfully!");
            setClient({
                firstName : "",
                lastName : "",
                email : "",
                numberPhone : "",
                type : "",
                income : "",
                description : "",
                manager : ""
            });
        }).catch((error) => {
            console.error("Error : ", error);
        })
    };

    return(
        <div className="add_clinet">
            <div>
                <a href="/partner_page">partner page</a>
                <h3>Новый пользователь</h3>
                <form onSubmit={(e) => createClient(e)}>
                    <label>Имя</label>
                    <input type="text" name="firstName" value={Client.firstName} onChange={handleChange}/>
                    <br />
                    <label>Фамилия</label>
                    <input type="text" name="lastName" value={Client.lastName} onChange={handleChange}/>
                    <br />
                    <label>Email</label>
                    <input type="email" name="email" value={Client.email} onChange={handleChange}/>
                    <br />
                    <label>Номер телефона</label>
                    <input type="text" name="numberPhone" value={Client.numberPhone} onChange={handleChange}/>
                    <br />
                    <label>Тип сделки</label>
                    <br />
                    <select name="type" value={Client.type} onChange={handleChange}>
                        <option value="unknown">Выберите из списка</option>
                        <option value="Покупка">Покупка</option>
                        <option value="Аренда">Аренда</option>
                        <option value="Продажа">Продажа</option>
                        <option value="Сдача">Сдача</option>
                    </select>
                    <br />
                    <label>Бюджет</label>
                    <input type="text" name="income" value={Client.income} onChange={handleChange}/>
                    <br />
                    <label>Описание</label>
                    <input type="text" name="description" value={Client.description} onChange={handleChange}/>
                    <br />
                    <label>Менеджер</label>
                    <input type="text" name="manager" value={Client.manager} onChange={handleChange}/>
                    <br />
                    <input type = "submit" value="Create"/>
                </form>
            </div>
        </div>
    )
}

export default FormCreateClient;