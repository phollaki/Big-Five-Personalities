import React, { useEffect, useState } from "react";
import StudentService from "../../services/student-service";
import { Spinner } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import "./Test.css";
import { Button, Modal, ModalBody, ModalFooter } from "reactstrap";
import ReportProblemIcon from "@mui/icons-material/ReportProblem";
function Test() {
  const history = useHistory();
  //const { user: currentUser } = useSelector((state) => state.auth);
  const [questions, setQuestions] = useState([]);
  const [answers, setAnswers] = useState([]);
  const [data, setData] = useState(false);
  const [result, setResult] = useState({ gender: "Male", age: "15" });
  const [index] = useState(0);
  const [checked, setIsChecked] = useState(false);
  const [modal, setModal] = useState(false);

  useEffect(() => {
    StudentService.getTest().then((res) => {
      setQuestions(res.questions);
      setAnswers(res.answers);
      setData(true);
    });
  }, []);

  const submitHandler = () => {
    if (!checked) {
      setModal(true);
    }
  };
  const testFormHandler = (e) => {
    e.preventDefault();
    StudentService.sendGuestTest(result)
      .then((response) => {
        console.log(response);
        history.push({
          pathname: "/guest-personality",
          state: { personality: response },
        });
      })
      .catch((err) => {
        console.log(err.message);
      });
  };
  const ageEventHandler = (e) => {
    setResult({ ...result, age: e.target.value });
  };
  const genderEventHandler = (e) => {
    setResult({ ...result, gender: e.target.value });
  };
  const handleAnswerAdd = (questionKey, answer) => {
    console.log(result);
    setResult({
      ...result,
      [questionKey]: answer,
    });
    setIsChecked(true);
  };
  const toggle = () => setModal(!modal);

  if (data) {
    return (
      <form className="test__form" onSubmit={testFormHandler}>
        <div className="guest__form">
          <div className="guest__form-title">
            <h2 className="form__title">You are currently logged out!</h2>
            <ReportProblemIcon className="warning__icon" />
          </div>
          <p className="guest__form-text">
            Because you are not a logged in user, we can not own detailed
            information for you. If you want to sign up please write an email
            for admin. For the best result, please fill in all personal
            information and answer all test questions honestly.
          </p>
        </div>
        <div className="infoContainer ">
          <div className="form-row">
            <div className="form-group col-md-6 guest__test-form">
              <label htmlFor="age">Age</label>
              <input
                type="number"
                className="form-control test__form-input"
                id="age"
                placeholder="Age"
                required
                onChange={ageEventHandler}
              />
            </div>
            <div className="form-group col-md-6 guest__test-form">
              <label htmlFor="inputPassword4">Gender</label>
              <select
                required
                className="form-control test__form-input"
                onChange={genderEventHandler}
              >
                <option>Male</option>
                <option>Female</option>
              </select>
            </div>
          </div>
        </div>
        <h1 className="test_title">I am someone who...</h1>
        {questions.map((question) => (
          <div className="container container2" key={question.qst_id}>
            <p className="question_title">{question.qst_title}</p>
            <div className="text-center">
              <div className="form-check form-check-inline">
                <input
                  onChange={(e) => {
                    handleAnswerAdd(question.qst_id, e.target.value);
                  }}
                  name={question.qst_id}
                  className="form-check-input"
                  type="radio"
                  id={question.qst_id}
                  value={answers[index].answ_id}
                  required
                />
                <label className="form-check-label  " htmlFor={question.qst_id}>
                  {answers[index].answ_title}
                </label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  onChange={(e) => {
                    handleAnswerAdd(question.qst_id, e.target.value);
                  }}
                  name={question.qst_id}
                  className="form-check-input"
                  type="radio"
                  id={question.qst_id}
                  value={answers[index + 1].answ_id}
                />
                <label className="form-check-label " htmlFor={question.qst_id}>
                  {answers[index + 1].answ_title}
                </label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  onChange={(e) => {
                    handleAnswerAdd(question.qst_id, e.target.value);
                  }}
                  name={question.qst_id}
                  className="form-check-input"
                  type="radio"
                  id={question.qst_id}
                  value={answers[index + 2].answ_id}
                />
                <label className="form-check-label " htmlFor={question.qst_id}>
                  {answers[index + 2].answ_title}
                </label>
              </div>
              <div className="form-check form-check-inline">
                <input
                  onChange={(e) => {
                    handleAnswerAdd(question.qst_id, e.target.value);
                  }}
                  name={question.qst_id}
                  className="form-check-input"
                  type="radio"
                  id={question.qst_id}
                  value={answers[index + 3].answ_id}
                />
                <label className="form-check-label " htmlFor={question.qst_id}>
                  {answers[index + 3].answ_title}
                </label>
              </div>
              <div className="form-check form-check-inline ">
                <input
                  onChange={(e) => {
                    handleAnswerAdd(question.qst_id, e.target.value);
                  }}
                  name={question.qst_id}
                  className="form-check-input"
                  type="radio"
                  id={question.qst_id}
                  value={answers[index + 4].answ_id}
                />
                <label
                  className="form-check form-check-inline "
                  htmlFor={question.qst_id}
                >
                  {answers[index + 4].answ_title}
                </label>
              </div>
            </div>
          </div>
        ))}
        {modal && (
          <div>
            <Modal isOpen={modal} toggle={toggle}>
              <ModalBody>You have to answer all questions!</ModalBody>
              <ModalFooter>
                <Button color="danger" onClick={toggle}>
                  Cancel
                </Button>
              </ModalFooter>
            </Modal>
          </div>
        )}
        <div className="d-flex justify-content-center">
          <button
            onClick={submitHandler}
            className="btn btn-sample p-2 text-uppercase "
            type="submit"
          >
            submit
          </button>
        </div>
      </form>
    );
  }
  return (
    <div className="text-center">
      <Spinner className="spinner" animation="border" />
    </div>
  );
}
export default Test;
