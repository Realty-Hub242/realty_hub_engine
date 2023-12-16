import { Link } from "react-router-dom";


const PartnerPage = () => {
    return(
        <div className="partner">
            <p>Partner Page</p>
            <br />
            <Link to="/create_build">Добавить новый объект</Link>
            <br />
            <Link to = "/create_user">Создать сотрудника</Link>
        </div>
    )
}

export default PartnerPage;