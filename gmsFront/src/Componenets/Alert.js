import { useState } from 'react';
import '../Styles/Alert.css'
const Alert = (props) =>{
   const[isShow,setIsShow]=useState(props.onClose)
   const[message, setMessage]=useState(props.message)

   const onClose=()=>{
    setIsShow(false);
    setMessage("");
   }
   return(
        <div className="alert">
            <div className="alert-content">
               <p>{message}</p>
               <button onClick={onClose}>Close</button>
            </div>
        </div>
    )
}

export default Alert;