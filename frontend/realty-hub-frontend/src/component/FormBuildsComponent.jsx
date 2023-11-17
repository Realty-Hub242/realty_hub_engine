import { useState } from "react";
import axios from 'axios';

const FormBuildsComponent = () => {

    const[msg, setMsg] = useState("");

    const API_URL = "http://localhost:8090/public";

    const [Builds, setBuilds] = useState({
        type : "",
        name_build : "",
        description : "",
        price : "",
        square_footage : "",
        count_of_bedrooms : "",
        count_of_bathrooms : "",
        city : "",
        view : "",
        distance_to_beach : "",
        floor : "",
        number_of_stores : "",
        type_of_dev : "",
        geo : "",
        manager : "",
        contact : "",
        image : null
    });

    const save = (builds) => {
        return axios.post(API_URL + "/create_builds", builds);
    }



    const handleChange = e => {
        const {name , value} = e.target;
        setBuilds({...Builds, [name]:value})
    }

    const handleImageChange = (e) => {
        setBuilds({ ...Builds, image: e.target.files[0] });
    };

    const CreateBuilds = (e) => {
        e.preventDefault();
        console.log(Builds);
        save(Builds)
            .then((res) => {
                console.log("Builds add");
                setMsg("Used Added Sucessfully");
                setBuilds({
                    type : "",
                    name_build : "",
                    description : "",
                    price : "",
                    square_footage : "",
                    count_bedrooms : "",
                    count_bathrooms : "",
                    city : "",
                    view : "",
                    distance_to_beach : "",
                    floor : "",
                    number_of_stores : "",
                    type_of_dev : "",
                    geo : "",
                    manager : "",
                    contact : "",
                    image : null
                })
            }).catch((error) => {
                console.log(error);
            });

    }

    return(
        <div>
            <form onSubmit={(e) => CreateBuilds(e)}>
                <label>
                    Тип постройки
                    <br/>
                    <select name="type" value={Builds.type} onChange={handleChange}>
                        <option value="">Выберите из списка</option>
                        <option value="Студии">Студии</option>
                        <option value="Квартиры">Квартиры</option>
                        <option value="Дома">Дома</option>
                        <option value="Виллы">Виллы</option>
                        <option value="Участки">Участки</option>
                    </select>
                </label>
                <br/>
                <label>Название</label>
                <input type = "text" name="name_build" value={Builds.name} onChange={handleChange}/>
                <br/>
                <label>Описание</label>
                <input type = "text" name="description" value={Builds.description} onChange={handleChange}/>
                <br/>
                <label>Цена</label>
                <input type = "number" name = "price" value={Builds.price} onChange={handleChange}/>
                <br/>
                <label>Метраж</label>
                <input type = "number" name = "square_footage" value={Builds.square_footage} onChange={handleChange}/>
                <br/>
                <label>Спален кол-во</label>
                <input type = "number" name="count_of_bedrooms" value={Builds.count_bedrooms} onChange={handleChange}/>
                <br/>
                <label>Санузлов кол-во</label>
                <input type = "number" name="count_of_bathrooms" value={Builds.count_bathrooms} onChange={handleChange}/>
                <br/>
                <label>Город
                    <br/>
                    <select name="city" value={Builds.city} onChange={handleChange}>
                    <option value="">Выберите из списка</option>
                    <option value="Бар">Бар</option>
                    <option value="Будва">Будва</option>
                    <option value="Херцег-Нови">Херцег-Нови</option>
                    <option value="Котор">Котор</option>
                    <option value="Никшич">Никшич</option>
                    <option value="Петровац">Петровац</option>
                    <option value="Подгорица">Подгорица</option>
                    <option value="Прчань">Прчань</option>
                    <option value="Рисан">Рисан</option>
                    <option value="Сутоморе">Сутоморе</option>
                    <option value="Свети-Стефан">Свети-Стефан</option>
                    <option value="Тиват">Тиват</option>
                    <option value="Улцинь">Улцинь</option>
                    <option value="Жабляк">Жабляк</option>
                    <option value="Колашин">Колашин</option>
                    <option value="Баосичи">Баосичи</option>
                    <option value="Донья-Костаница">Донья-Костаница</option>
                    <option value="Доньи-Стой">Доньи-Стой</option>
                    <option value="Игало">Игало</option>
                    <option value="Плав">Плав</option>
                    <option value="Радановичи">Радановичи</option>
                    <option value="Свети Никола">Свети Никола</option>
                    <option value="Андриевица">Андриевица</option>
                    <option value="Бериславци">Бериславци</option>
                    <option value="Бигово">Бигово</option>
                    <option value="Биела">Биела</option>
                    <option value="Биело-Поле">Биело-Поле</option>
                    <option value="Даниловград">Даниловград</option>
                    <option value="Добра-Вода">Добра-Вода</option>
                    <option value="Каменари">Каменари</option>
                    <option value="Мойковац">Мойковац</option>
                    <option value="Пераст">Пераст</option>
                    <option value="Утьеха">Утьеха</option>
                    <option value="Цетине">Цетине</option>
                    <option value="Чань">Чань</option>
                    </select>
                </label>
                <br/>
                <label>Вид</label>
                <input type = "text" name="view" value={Builds.view} onChange={handleChange}/>
                <br/>
                <label>До пляжа</label>
                <input type = "number" name="distance_to_beach" value={Builds.distance_to_beach} onChange={handleChange}/>
                <br/>
                <label>Этаж</label>
                <input type = "number" name="floor" value={Builds.floor} onChange={handleChange}/>
                <br/>
                <label>Этажность</label>
                <input type = "number" name="number_of_stores" value={Builds.number_of_stores} onChange={handleChange}/>
                <br/>
                <label>Тип застройки
                    <br/>
                    <select name="type_of_dev" value={Builds.type_of_dev} onChange={handleChange}>
                        <option value="">Выберите из списка</option>
                        <option value="Новостройка">Новостройка</option>
                        <option value="Вторичная">Вторичная</option>
                    </select>
                </label>
                <br/>
                <label>Геолокация</label>
                <input type = "text" name="geo" value={Builds.geo} onChange={handleChange}/>
                <br/>
                <label>Менеджер</label>
                <input type = "text" name="manager" value={Builds.manager} onChange={handleChange}/>
                <br/>
                <label>Контакты</label>
                <input type = "text" name="contact" value={Builds.contact} onChange={handleChange}/>
                <br/>
                <label>Photo</label>
                <input type = "file" name="image" onChange={handleImageChange} accept="image/*"/>
                <br/>
                <input type = "submit" value="Create"/>
            </form>
        </div>
    )
}

export default FormBuildsComponent;