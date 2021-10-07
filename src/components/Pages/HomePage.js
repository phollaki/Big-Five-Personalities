import React, { Fragment } from "react";
import "./HomePage.css";
import openness from "../../images/openness.png";
import conscientiousness from "../../images/conscientiousness.png";
import extrovert from "../../images/extrovert.png";
import aggreeablenes from "../../images/agreeableness.png";
import neuroticism from "../../images/neuroticism.png";
import bigfive from "../../images/bigfive.png";
import { useSelector } from "react-redux";

function HomePage() {
  const { user: currentUser } = useSelector((state) => state.auth);

  return (
    <Fragment>
      <main>
        <div className="container">
          <div className="row">
            <div className="col-sm-6 homepage__title">
              <h1>
                Big 5 <span className="highlight">personality</span> test
              </h1>
              <p>
                Learn to know yourself better with a personality test. The
                following test contains 20 questions which is estimated to take
                you about 5 minutes to complete.
              </p>
              <div className="container_button">
                <a className="btn btn-sample" href={currentUser?"test":"guest-test"} type="submit">
                  Take the TEST
                </a>
              </div>
            </div>
            <div className="col-6 ">
              <img
                src={bigfive}
                className="img-fluid homepage__img"
                alt="Personalities"
              />
            </div>
          </div>
        </div>
      </main>
      <br />
      <br />
      <div className="card-group homepage__body">
        <div className="card">
          <img
            className="card-img-top img-responsive"
            src={openness}
            alt="Card cap"
          />
          <div className="card-body">
            <h5 className="card-title">Openness</h5>
            <p className="card-text">
              This trait features characteristics such as imagination and
              insight. 1 People who are high in this trait also tend to have a
              broad range of interests. They are curious about the world and
              other people and eager to learn new things and enjoy new
              experiences. People who are high in this trait tend to be more
              adventurous and creative. People low in this trait are often much
              more traditional and may struggle with abstract thinking.
            </p>
          </div>
        </div>
        <div className="card">
          <img
            className="card-img-top img-responsive"
            src={conscientiousness}
            alt="Card cap"
          />
          <div className="card-body">
            <h5 className="card-title">Conscientiousness</h5>
            <p className="card-text">
              Standard features of this dimension include high levels of
              thoughtfulness, good impulse control, and goal-directed behaviors.
              1 Highly conscientious people tend to be organized and mindful of
              details. They plan ahead, think about how their behavior affects
              others, and are mindful of deadlines.
            </p>
          </div>
        </div>
        <div className="card">
          <img
            className="card-img-top img-responsive"
            src={extrovert}
            alt="Card cap"
          />
          <div className="card-body">
            <h5 className="card-title">Extraversion</h5>
            <p className="card-text">
              Extraversion (or extroversion) is characterized by excitability,
              sociability, talkativeness, assertiveness, and high amounts of
              emotional expressiveness.1 People who are high in extraversion are
              outgoing and tend to gain energy in social situations. Being
              around other people helps them feel energized and excited. People
              who are low in extraversion (or introverted) tend to be more
              reserved and have less energy to expend in social settings. Social
              events can feel draining and introverts often require a period of
              solitude and quiet in order to "recharge."
            </p>
          </div>
        </div>
        <div className="card">
          <img
            className="card-img-top img-responsive"
            src={neuroticism}
            alt="Card cap"
          />
          <div className="card-body">
            <h5 className="card-title">Neuroticism</h5>
            <p className="card-text">
              Neuroticism is a trait characterized by sadness, moodiness, and
              emotional instability. Individuals who are high in this trait tend
              to experience mood swings, anxiety, irritability, and sadness.
              Those low in this trait tend to be more stable and emotionally
              resilient.
            </p>
          </div>
        </div>
        <div className="card">
          <img
            className="card-img-top img-responsive"
            src={aggreeablenes}
            alt="Card cap"
          />
          <div className="card-body">
            <h5 className="card-title">Agreeableness</h5>
            <p className="card-text">
              This personality dimension includes attributes such as trust,
              altruism, kindness, affection, and other prosocial behaviors.1
              People who are high in agreeableness tend to be more cooperative
              while those low in this trait tend to be more competitive and
              sometimes even manipulative.
            </p>
          </div>
        </div>
      </div>
    </Fragment>
  );
}

export default HomePage;
