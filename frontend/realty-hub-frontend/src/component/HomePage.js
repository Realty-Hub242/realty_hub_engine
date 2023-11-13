import React, { useEffect, useState } from 'react'
import axios from 'axios';

const HomePage = () => {
    const [data, setData] = useState(null);
    const [hasResponse, setDataResponse ] = useState(false);
    useEffect(() => {
        if(!hasResponse) {
            fetch();
        }
    })
    const fetch = async () => {
        try {
            const response = await axios.get('http://localhost:8090/public/home');
            setData(response.data);
            setDataResponse(true)
        } catch (error) {
            console.error("Error get");
        }
    }
    console.log(data);
    if(data !== null) {
        return(
            <div>
                {data.map(item => (
                    <div key={item.id}><p>{item.id} {item.name} {item.floor} {item.manager}</p></div> 
                    
                ))}
            </div>
        )
    }

    return(
        <div>
            <p></p>
        </div>
    )   
    
}

export default HomePage;