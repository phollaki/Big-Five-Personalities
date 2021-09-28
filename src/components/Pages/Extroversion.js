import React, { Fragment } from "react";
import extroversion2 from "../../images/extroversion2.jpeg";
import extroversion3 from "../../images/extroversion3.jpeg";
import extroversion4 from "../../images/extroversion4.jpeg";
import "./Personality.css";
import personalities from "../../helpers/personalities.json";
function Extrovert() {
  return (
    <Fragment>
      <header className="jumbotron jumbotron-background img-ex">
        <h1>Extroversion</h1>
      </header>
      <div className="personality__body">
        <section className="personality__description">
          {personalities.extroversion.descr}
        </section>

        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Caring wife reaches to her husbands hand"
              src={extroversion3}
            />
          </div>
          <div className="col-sm-6">
            <p className="personality__description">
              {personalities.extroversion.descr2}
            </p>
          </div>
        </div>
        <section className="personality__description">
          {personalities.extroversion.descr1}
        </section>
        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman and his daughters loving chat"
              src={extroversion2}
            />
          </div>
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman caring with his pet dog"
              src={extroversion4}
            />
          </div>
        </div>
        <section className="personality__description">
          {personalities.extroversion.descr3}
        </section>
      </div>
    </Fragment>
  );
}

export default Extrovert;
