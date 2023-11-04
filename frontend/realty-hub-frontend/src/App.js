import {BrowserRouter, Navigate, Route, Router, Routes} from "react-router-dom";
import Congratulations from "./component/Congratulations";
import LoginComponent from "./component/LoginForm";
import {Suspense} from "react";
function App() {
  return (
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<LoginComponent/>}/>
          <Route path="home" element={<Congratulations/>}/>
          <Route path="/redirect" element={<Navigate to ="/home"/>}/>
        </Routes>
      </BrowserRouter>
  );
}

export default App;
