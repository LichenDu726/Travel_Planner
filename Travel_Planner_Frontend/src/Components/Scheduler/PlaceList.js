import React from "react";
import { makeStyles } from "@material-ui/core/styles";
import Chip from "@material-ui/core/Chip";
import Paper from "@material-ui/core/Paper";
import TagFacesIcon from "@material-ui/icons/TagFaces";
import CameraAltOutlinedIcon from "@material-ui/icons/CameraAltOutlined";

const useStyles = makeStyles((theme) => ({
  root: {
    display: "flex",
    justifyContent: "center",
    flexWrap: "wrap",
    listStyle: "none",
    padding: theme.spacing(0.5),
    margin: 5,
  },
  chip: {
    margin: theme.spacing(1),
  },
}));

function PlaceList() {
  const classes = useStyles();
  const [chipData, setChipData] = React.useState([
    { key: 0, label: "The Museum of Modern Art" },
    { key: 1, label: "Bryant Park" },
    { key: 2, label: "Empire State Building" },
    { key: 3, label: "Statue of Liberty" },
    { key: 4, label: "Lincoln Center for the Performing Arts" },
    { key: 5, label: "Oddities Flea Market New York City" },
    { key: 6, label: "Central Park" },
    { key: 7, label: "Times Square" },
  ]);

  const handleDelete = (chipToDelete) => () => {
    setChipData((chips) =>
      chips.filter((chip) => chip.key !== chipToDelete.key)
    );
  };

  return (
    <Paper component="ul" className={classes.root}>
      {chipData.map((data) => {
        let icon;

        if (data.label === "React") {
          icon = <TagFacesIcon />;
        }

        return (
          <li key={data.key}>
            <Chip
              variant="outlined"
              color="primary"
              onDelete={handleDelete}
              icon={<CameraAltOutlinedIcon />}
              label={data.label}
              onDelete={data.label === "React" ? undefined : handleDelete(data)}
              className={classes.chip}
            />
          </li>
        );
      })}
    </Paper>
  );
}

export default PlaceList;
