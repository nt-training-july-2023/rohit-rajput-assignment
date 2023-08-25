
import './App.css';
import Header from './Componenets/Header';
import Footer from './Componenets/Footer';
import Login from './Componenets/Login';
import Home from './Componenets/Home';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
// import AddUser from './Componenets/AddUser';
function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Home/>}/>
      <Route path='/login' element={<Login/>}/>
    </Routes>
    </BrowserRouter>
    // <div >
      
    //    <Header/>
    //    <Login/>
    //    {/* <AddUser/> */}
    //    <Footer/>
      
    // </div>
  );
}

export default App;
