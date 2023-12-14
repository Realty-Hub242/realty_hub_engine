import LoginComponent from "./features/LoginForm";
import HomePage from "./component/HomePage";
import HouseDetails from './component/HouseDetails';
import { BrowserRouter, Navigate, Route, Routes } from "react-router-dom";
import FormBuildsComponent from "./features/FormBuildsComponent";
import Cookies from "js-cookie";
import PartnerPage from "./component/PartnerPage";
import FormUserComponent from "./features/FormUserComponent";

const ProtectedRoute = ({ element }) => {
  const token = Cookies.get('token');

  if(!token) {
    return <Navigate to = "/login"/>
  } else {
    return element;
  }

}

const App = () => {
  return(
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<HomePage />} />
      <Route path="/login" element={<LoginComponent />} />
      <Route path="/details/:id" element={<HouseDetails />} />
      <Route path="/partner_page" element={<ProtectedRoute element={ <PartnerPage/> } /> } />
      <Route path="/create_build" element={<ProtectedRoute element={ <FormBuildsComponent/> } /> } />
      <Route path="/create_user" element={<ProtectedRoute element={<FormUserComponent/> } /> } />
    </Routes>
    </BrowserRouter>
)
}

export default App;
