import React, { Component } from "react";
import {
  withGoogleMap,
  withScriptjs,
  GoogleMap,
  DirectionsRenderer,
} from "react-google-maps";

// import { MAP_SETTINGS } from 'constants/constants'

/*global google*/
class Routemap2 extends Component {
  state = {
    directions: null,
  };

  componentDidMount() {
    const directionsService = new google.maps.DirectionsService();

    const origin = { lat: 40.6892, lng: -74.0445 };
    const destination = { lat: 40.772464, lng: -73.983489 };

    directionsService.route(
      {
        origin: origin,
        destination: destination,
        travelMode: google.maps.TravelMode.DRIVING,
      },
      (result, status) => {
        if (status === google.maps.DirectionsStatus.OK) {
          console.log(result);
          this.setState({
            directions: result,
          });
        } else {
          console.error(`error fetching directions ${result}`);
        }
      }
    );
  }

  render() {
    const GoogleMapExample = withGoogleMap((props) => (
      <GoogleMap defaultCenter={{ lat: 40.761509, lng: -73.978271 }} defaultZoom={13}>
        <DirectionsRenderer directions={this.state.directions} />
      </GoogleMap>
    ));

    return (
      <div>
        <GoogleMapExample
          containerElement={<div style={{ height: `500px`, width: "500px" }} />}
          mapElement={<div style={{ height: `100%` }} />}
        />
      </div>
    );
  }
}

export default Routemap2;
