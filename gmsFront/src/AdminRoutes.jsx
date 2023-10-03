import React from 'react'
import {Routes ,Route } from 'react-router-dom'
import AdminDashboard from './Componenets/AdminDashboard'
import AddNewUser from './Componenets/AddNewUser'
import AddDepartment from './Componenets/AddDepartment'
import AddNewTicket from './Componenets/AddNewTicket'
import TicketTable from './Componenets/TicketTable'
import ViewTicket from './Componenets/ViewTicket'
import ChangePassAgain from './Componenets/ChangePassAgain'
import AllUserTable from './Componenets/AllUserTable'
import PageNotFound from './Componenets/PageNotFound'
import AllDepartmentTable from './Componenets/AllDepartmentTable'

function AdminRoutes() {
    
  return (
    <>
 
    <Routes>
       <Route path="/admin" element={<TicketTable/>}/>
       <Route path='/get-all-user' element={<AllUserTable/>}/>
       <Route path="/add-user" element={<AddNewUser/>}/>
       <Route path="/add-department" element={<AddDepartment/>}/>
       <Route path='/all-department' element={<AllDepartmentTable/>}/>
       <Route path='/add-ticket' element={<AddNewTicket/>}/>
       <Route path='/get-all-ticket' element={<TicketTable/>}/>
       <Route path='/get-my-ticket' element={<TicketTable/>}/>
       <Route path='/update-ticket/:ticketId' element={<ViewTicket/>}/>
       <Route path='/update-password' element={<ChangePassAgain/>}/>
       <Route exact path='*' element={<PageNotFound/>}/>  
       <Route exact path='/login' element={<AdminDashboard/>} /> 
        
    </Routes>
    
    </>
  )
}

export default AdminRoutes