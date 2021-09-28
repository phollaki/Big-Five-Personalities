import React, { Fragment } from "react";
import neuroticism1 from "../../images/neuroticism1.jpeg";
import neuroticism2 from "../../images/neuroticism2.jpeg";
import neuroticism3 from "../../images/neuroticism3.jpeg";
import personalities from "../../helpers/personalities.json";
import "./Personality.css";
function Neuroticism() {
  return (
    <Fragment>
      <header className="jumbotron jumbotron-background img-ne">
        <h1>Neuroticism</h1>
      </header>
      <div className="personality__body">
        <section className="personality__description">
          {personalities.neuroticism.descr}
        </section>

        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Caring wife reaches to her husbands hand"
              src={neuroticism1}
            />
          </div>
          <div className="col-sm-6">
            <p className="personality__description">
              {personalities.neuroticism.descr1}
            </p>
          </div>
        </div>
        <section className="personality__description">
          {personalities.neuroticism.descr2}
        </section>
        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman and his daughters loving chat"
              src={neuroticism2}
            />
          </div>
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman caring with his pet dog"
              src={neuroticism3}
            />
          </div>
        </div>
        <section className="personality__description">
          {personalities.neuroticism.descr3}
        </section>
      </div>
    </Fragment>
  );
}

export default Neuroticism;
