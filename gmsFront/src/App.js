
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

// import AddUser from './Componenets/AddUser';
function App() {
  const[userRole,setUserRole]=useState(localStorage.getItem("role"));
  return (
    // <BrowserRouter>
    // <Routes>
    //   <Route path="/" element={<Home/>}/>
    //   <Route path='/login' element={<Login/>}/>
    //   <Route path='/changepassword' element={<ChangePassword/>}/>
    //   <Route path='/admin' element={<AddNewUser/>}/>
    //   <Route path='/newticket' element={<AddNewTicket/>}/>
    // </Routes>
    // </BrowserRouter>
    // <div >
    // <> 
    //    <Header/>
    //   <Login/>
    //   {/* //  <AddUser/>  */}
    //   {/* <AddNewUser/> */}
    //    <Footer/>
    //    </>  
    // </div>
    // <AddNewUser/>

    // <BrowserRouter>
    // <Routes>
    //   <Route path='/' element={<Home/>}/>
    //   {
    //     userRole ? isFisrtLogin ? <Route path='/change-password' element={<ChangePassword firstLogin={setIsFirstLogin}/>}/>
    //     :(
    //       <>
    //       { userRole==="ADMIN" && <Route path='/admin' element ={<AdminRoutes />}/>}
    //       { userRole==="MEMBER" && <Route path='/member' element ={<MemberRoutes/>}/>}
    //       </>
    //     )
    //     :<Route path='/login' element={<Login firstLogin={setIsFirstLogin} role={setUserRole}/>}/>
    //   }
    //   <Route exact path='*' element={<PageNotFound/>}/>
    // </Routes>
    // </BrowserRouter>

    // <AdminDashboard/>

    <BrowserRouter>
    <Routes>
     
      {userRole==="ADMIN" && <Route path='/*' element={<AdminRoutes/>}/>}
      { userRole==="MEMBER" && <Route path='/*' element={<MemberRoutes/>}/>}
      <Route path='/' element={<Home/>}/>
      <Route path="/login" element={<Login />}/>
      <Route path="/change-password" element={<ChangePassword />}/>
      
    </Routes>
    </BrowserRouter>
  );
}

export default App;
