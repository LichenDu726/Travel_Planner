import React, { useState } from "react";
import { Link, useNavigate, useLocation } from "react-router-dom";
import { makeStyles } from "@material-ui/core/styles";
import Grid from "@material-ui/core/Grid";
import TextField from "@material-ui/core/TextField";
import Button from "@material-ui/core/Button";
import Snackbar from "@material-ui/core/Snackbar";
import IconButton from "@material-ui/core/IconButton";
import CloseIcon from "@material-ui/icons/Close";

import SignUpPhoto from "../../../assets/images/signup_img.jpeg";
import Logo from "../../../assets/logos/th_logo.svg";
import useSignup from "../../../hooks/use-signup/index";

import "./Signup.css";

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

const SignUp = () => {
  const style = useStyles();

  const { isSigningup, signup } = useSignup();
  const navigate = useNavigate();
  const location = useLocation();

  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [repeatPassword, setRepeatpassword] = useState("");

  // Hooks for alert
  const [open, setOpen] = useState(false);
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    const response = await signup({
      username,
      password,
      repeatPassword,
    });

    if (response === 200) {
      setMessage("Successfully signed up, please login");
    } if (password !== repeatPassword) {
      setMessage("different password");
    }
    setOpen(true);
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
    <div id="signup-view">
      <img id="logo" src={Logo} onClick={goToHome} />

      <Grid
        container
        direction="row"
        xs={12}
        justifyContent="space-around"
        alignItems="center"
      >
        <Grid item xs={12} sm={6}>
          <img className="su_photo" src={SignUpPhoto}></img>
        </Grid>

        <Grid item xs={12} sm={6}>
          <div className="su_form">
            <form noValidate autoComplete="off" onSubmit={handleSubmit}>
              <Grid
                container
                direction="column"
                className="su_form-container"
                spacing={5}
                justifyContent="space-evenly"
                alignItems="stretch"
              >
                <Grid item xs={12}>
                  <div className="su_form-header"> ʕ•́ᴥ•̀ʔ </div>
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    required
                    onChange={(e) => setUsername(e.target.value)}
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
                  />
                </Grid>

                <Grid item xs={12}>
                  <TextField
                    required
                    onChange={(e) => setRepeatpassword(e.target.value)}
                    className={style.textField}
                    id="outlined-required"
                    label="Confirm Password"
                    variant="outlined"
                  />
                </Grid>

                <Grid item xs={12}>
                  <Button
                    // loading={isSigningup}
                    type="submit"
                    className={style.button}
                    id="signup-button"
                    variant="contained"
                    color="secondary"
                  >
                    {/* {!isSigningup && 'Sign Up'} */}
                    Submit
                  </Button>
                </Grid>

                <Grid item xs={12}>
                  <div id="su_link">
                    <span>Already have an Account? </span>
                    <Link
                      to={{ pathname: "/login", from: location.from }}
                      replace
                    >
                      Login
                    </Link>
                  </div>
                </Grid>
              </Grid>
            </form>
          </div>
        </Grid>
      </Grid>
      <Snackbar
        anchorOrigin={{
          vertical: "bottom",
          horizontal: "right",
        }}
        open={open}
        autoHideDuration={6000}
        onClose={handleClose}
        message={ message }
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

export default SignUp;
