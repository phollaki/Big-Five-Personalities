import React, { Fragment } from "react";
import personalities from "../../helpers/personalities.json";
import openness3 from "../../images/openness3.jpeg";
import openness4 from "../../images/openness4.jpeg";
import openness5 from "../../images/openness5.jpeg";

import "./Personality.css";
function Openness() {
  return (
    <Fragment>
      <header className="jumbotron jumbotron-background img-op">
        <h1>Openness</h1>
      </header>

      <div className="personality__body">
        <section className="personality__description">
          {personalities.openness.descr}
        </section>

        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Group of people traveling"
              src={openness4}
            />
          </div>
          <div className="col-sm-6">
            <p className="personality__description">
              {personalities.openness.descr}
            </p>
          </div>
        </div>
        <section className="personality__description">
          {personalities.openness.descr}
        </section>
        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Group of openness people celebrate"
              src={openness3}
            />
          </div>
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Friends with openness personality traveling"
              src={openness5}
            />
          </div>
        </div>
      </div>
    </Fragment>
  );
}

export default Openness;
