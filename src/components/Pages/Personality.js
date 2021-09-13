import React, { Fragment, useEffect, useState } from "react";
import { Redirect } from "react-router-dom";
import { useSelector } from "react-redux";
import studentService from "../../services/student-service";
import personalities from "../../helpers/personalities.json";
import openness3 from "../../images/openness3.jpeg";
import openness4 from "../../images/openness4.jpeg";
import openness5 from "../../images/openness5.jpeg";
import agreeableness1 from "../../images/agreeableness1.jpeg";
import agreeableness2 from "../../images/agreeableness2.jpeg";
import agreeableness4 from "../../images/agreeableness4.jpeg";
import extroversion2 from "../../images/extroversion2.jpeg";
import extroversion3 from "../../images/extroversion3.jpeg";
import extroversion4 from "../../images/extroversion4.jpeg";
import conscientiousness1 from "../../images/conscientiousness1.jpeg";
import conscientiousness2 from "../../images/conscientiousness2.jpeg";
import conscientiousness4 from "../../images/conscientiousness4.jpeg";

import neuroticism1 from "../../images/neuroticism1.jpeg";
import neuroticism2 from "../../images/neuroticism2.jpeg";
import neuroticism3 from "../../images/neuroticism3.jpeg";
import "./Personality.css";
const OP = "Openness";
const EX = "Extroversion";
const NE = "Neuroticism";
const CO = "Conscientiousness";
const AG = "Agreeableness";

const Profile = () => {
  const { user: currentUser } = useSelector((state) => state.auth);
  const [personality, setPersonality] = useState(currentUser.personality);
  useEffect(() => {
    const getPersonality = async function () {
      const res = await studentService.getPersonality(currentUser.id);
      currentUser.personality = res;
      setPersonality(res);
      localStorage.setItem("user", JSON.stringify(currentUser));
    };
    getPersonality();
  }, [currentUser]);
  console.log(personality);
  if (!currentUser) {
    return <Redirect to="/login" />;
  }
  if (personality === OP) {
    return (
      <Fragment>
        <header className="jumbotron jumbotron-background img-op">
          <h1>{personality}</h1>
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
  if (personality === AG) {
    return (
      <Fragment>
        <header className="jumbotron jumbotron-background img-ag">
          <h1>{personality}</h1>
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
  if (personality === EX) {
    return (
      <Fragment>
        <header className="jumbotron jumbotron-background img-ex">
          <h1>{personality}</h1>
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
  if (personality === CO) {
    return (
      <Fragment>
        <header className="jumbotron jumbotron-background img-co">
          <h1>{personality}</h1>
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
  if (personality === NE) {
    return (
      <Fragment>
        <header className="jumbotron jumbotron-background img-ne">
          <h1>{personality}</h1>
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

  return (
    <div>
      <h1>Something went wrong!</h1>
      <p>There is no personality like yours. You are special!</p>
    </div>
  );
};

export default Profile;
