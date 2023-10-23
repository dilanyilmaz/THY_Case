import React, { useState, useEffect } from 'react';
import { FaPlayCircle, FaCalendar ,FaAngleRight} from 'react-icons/fa';
import { MdOutlineMan2,MdFlightTakeoff,MdFlightLand ,MdCalendarMonth} from "react-icons/md";
import axios from 'axios';
import querystring from 'querystring';

const MyComponent: React.FC = () => {
  const [cities, setCities] = useState<any[]>([]);
  const [selectedCity, setSelectedCity] = useState<string>('');
  const [airports, setAirports] = useState<any[]>([]);
  const [accessToken, setAccessToken] = useState(null);

  useEffect(() => {
    const tokenRequestData = {
      grant_type: 'password',
      client_id: 'thy-keycloak',
      username: 'thy-backend',
      password: 'thy1234',
      scope: 'openid',
    };

    // Axios ile POST isteği oluşturarak token alma işlemini gerçekleştirin
    axios
      .post('http://localhost:8080/realms/thy/protocol/openid-connect/token', null, {
        params: tokenRequestData,
        auth: {
          username: 'thy-backend',
          password: 'thy1234',
        },
      })
      .then((response) => {
        const newAccessToken = response.data.access_token;
        setAccessToken(newAccessToken);
      })
      .catch((error) => {
        console.error('Token alma hatası:', error);
      });
  }, []);

 useEffect(() => {
    if (accessToken) {
      axios
        .get('http://localhost:9090/api/airport/listAirports', {
          headers: {
            'Authorization': `Bearer ${accessToken}`,
          },
        })
        .then((response) => {
          setCities(response.data.data);
        })
        .catch((error) => {
          console.error('API isteği hatası:', error);
        });
    }
  }, [accessToken]);



  useEffect(() => {
    if (selectedCity) {
      axios.get(`http://localhost:8080/airport/listAirportsByCountry?id=${selectedCity}`)
        .then((response) => {
          setAirports(response.data.data);
        })
        .catch((error) => {
          console.error('Hata:', error);
        });
    }
  }, [selectedCity]);

  const handleCityChange = (e: React.ChangeEvent<HTMLSelectElement>) => {
    setSelectedCity(e.target.value);
  };

  const handleButtonClick = () => {
    // Seçilen şehrin havaalanlarını göster
    console.log('Seçilen Şehir ID:', selectedCity);
    console.log('Havaalanları:', airports);
  };

  return (
    <div className="w-max bg-gray-400 bg-opacity-60  px-8 py-6">
        <div className="flex space-x-2 ">

            <select onChange={handleCityChange} value={selectedCity} 
                className="border font-bold text-gray-600 bg-white px-10 py-2 "
                >
                    <FaPlayCircle />
                    <option>Nereden</option>
                {cities.map((city) => (
                    <option key={city.id} value={city.id}>
                    {city.city}
                    </option>
                ))}
                </select>

            <select onChange={handleCityChange} value={selectedCity} 
                className="border font-bold text-gray-600 bg-white px-10 py-2 ">
                   <MdFlightTakeoff className="w-5 h-5 mr-2" />
                    <option value="">Nereye</option>
                {cities.map((city) => (
                    <option key={city.id} value={city.id}>
                    {city.city}
                    </option>
                ))}
                </select>

            <div className="relative bg-sky-950 py-2 px-4">
                <label>
                    <div className="flex items-center" style={{ paddingTop: '18px' }}>
                        <MdCalendarMonth className="text-white mr-2" /> 
                        <span className="text-white mr-2">Tarih</span>
                    </div>
                 </label>
            </div>
            <div className=" relative bg-sky-950 font-bold text-white py-2 px-4">
                <label>
                <div className="flex items-center py-2 px-4 " style={{ marginLeft: '20px' }}>
                    1
                 </div>
                 <div className="flex items-center" style={{ marginTop:'-14px', paddingLeft: '15px' }}>
                    <MdOutlineMan2 size={24} className="text-white" />

                 </div>
                 </label>
            </div>

        <button onClick={handleButtonClick}
            className="bg-red-500 hover-bg-blue-700 text-white font-bold py-2 px-4 ">
        <FaAngleRight style={{ height:'40px', width:'20px'}} />
        </button>

        </div>
   </div> 
  );
};

export default MyComponent;