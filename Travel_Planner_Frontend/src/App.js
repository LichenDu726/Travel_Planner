import React from "react";
import { BrowserRouter, Routes, Route, } from "react-router-dom";
import Login from "./Components/Authentication/Login/Login";
import SignUp from "./Components/Authentication/Signup/Signup";
import Plandetail from "./Components/Plandetail/Plandetail";
import PlaceDetailsPage from "./Components/PlaceDetails/PlaceDetailsPage";
import MyAccount from "./Components/MyAccount/MyAccount";
import Scheduler from "./Components/Scheduler/Scheduler";

// this component should be a root router file
function App() {
  return (

    <BrowserRouter>
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/signup" element={<SignUp />} />
        <Route path="/plan" element={<Plandetail />} />
        <Route path="/scheduler" element={<Scheduler />} />
        <Route path="/home" element={<PlaceDetailsPage />} />
        <Route path="/myaccount" element={<MyAccount />} />
      </Routes>
    </BrowserRouter>

  );
}

export default App;
