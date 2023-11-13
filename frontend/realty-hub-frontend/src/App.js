import LoginComponent from "./component/LoginForm";
import HomePage from "./component/HomePage";
import { BrowserRouter, Route, Routes } from "react-router-dom";

export default function App() {
  return(
      <BrowserRouter>
      <Routes>
        <Route path="/" element={<HomePage />} />
        <Route path="/login" element={<LoginComponent />} />
      </Routes>
      </BrowserRouter>
  )
}
