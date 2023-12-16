import { useState } from "react";
import axios from 'axios';
import Cookies from "js-cookie";

const FormUserComponent = () => {

    const[msg, setMsg] = useState("");
    const API_URL = "http://localhost:8090/private";

    const [User, setUser] = useState({
        name : "",
        userName : "",
        email : "",
        password : "",
        roles : "USER",
    })

    const handleChange = e => {
        const {name, value} = e.target;
        setUser({...User, [name]:value})
    }

    const save = (user) => {
        const token = Cookies.get('token');
        console.log(User);
        console.log("token " + token);
        return axios.post(API_URL+"/add_new_user", user, {
            headers : {
                'Authorization': `Bearer ${token}` 
            }
        });
    }

    const createUser = e => {
        e.preventDefault();
        const formData = new FormData();
        formData.append("name", User.name);
        formData.append("userName", User.userName);
        formData.append("email", User.email);
        formData.append("password", User.password);
        formData.append("roles", User.roles);

        save(formData).then((res) => {
            setMsg("User Added Successfully!");
            setUser({
                name : "",
                userName : "",
                email : "",
                password : "",
                roles : ""
            });
        }).catch((error) => {
            console.error("Error : ", msg);
        })
    };

    return(
        <div className="add_user">
            <div>
                <a href="/partner_page">partner page</a>
                <h3>Новый пользователь</h3>
                <form onSubmit={(e) => createUser(e)}>
                    <label>Имя сотрудника</label>
                    <input type="text" name="name" value={User.name} onChange={handleChange}/>
                    <br />
                    <label>user name </label>
                    <input type="text" name="userName" value={User.userName} onChange={handleChange}/>
                    <br />
                    <label>Email</label>
                    <input type="email" name="email" value={User.email} onChange={handleChange}/>
                    <br />
                    <label>Пароль</label>
                    <input type="text" name="password" value={User.password} onChange={handleChange}/>
                    <br />
                    <label>Роль пользователя</label>
                    <select name="roles" value={User.roles} onChange={handleChange}>
                        <option value="USER">Выберите из списка</option>
                        <option value="USER">USER</option>
                    </select>
                    <br />
                    <input type = "submit" value="Create"/>
                </form>
            </div>
        </div>
    )

}

export default FormUserComponent;