import React, { Fragment } from "react";
import { useSelector } from "react-redux";
import { Switch, Route, Redirect } from "react-router-dom";
import Test from "./components/Pages/Test";
import Header from "./components/Layouts/Header";
import HomePage from "./components/Pages/HomePage";
import Login from "./components/Pages/Login";
import Personality from "./components/Pages/Personality";
import Compare from "./components/Pages/Compare";
import "./App.css";
import Calculation from "./components/Pages/Calculation";
const App = () => {
  const { user: currentUser } = useSelector((state) => state.auth);

  return (
    <div className="loginContent">
      {currentUser && (
        <Fragment>
          <Header />
          <Switch>
            <Route path="/test">
              <Test />
            </Route>
            <Route path="/personality">
              <Personality />
            </Route>
            <Route path="/calculation">
              <Calculation />
            </Route>
            <Route path="/compare">
              <Compare />
            </Route>
            <Route path="*">
              <Redirect to="/" />
              <HomePage />
            </Route>
          </Switch>
        </Fragment>
      )}
      {!currentUser && (
        <Switch>
          <Route path="">
            <Login />
          </Route>
        </Switch>
      )}
    </div>
  );
};

export default App;
