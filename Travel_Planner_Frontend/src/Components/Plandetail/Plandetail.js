import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Accordion from "@material-ui/core/Accordion";
import AccordionSummary from "@material-ui/core/AccordionSummary";
import AccordionDetails from "@material-ui/core/AccordionDetails";
import Typography from "@material-ui/core/Typography";
import ExpandMoreIcon from "@material-ui/icons/ExpandMore";
import Navbar from "../Navbar/Navbar.js";
import Dailytimeline from "./Dailytimeline.js";
import Grid from "@material-ui/core/Grid";
import { Wrapper, Status } from "@googlemaps/react-wrapper";
import Box from "@material-ui/core/Box";
import Card from "@material-ui/core/Card";
import CardContent from "@material-ui/core/CardContent";
// import GOOGLE_API_KEY from "../../assets/constants.js";

import Routemap from "../Map/Routemap/Routemap.js";
import Routemap2 from "../Map/Routemap/Routemap2.js";
import Routemap3 from "../Map/Routemap/Routemap3.js";

import Dailytimeline2 from "./Dailytimeline2.js";
import Dailytimeline3 from "./Dailytimeline3.js";

const useStyles = makeStyles((theme) => ({
  root: {
    width: "100%",
  },
  heading: {
    fontSize: theme.typography.pxToRem(15),
    fontWeight: theme.typography.fontWeightRegular,
  },
}));

// Plandetail Component
const Plandetail = () => {
  const classes = useStyles();

  return (
    <div id="plan-view">
      <Navbar />

      <div>
    <Card className={classes.root}>
      <CardContent>
        <Typography className={classes.title} color="textSecondary" gutterBottom>
        ʕ•́ᴥ•̀ʔ #7
        </Typography>
        <Typography variant="h5" component="h2">
          Travel Plan
        </Typography>
        <Typography className={classes.pos} color="textSecondary">
          New York
        </Typography>
        <Typography variant="body2" component="p">
          3 days
          <br />
        </Typography>
      </CardContent>
    </Card>
    </div>

      <div>
        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography className={classes.heading}>Day 1 Plan</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Grid
              container
              direction="row"
              xs={12}
              justifyContent="space-around"
              alignItems="center"
            >
              <Grid item xs={12} sm={6}>
                <Box>
                  <Dailytimeline></Dailytimeline>
                </Box>
              </Grid>

              <Grid item xs={12} sm={4}>
                <Wrapper apiKey={"AIzaSyAiIwnFc10xGTkqInso7Ce37sYrE77g45E"}>
                  <Routemap></Routemap>
                </Wrapper>
              </Grid>
            </Grid>
          </AccordionDetails>
        </Accordion>
      </div>

      <div>
        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography className={classes.heading}>Day 2 Plan</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Grid
              container
              direction="row"
              xs={12}
              justifyContent="space-around"
              alignItems="center"
            >
              <Grid item xs={12} sm={6}>
                <Box>
                  <Dailytimeline2></Dailytimeline2>
                </Box>
              </Grid>

              <Grid item xs={12} sm={4}>
                <Wrapper apiKey={"AIzaSyAiIwnFc10xGTkqInso7Ce37sYrE77g45E"}>
                  <Routemap2></Routemap2>
                </Wrapper>
              </Grid>
            </Grid>
          </AccordionDetails>
        </Accordion>
      </div>

      <div>
        <Accordion>
          <AccordionSummary
            expandIcon={<ExpandMoreIcon />}
            aria-controls="panel1a-content"
            id="panel1a-header"
          >
            <Typography className={classes.heading}>Day 3 Plan</Typography>
          </AccordionSummary>
          <AccordionDetails>
            <Grid
              container
              direction="row"
              xs={12}
              justifyContent="space-around"
              alignItems="center"
            >
              <Grid item xs={12} sm={6}>
                <Box>
                  <Dailytimeline3></Dailytimeline3>
                </Box>
              </Grid>

              <Grid item xs={12} sm={4}>
                <Wrapper apiKey={"AIzaSyAiIwnFc10xGTkqInso7Ce37sYrE77g45E"}>
                  <Routemap3></Routemap3>
                </Wrapper>
              </Grid>
            </Grid>
          </AccordionDetails>
        </Accordion>
      </div>
    </div>
  );
};

export default Plandetail;
