import React, {Component} from 'react'
import { hot } from "react-hot-loader/root"
import "regenerator-runtime/runtime"
import SpaceObjectIndexPage from "./components/SpaceObjectIndexPage";
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom";
import SpaceObjectForm from "./components/SpaceObjectForm";
import NavBar from "./Navbar";

class App extends Component{
  constructor(props) {
    super(props);
    this.state = {

    }
  }

  render(){
    return(
        <div>
          <h1>Space... the Final Frontier</h1>
          <SpaceObjectIndexPage />
        </div>
    )
  }
}


export default App
