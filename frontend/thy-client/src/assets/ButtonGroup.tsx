import React, { useState } from 'react';
import axios, { AxiosResponse, AxiosError } from 'axios';

const ButtonGroup: React.FC = () => {
  const [inputValue, setInputValue] = useState<string>('');
  const [response, setResponse] = useState<string | null>(null);

  const handleInputChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setInputValue(e.target.value);
  };

  const handleButtonClick = () => {
    // Kullanıcıdan alınan metni tamsayıya dönüştürün.
    const intValue = parseInt(inputValue, 10);

    if (!isNaN(intValue)) {
      // Sunucuya POST isteği yapın ve intValue'yi id olarak gönderin.
      axios.get('http://localhost:8080/airport/listAirportsByCountry',{params:{id:intValue}})
        .then((response: AxiosResponse) => {
          setResponse(JSON.stringify(response.data.data));
        })
        .catch((error: AxiosError) => {
          console.error('Hata:', error);
        });
    } else {
      console.error('Geçerli bir tamsayı giriniz.');
    }
  };

  return (
    <div>
      <input
        type="text"
        value={inputValue}
        onChange={handleInputChange}
        className="border p-2 mb-2"
        placeholder="Tamsayı değer girin"
      />
      <button
        className="bg-blue-500 hover-bg-blue-700 text-white font-bold py-2 px-4 rounded"
        onClick={handleButtonClick}
      >
        Gönder
      </button>
      {response !== null && <p>Sunucu Cevabı: {response}</p>}
    </div>
  );
};

export default ButtonGroup;
