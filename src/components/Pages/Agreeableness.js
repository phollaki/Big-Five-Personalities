import React, { Fragment } from "react";
import agreeableness1 from "../../images/agreeableness1.jpeg";
import agreeableness2 from "../../images/agreeableness2.jpeg";
import agreeableness4 from "../../images/agreeableness4.jpeg";
import personalities from "../../helpers/personalities.json";
import "./Personality.css";
function Agreeableness() {
  return (
    <Fragment>
      <header className="jumbotron jumbotron-background img-ag">
        <h1>Agreeableness</h1>
      </header>
      <div className="personality__body">
        <section className="personality__description">
          {personalities.agreeableness.descr}
        </section>

        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Caring wife reaches to her husbands hand"
              src={agreeableness1}
            />
          </div>
          <div className="col-sm-6">
            <p className="personality__description">
              {personalities.agreeableness.descr1}
            </p>
          </div>
        </div>
        <section className="personality__description">
          {personalities.agreeableness.descr2}
        </section>
        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman and his daughters loving chat"
              src={agreeableness2}
            />
          </div>
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman caring with his pet dog"
              src={agreeableness4}
            />
          </div>
        </div>
        <section className="personality__description">
          {personalities.agreeableness.descr3}
        </section>
      </div>
    </Fragment>
  );
}

export default Agreeableness;
