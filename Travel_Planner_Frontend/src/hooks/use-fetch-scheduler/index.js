import axios from "axios";
import { useState } from "react";

export const useFetch = () => {
  const [isFetching, setIsFetching] = useState(false);

  const fetchPlaces = async ({ username }) => {
    setIsFetching(true);
    const fetch_url =
      "https://travelplanner-333314.uc.r.appspot.com/user/scheduler/get/" +
      username;
    // const opt = {
    //     headers: {
    //         Authorization: 'Bearer ${localStorage.getItem(Token_Key)}',
    //     }
    // }
    try {
      console.log("fetching");
      const response = await axios.get(fetch_url);
      console.log("done");

      if (response.status === 200) {
        return response.data.places;
      }
    } catch (err) {
      console.log(err.message);
    } finally {
      setIsFetching(false);
    }
  };

  return { isFetching, fetchPlaces };
};

export default useFetch;
