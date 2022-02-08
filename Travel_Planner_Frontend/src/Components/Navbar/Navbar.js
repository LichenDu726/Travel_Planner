import React, { useState } from "react";

import "./Navbar.css";
import Logo from "../../assets/logos/th_logo.svg";
import { Grid, Button, TextField, IconButton } from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import InputLabel from "@material-ui/core/InputLabel";
import MenuItem from "@material-ui/core/MenuItem";
import FormControl from "@material-ui/core/FormControl";
import Select from "@material-ui/core/Select";
import useStyles from './styles'
import { Autocomplete } from '@react-google-maps/api';
import { InputBase, } from '@material-ui/core';


import { useNavigate, useLocation } from "react-router-dom";

const NavBar = ({ onPlaceChanged, onLoad }) => {
  const [value, setValue] = React.useState('');
  const navigate = useNavigate();
  const location = useLocation();
  const classes = useStyles();

  const handleChange = (event, newValue) => {
    setValue(newValue);
  };
  const handleMyAccount = () => {
    navigate("/myaccount");
  };
  const handleLogout = () => {
    navigate("/login");
  };
  const handleScheduler = () => {
    navigate("/scheduler");
  };

  const [placeindex, setPlaceindex] = useState(1);

  const handleMenuChange = (event) => {
    setPlaceindex(event.target.value);
  };

  const goToHome = () => {
    navigate("/home");
  };


  return (
    <div id="nav_bar">
      <Grid container spacing={3}>
        <Grid item className="centered" xs={3}>
          <img id="logo" src={Logo} onClick={goToHome}></img>
        </Grid>

        <Grid item className="centered" xs={2}>
          <Autocomplete onLoad={onLoad} onPlaceChanged={onPlaceChanged}>
          <div className={classes.search}>
              <div className={classes.searchIcon}>
                {/* <SearchIcon onLoad2={onLoad2} onPlaceChanged2={onPlaceChanged2}/> */}
                <SearchIcon />
              </div>
              <InputBase placeholder="Search…" classes={{ root: classes.inputRoot, input: classes.inputInput }} />
            </div>
          </Autocomplete>
        </Grid>

        {/* <Grid item xs={3.5}>
          <FormControl>
            <InputLabel
              id="select place-label"
              className="centered"
              color="secondary"
            >
              {" "}
            </InputLabel>
            <Select
              labelId="select place-label"
              className="centered"
              id="select place"
              color="secondary"
              value={placeindex}
              onChange={handleMenuChange}
            >
              <MenuItem value={1}> New York </MenuItem>
              <MenuItem value={2}> Houston </MenuItem>
              <MenuItem value={3}> Austin </MenuItem>
            </Select>
          </FormControl>
        </Grid> */}

        <Grid item className="centered" xs={3}>
          <Button
            onClick={handleLogout}
            id="login-button"
            variant="contained"
            size="large"
          >
            Logout
          </Button>
          <Button
            onClick={handleScheduler}
            id="login-button"
            variant="contained"
            size="large"
          >
            Scheduler
          </Button>
          <Button
            onClick={handleMyAccount}
            id="signup-button"
            variant="contained"
            size="large"
          >
            Account
          </Button>
        </Grid>
      </Grid>
    </div>
  );
};

export default NavBar;
