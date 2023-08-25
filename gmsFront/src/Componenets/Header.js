import Login from './Login';
import '../Styles/Header.css'
import { Link } from 'react-router-dom';
const Header =()=>{
       return(
        <>
        <nav >
            <label className="logo">Grievance Management</label>
            <ul>
                <li><a className="active" href="#">Home</a></li>
                <li><Link to="/login">Login</Link></li>
                <li><a href="#">About</a></li>
            </ul>
        </nav>
        </>
        
        
       )
}
export default Header;