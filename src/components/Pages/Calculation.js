import React, { useEffect, useState } from "react";
import { useSelector } from "react-redux";
import studentService from "../../services/student-service";
import "./Calculation.css";
function Calculation() {
  const { user: currentUser } = useSelector((state) => state.auth);
  const [userResults, setUserResults] = useState([]);
  const [userInfo, setUserInfo] = useState([]);
  const [questions, setQuestions] = useState([]);
  const [location, setLocation] = useState([]);
  useEffect(() => {
    const getPersonality = async function () {
      const res = await studentService.getCalculationData(currentUser.id);
      setUserResults(res.results);
      setUserInfo(res.student);
      setQuestions(res.questions);
      setLocation(res.location);
    };
    getPersonality();
  }, [currentUser]);
  return (
    <div className="">
      <div className="text-center">
        <h2>
          How your <span className="highlight">{userInfo.personality}</span>
          <br />
          personality has calculated
        </h2>
      </div>
      <table className="table table-responsive mt-5 table-striped text-center">
        <thead>
          <tr>
            <th scope="col">Question</th>
            <th scope="col">Answer</th>
            <th scope="col">Openness Score</th>
            <th scope="col">Conscientiousness Score</th>
            <th scope="col">Extroversion Score</th>
            <th scope="col">Agreeableness Score</th>
            <th scope="col">Neuroticism Score</th>
          </tr>
        </thead>

        <tbody>
          {questions.map((qst, i) => (
            <tr key={qst.qst_id}>
              <th scope="row">{qst.qst_title}</th>
              <td>{userResults.allAnswersInOrder[i]}</td>
              <td>
                {i % 5 === 0
                  ? userResults.allAnswersInOrder[i] * 30
                  : i % 5 === 3
                  ? userResults.allAnswersInOrder[i] * 15
                  : userResults.allAnswersInOrder[i] * 5}
              </td>

              <td>
                {i % 5 === 1
                  ? userResults.allAnswersInOrder[i] * 30
                  : i % 5 === 4
                  ? userResults.allAnswersInOrder[i] * 15
                  : userResults.allAnswersInOrder[i] * 5}
              </td>

              <td>
                {i % 5 === 2
                  ? userResults.allAnswersInOrder[i] * 30
                  : i % 5 === 0
                  ? userResults.allAnswersInOrder[i] * 15
                  : userResults.allAnswersInOrder[i] * 5}
              </td>

              <td>
                {i % 5 === 3
                  ? userResults.allAnswersInOrder[i] * 30
                  : i % 5 === 2
                  ? userResults.allAnswersInOrder[i] * 15
                  : userResults.allAnswersInOrder[i] * 5}
              </td>
              <td>
                {i % 5 === 4
                  ? userResults.allAnswersInOrder[i] * 30
                  : i % 5 === 1
                  ? userResults.allAnswersInOrder[i] * 15
                  : userResults.allAnswersInOrder[i] * 5}
              </td>
            </tr>
          ))}
          <tr>
            <th scope="row">Age</th>
            <td>{userInfo.age}</td>
            <td>
              {userInfo.age < 30 && userInfo.age <= 20
                ? userInfo.age * 0.5
                : userInfo.age < 30 && userInfo.age >= 20
                ? Math.round(-userInfo.age * 0.3 * 100) / 100
                : userInfo.age > 70
                ? Math.round(-userInfo.age * 0.3 * 100) / 100
                : 0}
            </td>
            <td>
              {userInfo.age >= 70
                ? Math.round(-userInfo.age * 0.3 * 100) / 100
                : userInfo.age > 20
                ? Math.round(userInfo.age * 0.5 * 100) / 100
                : 0}
            </td>
            <td>
              {userInfo.age <= 20
                ? 30
                : userInfo.age <= 30
                ? 15
                : userInfo.age < 50
                ? -15
                : -30}
            </td>
            <td>
              {userInfo.age >= 70
                ? Math.round(userInfo.age * 0.3 * 100) / 100
                : userInfo.age > 20
                ? Math.round(userInfo.age * 0.5 * 100) / 100
                : 0}
            </td>
            <td>
              {userInfo.age >= 70
                ? Math.round(userInfo.age * 0.5 * 100) / 100
                : userInfo.age > 20
                ? Math.round(userInfo.age * 0.3 * 100) / 100
                : 0}
            </td>
          </tr>
          <tr>
            <th scope="row">Gender</th>
            <td>{userInfo.gender === 1 ? "Male" : "Female"}</td>
            <td>{userInfo.gender === 1 ? 30 : 0}</td>
            <td>0</td>
            <td>{userInfo.gender === 1 ? 30 : 0}</td>
            <td>{userInfo.gender === 1 ? 0 : 30}</td>
            <td>{userInfo.gender === 1 ? 0 : 30}</td>
          </tr>
          <tr>
            <th scope="row">Loc Density</th>
            <td>
              {location.density === 5
                ? "Very high"
                : location.density === 4
                ? "High"
                : location.density === 3
                ? "Medium"
                : location.density === 2
                ? "Low"
                : location.density === 1
                ? "Very low"
                : ""}
            </td>
            <td>
              {location.density === 1
                ? -30
                : location.density === 2
                ? -15
                : location.density === 3
                ? 0
                : location.density === 4
                ? 15
                : location.density === 5
                ? 30
                : 0}
            </td>
            <td>0</td>
            <td>0</td>
            <td>
              {location.density === 1
                ? 30
                : location.density === 2
                ? 15
                : location.density === 3
                ? 0
                : location.density === 4
                ? -15
                : location.density === 5
                ? -30
                : 0}
            </td>
            <td>0</td>
          </tr>
          <tr>
            <th scope="row">Loc Individualism score</th>
            <td>{location.invidualism_score}</td>
            <td>0</td>
            <td>
              {location.invidualism_score >= 80
                ? 15
                : location.invidualism_score > 50
                ? 5
                : location.invidualism_score > 20
                ? -5
                : -15}
            </td>
            <td>
              {location.invidualism_score >= 80
                ? -15
                : location.invidualism_score > 50
                ? -5
                : location.invidualism_score > 20
                ? 5
                : 15}
            </td>
            <td>
              {location.invidualism_score >= 80
                ? -15
                : location.invidualism_score > 50
                ? -5
                : location.invidualism_score > 20
                ? 5
                : 15}
            </td>
            <td>
              {location.invidualism_score >= 80
                ? 15
                : location.invidualism_score > 50
                ? 5
                : location.invidualism_score > 20
                ? -5
                : -15}
            </td>
          </tr>
          <tr>
            <th scope="row">Loc AVG Temp/Year</th>
            <td>{location.average_temp}°C</td>
            <td>{location.average_temp > 22 ? 15 : 0}</td>
            <td>0</td>
            <td>{location.average_temp > 22 ? 15 : 0}</td>
            <td>{location.average_temp > 22 ? 15 : 0}</td>
            <td>{location.average_temp > 22 ? -15 : 0}</td>
          </tr>
          <tr>
            <th scope="row">Grade Point AVG</th>
            <td>{userInfo.gp_avg}</td>
            <td>0</td>
            <td>
              {userInfo.gp_avg >= 4
                ? 30
                : userInfo.gp_avg > 3
                ? 15
                : (userInfo.gp_avg = 3
                    ? 0
                    : userInfo.gp_avg < 3
                    ? -15
                    : userInfo.gp_avg < 2 && userInfo.gp_avg > 1
                    ? -30
                    : 0)}
            </td>
            <td>0</td>
            <td>0</td>
            <td>0</td>
          </tr>
          <tr>
            <th scope="row">SUM</th>
            <td></td>
            <td>
              <b>{userResults.openness_score}</b>
            </td>
            <td>
              <b>{userResults.conscientiousness_score}</b>
            </td>
            <td>
              <b>{userResults.extraversion_score}</b>
            </td>
            <td>
              <b>{userResults.aggreeableness_score}</b>
            </td>
            <td>
              <b>{userResults.neuroticism_score}</b>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
  );
}

export default Calculation;
