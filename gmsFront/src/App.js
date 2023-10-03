
import './App.css';
import Login from './Componenets/Login';
import ChangePassword from './Componenets/ChangePassword';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import { useState } from 'react';
import AdminRoutes from './AdminRoutes';
import MemberRoutes from './MemberRoutes';
import PageNotFound from './Componenets/PageNotFound';

function App() {
  const[userRole,setUserRole]=useState(localStorage.getItem("role"));
  return (
   
    <BrowserRouter>
    <Routes>
     
      {userRole==="ADMIN" && <Route path='/*' element={<AdminRoutes/>}/>}
      { userRole==="MEMBER" && <Route path='/*' element={<MemberRoutes/>}/>}
      <Route path="/" element={<Login setUserRole={setUserRole} />}/>
      <Route path="/change-password" element={<ChangePassword />}/>
      <Route path='/*' element={<PageNotFound/>}/>
      
    </Routes>
    </BrowserRouter>
  );
}

export default App;
