import React from 'react'
import { Routes ,Route } from 'react-router-dom'
import MemberDashboard from './Componenets/MemberDashboard'
import TicketTable from './Componenets/TicketTable'
import ViewTicket from './Componenets/ViewTicket'
import ChangePassAgain from './Componenets/ChangePassAgain'
import PageNotFound from './Componenets/PageNotFound'
import AddNewTicket from './Componenets/AddNewTicket'

function MemberRoutes() {
  return (
    <>
      <Routes>
        
        <Route path="/member" element={<MemberDashboard/>}/>
        <Route path='/get-all-ticket' element={<TicketTable/>}/>
        <Route path='/add-ticket' element={<AddNewTicket/>}/>
        <Route path='/get-my-ticket' element={<TicketTable/>}/>
        <Route path='/update-ticket/:ticketId' element={<ViewTicket/>}/>
        <Route path='/update-password' element={<ChangePassAgain/>}/>
        <Route exact path='*' element={<PageNotFound/>}/>  
         
     </Routes>
    </>
   
  )
}

export default MemberRoutes
