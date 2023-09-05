
import './App.css';
import Header from './Componenets/Header';
import Footer from './Componenets/Footer';
import Login from './Componenets/Login';
import Home from './Componenets/Home';
import AddNewUser from './Componenets/AddNewUser';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import AddNewTicket from './Componenets/AddNewTicket';
// import AddUser from './Componenets/AddUser';
function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path='/login' element={<Login/>}/>
      <Route path='/admin' element={<AddNewUser/>}/>
      <Route path='/newticket' element={<AddNewTicket/>}/>
    </Routes>
    </BrowserRouter>
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
  );
}

export default App;
