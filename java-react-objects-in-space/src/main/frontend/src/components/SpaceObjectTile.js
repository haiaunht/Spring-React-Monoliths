import React from "react";

const SpaceObjectTile = props => {

  return (
      <div >
        <div class="each">
          <h3>Space's name: {props.name}</h3>
          <h3>Ngc: {props.ngc}</h3>
          <h3>Year's discovered: {props.yearDiscovered}</h3>
        </div>
      </div>
  )
}

export default SpaceObjectTile