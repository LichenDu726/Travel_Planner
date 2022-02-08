import React, { useState } from "react";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Snackbar from "@material-ui/core/Snackbar";
import IconButton from "@material-ui/core/IconButton";
import CloseIcon from "@material-ui/icons/Close";

import { Link, useNavigate, useLocation } from "react-router-dom";

import Logo from "../../../assets/logos/th_logo.svg";
import LoginPhoto from "../../../assets/images/login_img.jpeg";
import useLogin from "../../../hooks/use-login/index";

import "./Login.css";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    flexWrap: "wrap",
  },
  textField: {
    width: "45ch",
  },
  button: {
    width: "30ch",
  },
}));

const Login = () => {
  const style = useStyles();
  const navigate = useNavigate();
  const location = useLocation();

  const { isLoggingIn, login } = useLogin();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  // Hooks for alert
  const [open, setOpen] = useState(false);
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const name = login({
      username,
      password,
    });

    if (name === undefined) {
      setMessage("Login unsuccessful");
      setOpen(true);
    } else {
      setOpen(true);
      goToHome();
    }
  };

  const goToHome = () => {
    navigate("/home");
  };

  const handleClose = (event, reason) => {
    if (reason === "clickaway") {
      return;
    }
    setOpen(false);
  };

  return (
    <div id="login-view">
      <img id="logo" src={Logo} onClick={goToHome} />
      <Grid
        container
        direction="row"
        xs={12}
        justifyContent="space-around"
        alignItems="center"
      >
        <Grid item xs={12} sm={6}>
          <div className="lv_form">
            <form noValidate autoComplete="off" onSubmit={handleSubmit}>
              <Grid
                container
                direction="column"
                className="lv_form-container"
                spacing={5}
                justifyContent="space-evenly"
                alignItems="stretch"
              >
                <Grid item xs={12}>
                  <div className="lv_form-header"> ( ͡⚈ ᴥ ͡⚈) </div>
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    required
                    onChange={(event) => setUsername(event.target.value)}
                    className={style.textField}
                    id="outlined-required"
                    label="Username"
                    variant="outlined"
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    required
                    onChange={(e) => setPassword(e.target.value)}
                    className={style.textField}
                    id="outlined-required"
                    label="Password"
                    variant="outlined"
                    type="password"
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button
                    className={style.button}
                    type="submit"
                    id="login-button"
                    variant="contained"
                    color="secondary"
                  >
                    Login
                  </Button>
                </Grid>

                <Grid item xs={12}>
                  <div id="login_link">
                    <span> Not registered yet? </span>
                    <Link
                      to={{ pathname: "/signup", from: location.from }}
                      replace
                    >
                      Create an Account
                    </Link>
                  </div>
                </Grid>
              </Grid>
            </form>
          </div>
        </Grid>

        <Grid item xs={12} sm={6}>
          <img className="sl_photo" src={LoginPhoto}></img>
        </Grid>
      </Grid>

      <Snackbar
        anchorOrigin={{
          vertical: "bottom",
          horizontal: "left",
        }}
        open={open}
        autoHideDuration={6000}
        onClose={handleClose}
        message={message}
        action={
          <React.Fragment>
            <IconButton
              size="small"
              aria-label="close"
              color="inherit"
              onClick={handleClose}
            >
              <CloseIcon fontSize="small" />
            </IconButton>
          </React.Fragment>
        }
      />
    </div>
  );
};

export default Login;
