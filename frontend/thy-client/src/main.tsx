import React from 'react'
import ReactDOM from 'react-dom/client'
import Search from './Search.tsx'
import ButtonGroup from './assets/ButtonGroup.tsx'
import MyComponent from './assets/MyComponent.tsx'
import './index.css'

ReactDOM.createRoot(document.getElementById('root')!).render(
  <React.StrictMode>
    
    <Search />
    <div className="bg-gray-400 bg-opacity-60 w-1/2 p-4 rounded">
       <ButtonGroup/>
       <MyComponent/>
    </div>
  </React.StrictMode>,
)
