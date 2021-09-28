import React, { Fragment } from "react";
import "./Personality.css";
import conscientiousness1 from "../../images/conscientiousness1.jpeg";
import conscientiousness2 from "../../images/conscientiousness2.jpeg";
import conscientiousness4 from "../../images/conscientiousness4.jpeg";
import personalities from "../../helpers/personalities.json";
function Conscientiousness() {
  return (
    <Fragment>
      <header className="jumbotron jumbotron-background img-co">
        <h1>Conscientiousness</h1>
      </header>
      <div className="personality__body">
        <section className="personality__description">
          {personalities.conscientiousness.descr}
        </section>

        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Caring wife reaches to her husbands hand"
              src={conscientiousness1}
            />
          </div>
          <div className="col-sm-6">
            <p className="personality__description">
              {personalities.conscientiousness.descr2}
            </p>
          </div>
        </div>
        <section className="personality__description">
          {personalities.conscientiousness.descr1}
        </section>
        <div className="row">
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman and his daughters loving chat"
              src={conscientiousness2}
            />
          </div>
          <div className="col-sm-6">
            <img
              className="img-fluid"
              alt="Woman caring with his pet dog"
              src={conscientiousness4}
            />
          </div>
        </div>
        <section className="personality__description">
          {personalities.conscientiousness.descr3}
        </section>
      </div>
    </Fragment>
  );
}

export default Conscientiousness;
