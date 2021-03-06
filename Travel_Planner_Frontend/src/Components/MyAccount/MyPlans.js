import React, {useState} from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import Button from '@material-ui/core/Button';
import Typography from '@material-ui/core/Typography';

import { Link, useNavigate, useLocation } from "react-router-dom";

const useStyles = makeStyles({
  root: {
    minWidth: 275,
  },
  bullet: {
    display: 'inline-block',
    margin: '0 2px',
    transform: 'scale(0.8)',
  },
  title: {
    fontSize: 14,
  },
  pos: {
    marginBottom: 12,
  },
});

function MyPlans() {
  const classes = useStyles();

  const navigate = useNavigate();
  const location = useLocation();

  const handleClick = () => {
    navigate("/plan");
  }

  const bull = <span className={classes.bullet}>•</span>;

  return (
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
      <CardActions>
        <Button size="small" onClick={handleClick}> Learn More ( ͡⚈ ᴥ ͡⚈)</Button>
      </CardActions>
    </Card>
    </div>
  );
}

export default MyPlans;