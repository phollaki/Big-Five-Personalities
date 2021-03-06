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
import Agreeableness from "./components/Pages/Agreeableness";
import Openness from "./components/Pages/Openness";
import Conscientiousness from "./components/Pages/Conscientiousness";
import Neuroticism from "./components/Pages/Neuroticism";
import Extroversion from "./components/Pages/Extroversion.js";
import GuestTest from "./components/Pages/GuestTest";
import GuestPersonality from "./components/Pages/GuestPersonality";
const App = () => {
  const { user: currentUser } = useSelector((state) => state.auth);

  return (
    <div className="loginContent">
      {currentUser && (
        <Fragment>
          <Header />
          <Switch>
            <Route path="/extroversion">
              <Extroversion />
            </Route>
            <Route path="/openness">
              <Openness />
            </Route>
            <Route path="/conscientiousness">
              <Conscientiousness />
            </Route>
            <Route path="/neuroticism">
              <Neuroticism />
            </Route>
            <Route path="/agreeableness">
              <Agreeableness />
            </Route>
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
        <Fragment>
          <Header />
          <Switch>
            <Route path="/guest-personality">
              <GuestPersonality />
            </Route>
            <Route path="/guest-test">
              <GuestTest />
            </Route>
            <Route path="/login">
              <Login />
            </Route>
            <Route path="*">
              <Redirect to="/" />
              <HomePage />
            </Route>
          </Switch>
        </Fragment>
      )}
    </div>
  );
};

export default App;
