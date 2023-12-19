import { Link } from "react-router-dom";


const PartnerPage = () => {

    return(
        <div className="partner">
            <p>Добро пожаловать!</p>
            <br />
            <Link to="/create_build">Добавить новый объект</Link>
            <br />
            <Link to = "/create_user">Создать сотрудника</Link>
            <br />
            <Link to = "/create_client">Создать клиента</Link>
            <br />
            <Link to = "/all_builds">Просмотреть все объекты</Link>
        </div>
    )
}

export default PartnerPage;