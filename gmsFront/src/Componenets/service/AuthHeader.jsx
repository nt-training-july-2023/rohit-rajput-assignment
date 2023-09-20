import React from 'react'

export default function AuthHeader() {
    const username = JSON.parse(localStorage.getItem('user'))?.username;
    const encodedPassword = JSON.parse(localStorage.getItem('user'))?.encodedPassword;
    console.log(username);
    console.log(encodedPassword);
    return (
    <div>
      
    </div>
  )
}
