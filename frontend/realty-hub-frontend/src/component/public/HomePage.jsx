import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { Link } from "react-router-dom";
import Image from '../Image';

const HomePage = () => {
  const [data, setData] = useState(null);
  const [hasResponse, setDataResponse] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8090/public/home');
        console.log(response);
        setData(response.data);
        setDataResponse(true);
      } catch (error) {
        console.error("Error getting data:", error);
      }
    };

    if (!hasResponse) {
      fetchData();
    }

  }, [hasResponse, data]);


  if (data !== null && data !== undefined) {
    return (
      <div>
        <div className='header'>
          <a href="/login">login</a>
        </div>
        {data.map(item => (
          <div key={item.id}>
            <p>component</p>
            <Link to={`/details/${item.id}`}>
              {item.title}
            </Link>
            <br />
            <br />
            <p>{item.id} {item.title} {item.floor} {item.manager}</p>
            <div>
                <Image build={item.imageList}/>
            </div>
          </div>
        ))}
      </div>
    );
  }

  return (
    <div className='general'>
      <div>
        <p>Loading...</p>
      </div>
    </div>);
};

export default HomePage;
