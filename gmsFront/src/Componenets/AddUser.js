import '../Styles/AddUser.css'
const AddUser = () =>{
    return(
        <>
        <div className="container">
            <form action=''>
                <h1>Add New User</h1>
                <div >
                  <label htmlFor='' >Full Name</label>
                  <input type='text' placeholder='Enter Full Name' className='form-control' required/>  
                </div>
                <div >
                  <label htmlFor='' >Username</label>
                  <input type='text' placeholder='Enter Username' className='form-control' required/>  
                </div>
                <div >
                  <label htmlFor=''>Email</label>
                  <input type='email' placeholder='Enter Email' className='form-control' required/>  
                </div>
                <div >
                  <label htmlFor=''>Password</label>
                  <input type='password' placeholder='Enter password' className='form-control' required/>  
                </div>
                
                <input type='submit' className='btn' value='Add-User'/>
                
            </form>
        </div>
        </>
    )
}
export default AddUser;