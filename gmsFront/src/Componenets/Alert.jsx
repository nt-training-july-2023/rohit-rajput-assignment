import '../Styles/Alert.css'
const Alert = (props) =>{
   return(
        <div className="alert">
            <div className="alert-container">
               <p>{props.message}</p>
               <button onClick={props.close}>Close</button>
            </div>
        </div>
    )
}

export default Alert;