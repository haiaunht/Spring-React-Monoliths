import React from "react"
import { Link } from "react-router-dom"

const NavBar = () => {

  return (
      <div className="title-bar">
        <div className="top-bar-left">
          <ul className="menu">
            <li>
              <Link to="/spaces">Home</Link>
            </li>
            <li>
              <Link to="/spaces/new">Add new space object</Link>
            </li>
          </ul>
        </div>
      </div>
  )
}

export default NavBar