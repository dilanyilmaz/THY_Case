import React, { useState, useEffect } from 'react';
import { FaPlayCircle, FaCalendar ,FaAngleRight} from 'react-icons/fa';
import { MdOutlineMan2,MdFlightTakeoff,MdFlightLand ,MdCalendarMonth} from "react-icons/md";
import axios from 'axios';

const MyComponent: React.FC = () => {
  const [cities, setCities] = useState<any[]>([]);
  const [selectedCity, setSelectedCity] = useState<string>('');
  const [airports, setAirports] = useState<any[]>([]);



  // Şehir verilerini almak için GET isteği yapar.
  useEffect(() => {
    axios.get('http://localhost:8080/city/list')
      .then((response) => {
        setCities(response.data.data);
      })
      .catch((error) => {
        console.error('Hata:', error);
      });
  }, []);

  // Seçilen şehir değiştikçe havaalanı verilerini almak için GET isteği yapar.
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
                className="border font-bold text-gray-600 bg-white px-10 py-2 "
                >
                    <FaPlayCircle />
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