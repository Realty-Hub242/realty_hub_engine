import React, { useEffect, useState } from 'react';
import axios from 'axios';
import Image from './Image';

const HomePage = () => {
  const [data, setData] = useState(null);
  const [hasResponse, setDataResponse] = useState(false);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8090/public/home');
        setData(response.data);
        setDataResponse(true);
      } catch (error) {
        console.error("Error getting data:", error);
      }
    };

    if (!hasResponse) {
      fetchData();
    }

    return () => {
      
    };
  }, [hasResponse, data]);


  if (data !== null && data !== undefined) {
    return (
      <div>
        {data.map(item => (
          <div key={item.id}>
            <p>{item.id} {item.title} {item.floor} {item.manager}</p>
            <div>
                <Image build={item.imageList[0]}/>
            </div>
          </div>
        ))}
      </div>
    );
  }

  return <div>Loading...</div>;
};

export default HomePage;
