import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

    const HouseDetails = () => {

        const { id } = useParams();
        const [houseData, setHouseData] = useState(null);

        useEffect(() => {

            const fetchHouseData = async () => {
                try {
                    const response = await axios.get(`http://localhost:8090/public/details_lot/${id}`)
                    setHouseData(response.data);
                    console.log(response.data);
                } catch (error) {
                    console.error(error);
                }
            };

            fetchHouseData();

        }, [id]);

        if(houseData !== null && houseData !== null) {
            return(
                <div>
                    <h3>{houseData.title}</h3>
                    <a href="/">back</a>
                </div>
            )
        }

        return (
            <div>
                <p>Loading...</p>
            </div>
        )
    }

    export default HouseDetails;