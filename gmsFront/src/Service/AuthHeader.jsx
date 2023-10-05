export default function AuthHeader() {
    const username = JSON.parse(localStorage.getItem('user'))?.email;
    const encodedPassword = JSON.parse(localStorage.getItem('user'))?.encodePassword;
    if(username && encodedPassword){
        return {username: username, encodePassword :encodedPassword}
    }else{
        return {}
    }
}
