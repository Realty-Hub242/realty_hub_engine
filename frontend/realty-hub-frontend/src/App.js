import LoginComponent from "./component/LoginForm";
import HomePage from "./component/HomePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import FormBuildsComponent from "./component/FormBuildsComponent";

export default function App() {
  return(
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginComponent />} />
        <Route path="/create_build" element={<FormBuildsComponent/>} />
      </Routes>
      </BrowserRouter>
  )
}
