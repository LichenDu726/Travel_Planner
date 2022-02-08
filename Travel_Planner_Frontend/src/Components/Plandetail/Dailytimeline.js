import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Timeline from "@material-ui/lab/Timeline";
import TimelineItem from "@material-ui/lab/TimelineItem";
import TimelineSeparator from "@material-ui/lab/TimelineSeparator";
import TimelineConnector from "@material-ui/lab/TimelineConnector";
import TimelineContent from "@material-ui/lab/TimelineContent";
import TimelineOppositeContent from "@material-ui/lab/TimelineOppositeContent";
import TimelineDot from "@material-ui/lab/TimelineDot";
import Paper from "@material-ui/core/Paper";
import Typography from "@material-ui/core/Typography";
import ApartmentOutlinedIcon from "@material-ui/icons/ApartmentOutlined";
import RestaurantMenuIcon from "@material-ui/icons/RestaurantMenu";
import CameraAltIcon from "@material-ui/icons/CameraAlt";
import FlagIcon from "@material-ui/icons/Flag";

const useStyles = makeStyles((theme) => ({
  paper: {
    padding: "6px 16px",
  },
  secondaryTail: {
    backgroundColor: "#33bccd",
  },
}));

const Dailytimeline = () => {
  const classes = useStyles();

  return (
    <Timeline align="alternate">
      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            9:00 am
          </Typography>
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <ApartmentOutlinedIcon />
          </TimelineDot>
          <TimelineConnector className={classes.secondaryTail} />
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              Hotel
            </Typography>
            <Typography>( ͡⚈ ᴥ ͡⚈)</Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>
      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            10:00 am
          </Typography>
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <CameraAltIcon />
          </TimelineDot>
          <TimelineConnector className={classes.secondaryTail} />
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              The Museum of Modern Art
            </Typography>
            <Typography>
              Founded in 1929, The Museum of Modern Art (MoMA) in midtown
              Manhattan was the first museum devoted to the modern era
            </Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>
      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            12:00 pm
          </Typography>
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <RestaurantMenuIcon />
          </TimelineDot>
          <TimelineConnector className={classes.secondaryTail} />
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              Restaurant
            </Typography>
            <Typography> Lunch</Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>

      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            01:00 pm
          </Typography>
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <CameraAltIcon />
          </TimelineDot>
          <TimelineConnector className={classes.secondaryTail} />
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              Bryant Park
            </Typography>
            <Typography>
              Bryant Park had humble beginnings as a simple potter’s field and a
              reservoir. Now it’s lovingly nicknamed Manhattan’s Town Square as
              a gathering place for all New Yorkers and visitors
            </Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>

      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            03:00 pm
          </Typography>
        </TimelineOppositeContent>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <CameraAltIcon />
          </TimelineDot>
          <TimelineConnector className={classes.secondaryTail} />
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              Empire State Building
            </Typography>
            <Typography>
              The Empire State Building is a 102-story Art Deco skyscraper in
              Midtown Manhattan in New York City. It was designed by Shreve,
              Lamb & Harmon and built from 1930 to 1931. Its name is derived
              from "Empire State", the nickname of the state of New York
            </Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>

      <TimelineItem>
        <TimelineSeparator>
          <TimelineDot style={{ color: "#e78739" }} variant="outlined">
            <FlagIcon />
          </TimelineDot>
        </TimelineSeparator>
        <TimelineContent>
          <Paper elevation={3} className={classes.paper}>
            <Typography
              style={{ color: "#ea605d" }}
              variant="h6"
              component="h1"
            >
              End
            </Typography>
            <Typography> ʕ•́ᴥ•̀ʔ </Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>
    </Timeline>
  );
};

export default Dailytimeline;
