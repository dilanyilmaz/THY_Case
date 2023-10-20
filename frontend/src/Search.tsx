import MyComponent from "./assets/MyComponent";
function Search() {
  return (

    <div className="grid grid-cols-3 gap-4 place-items-center h-full bg-sky-900">

        <div className="place-items-center" style={{ width: '650px',position:"absolute"}}>
        <h1 className="text-center text-4xl  text-white">Merhaba</h1>
        <h1 className="text-center text-3xl  mb-2 text-white">Nereyi keşfetmek istersiniz?</h1>
          <MyComponent/>
        </div>
    </div>

  );
}

export default Search
