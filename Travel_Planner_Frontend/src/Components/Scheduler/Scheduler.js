import { Button } from "@material-ui/core";
import { useState, useEffect } from "react";
import NavBar from "../Navbar/Navbar";
import useFetch from "../../hooks/use-fetch-scheduler/index";
import DailyPlan from "./DailyPlan";
import PlaceList from "./PlaceList";
import { Grid, Divider } from "@material-ui/core";
import { Link, useNavigate, useLocation } from "react-router-dom";

const Scheduler = () => {
  const { isFetching, fetchPlaces } = useFetch();
  const [places, setPlaces] = useState([]);
  const [day_counter, setDayCounter] = useState(1);

  const navigate = useNavigate();
  const location = useLocation();

  //   useEffect( () => {
  //     fetchPlaces(

  //     ).then()

  //   }, []);np

  const handleClick = () => {
    setDayCounter(day_counter + 1);
  };

  const handleGenerate = () => {
    navigate("/plan");
  };

  return (
    <div>
      <NavBar />
      <div id="place_list">
        <PlaceList />
      </div>
      <Grid
        direction="column"
        xs={12}
        justifyContent="flex-start"
        alignItems="flex-start"
      >
        <Grid item xs={12}>
          {Array(day_counter).fill(<DailyPlan day={day_counter} />)}
        </Grid>

        <Divider variant="middle" />

        <Button id="scheduler-button1" onClick={handleClick}>
          {" "}
          Add a Day
        </Button>
        <Button id="scheduler-button2" onClick={handleGenerate}>
          Generate
        </Button>
      </Grid>
    </div>
  );
};

export default Scheduler;
