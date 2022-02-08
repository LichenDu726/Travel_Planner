import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import {
  MuiPickersUtilsProvider,
  KeyboardTimePicker,
} from "@material-ui/pickers";
import DateFnsUtils from "@date-io/date-fns";
import "./Scheduler.css";

const PlacePlan = () => {
  const [placeindex, setPlaceindex] = useState(1);

  const handleChange = (event) => {
    setPlaceindex(event.target.value);
  };

  const [selectedTime, setSelectedTime] = useState(
    new Date("2014-08-18T10:00:00")
  );

  const handleTimeChange = (time) => {
    setSelectedTime(time);
  };

  return (
    <div id="place_plan">
      <Grid
        direction="row"
        xs={12}
        justifyContent="flex-start"
        alignItems="flex-start"
      >
        <Grid item xs={12}>
          <div> ( ͡⚈ ᴥ ͡⚈) </div>
        </Grid>
        <Grid item xs={12} sm={6}>
          <FormControl>
            <InputLabel id="select place-label">Select Place</InputLabel>
            <Select
              labelId="select place-label"
              id="select place"
              value={placeindex}
              onChange={handleChange}
            >
              <MenuItem value={1}>The Museum of Modern Art</MenuItem>
              <MenuItem value={2}>
                Lincoln Center for the Performing Arts
              </MenuItem>
              <MenuItem value={3}>Central Park</MenuItem>
              <MenuItem value={4}>Statue of Liberty</MenuItem>
              <MenuItem value={5}>Bryant Park</MenuItem>
              <MenuItem value={6}>Oddities Flea Market New York City</MenuItem>
              <MenuItem value={7}>Empire State Building</MenuItem>
            </Select>
          </FormControl>
        </Grid>

        <Grid item xs={12} sm={8}>
          <MuiPickersUtilsProvider utils={DateFnsUtils}>
            <KeyboardTimePicker
              margin="normal"
              id="time-picker"
              label="Time picker"
              value={selectedTime}
              onChange={handleTimeChange}
              KeyboardButtonProps={{
                "aria-label": "change time",
              }}
            />
          </MuiPickersUtilsProvider>
        </Grid>
      </Grid>
    </div>
  );
};
export default PlacePlan;
