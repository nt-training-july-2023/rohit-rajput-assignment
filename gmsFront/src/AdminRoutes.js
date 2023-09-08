import React from 'react'
import {Routes ,Route } from 'react-router-dom'
import AdminDashboard from './Componenets/AdminDashboard'
import PageNotFound from './Componenets/PageNotFound'
import AddNewUser from './Componenets/AddNewUser'
import AddDepartment from './Componenets/AddDepartment'
import AddNewTicket from './Componenets/AddNewTicket'

function AdminRoutes() {
    
  return (
    <>

    {/* <AdminDashboard/> */}
 
    <Routes>
        
       <Route path="/admin" element={<AdminDashboard/>}/>
       <Route path="/add-user" element={<AddNewUser/>}/>
       <Route path="/add-department" element={<AddDepartment/>}/>
       <Route path='/add-ticket' element={<AddNewTicket/>}/>

       <Route exact path='*' element={<PageNotFound/>}/>    
        
    </Routes>
    
    </>
  )
}

export default AdminRoutes