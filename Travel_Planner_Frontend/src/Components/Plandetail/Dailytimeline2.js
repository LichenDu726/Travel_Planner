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

const Dailytimeline2 = () => {
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
            02:00 pm
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
              Statue of Liberty
            </Typography>
            <Typography>
              The Statue of Liberty is a colossal neoclassical sculpture on
              Liberty Island in New York Harbor in New York City, in the United
              States.The statue was dedicated on October 28, 1886
            </Typography>
          </Paper>
        </TimelineContent>
      </TimelineItem>

      <TimelineItem>
        <TimelineOppositeContent>
          <Typography variant="body3" style={{ color: "#039be5" }}>
            04:00 pm
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
              Lincoln Center for the Performing Arts
            </Typography>
            <Typography>
              Lincoln Center for the Performing Arts is a 16.3-acre
              (6.6-hectare) complex of buildings in the Lincoln Square
              neighborhood of Manhattan in New York City.It has thirty indoor
              and outdoor facilities and is host to 5 million visitors annually
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

export default Dailytimeline2;
