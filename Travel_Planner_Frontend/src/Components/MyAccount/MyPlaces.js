import React from "react";
import { Grid } from "@material-ui/core";
import PlaceCard from "./PlaceCard";

function MyPlaces() {
  return (
    <div>
      <Grid
        direction="column"
        spacing={4}
        justifyContent="space-around"
        alignItems="center"
      >
        <Grid item xs={5}>
          <PlaceCard
            id="card"
            name="Statue of Liberty"
            description="The Statue of Liberty is a colossal neoclassical sculpture on Liberty Island in New York Harbor in New York City, in the United States.The statue was dedicated on October 28, 1886"
            url="https://i.guim.co.uk/img/media/4a29dde46c17e8a07f98e4e5947d49964d074923/0_348_6000_3600/master/6000.jpg?width=1200&height=900&quality=85&auto=format&fit=crop&s=88c75e6319ec9d3588bb6e17ae92ff68"
          />
        </Grid>

        <Grid item xs={5}>
          <PlaceCard
            name="Times Square"
            description="Bustling destination in the heart of the Theater District known for bright lights, shopping & shows."
            url="https://images.nycgo.com/image/fetch/q_auto:eco,c_fill,f_auto,w_780,g_center/https://www.nycgo.com/images/venues/152/tripadvisortimessquare_taggeryanceyiv_5912.jpg"
          />
        </Grid>

        <Grid item xs={5}>
          <PlaceCard
            name="Empire State Building"
            description="The Empire State Building is a 102-story Art Deco skyscraper in Midtown Manhattan in New York City. It was designed by Shreve, Lamb & Harmon and built from 1930 to 1931. Its name is derived from Empire State, the nickname of the state of New York"
            url="https://bsmedia.business-standard.com/_media/bs/img/article/2021-09/20/full/1632080404-7898.jpg"
          />
        </Grid>
      </Grid>
    </div>
  );
}

export default MyPlaces;
