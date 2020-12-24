import React,{useEffect} from 'react'
import axios from 'axios'


function LandingPage(){

    useEffect(() => {
        axios.get('/api/hello')
        .then(response => console.log(response))
    }, [])

    return (
        <div style={{display:'flex', justifyContent:'center', alignItems:'center'
        , width : '100%', height: '100vh'}}>
            LandingPage 입니다.
        </div>
    )
}

export default LandingPage