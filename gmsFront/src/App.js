
import './App.css';
import Header from './Componenets/Header';
import Footer from './Componenets/Footer';
import Login from './Componenets/Login';
import ChangePassword from './Componenets/ChangePassword';
import Home from './Componenets/Home';
import AddNewUser from './Componenets/AddNewUser';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AddNewTicket from './Componenets/AddNewTicket';
import { useState } from 'react';
import AdminRoutes from './AdminRoutes';
import MemberRoutes from './MemberRoutes';
import AdminDashboard from './Componenets/AdminDashboard';
import PageNotFound from './Componenets/PageNotFound';
import ViewTicket from './Componenets/ViewTicket';
import ChangePassAgain from './Componenets/ChangePassAgain';
import TicketTable from './Componenets/TicketTable';

// import AddUser from './Componenets/AddUser';
function App() {
  const[userRole,setUserRole]=useState(localStorage.getItem("role"));
  return (
   
    <BrowserRouter>
    <Routes>
     
      {userRole==="ADMIN" && <Route path='/*' element={<AdminRoutes/>}/>}
      { userRole==="MEMBER" && <Route path='/*' element={<MemberRoutes/>}/>}
      <Route path='/' element={<Home/>}/>
      <Route path="/login" element={<Login />}/>
      <Route path="/change-password" element={<ChangePassword />}/>
      
    </Routes>
    </BrowserRouter>
    // <ViewTicket/>
    // <ChangePassAgain/>
    // <TicketTable/>
  );
}

export default App;
