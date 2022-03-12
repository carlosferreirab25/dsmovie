import axios from "axios";
import MovieCard from "components/Navbar/MovieCard";


import Pagination from "components/Navbar/Pagination";
import { useEffect, useState } from "react";
import { MoviePage } from "types/movie";
import { BASE_URL } from "ultils/requests";

function Listing() {

    const[pageNumber, setPageNumber] = useState(0);

    useEffect(() =>{
        axios.get(`${BASE_URL}/movies?size=12&page=1`)
        .then(response =>{
            const data = response.data as MoviePage;
            setPageNumber(data.number);
        });
    },[]);

    //FORMA ERRADA
   

    return (
        <>
        <p>{pageNumber}</p>
            <Pagination />

            <div className="container">
                <div className="row">
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl- mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    <div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div><div className="col-sm-6 col-lg-4 col-xl-3 mb-3">
                        <MovieCard />
                    </div>
                    

                </div>
            </div>




        </>


    )
}

export default Listing;