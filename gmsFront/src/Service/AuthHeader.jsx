import React from 'react'

export default function AuthHeader() {
    const username = JSON.parse(localStorage.getItem('user'))?.email;
    const encodedPassword = JSON.parse(localStorage.getItem('user'))?.encodePassword;
    console.log(username);
    console.log(encodedPassword);
    return (
    <div>
      
    </div>
  )
}
