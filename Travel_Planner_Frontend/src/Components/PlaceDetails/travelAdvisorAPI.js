import axios from 'axios';


export const getPlacesData = async (type, sw, ne) => {
  try {
    const { data: { data } } = await axios.get(`https://travel-advisor.p.rapidapi.com/restaurants/list-in-boundary`, {
      params: {
        bl_latitude: sw.lat,
        bl_longitude: sw.lng,
        tr_longitude: ne.lat,
        tr_latitude: ne.lng,
      },
      headers: {
        'x-rapidapi-key': '9997c92e07msh8cfbf87b605d379p1d85c3jsnd286ccdab442',
        'x-rapidapi-host': 'travel-advisor.p.rapidapi.com',
      },
    });

    return data;
  } catch (error) {
    console.log(error);
  }
};

