import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import PlacePlan from "./PlacePlan";
import { Button } from "@material-ui/core";

const DailyPlan = (props) => {
  const [count, setCount] = useState(1);
  const [dayNumber, setDayNumber] = useState(props.day);

  const handleClick = () => {
    setCount(count + 1);
  };

  return (
    <div>
      <Grid
        direction="column"
        xs={12}
        justifyContent="flex-start"
        alignItems="flex-start"
      >
        <Grid item xs={12}>
          <div id="dayliPlan_title"> ʕ•́ᴥ•̀ʔ Day {dayNumber} </div>
        </Grid>
        <Grid item xs={12} sm={6}>
          {Array(count).fill(<PlacePlan />)}
        </Grid>

        <Grid item xs={12} sm={6}>
          <Button
            //className={style.button}
            onClick={handleClick}
            type="submit"
            id="scheduler-button"
            variant="contained"
            color="secondary"
          >
            Add a Place
          </Button>
        </Grid>
      </Grid>
    </div>
  );
};

export default DailyPlan;
