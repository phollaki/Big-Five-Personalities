import React, { Fragment, useState } from "react";
import "./Compare.css";
import studentService from "../../services/student-service";
import { useSelector } from "react-redux";
import CanvasJSReact from "../../canvas/canvasjs.react";
import buildCanvas from "../../canvas/canvasBuild";
//var CanvasJSReact = require('./canvasjs.react');
const CanvasJS = CanvasJSReact.CanvasJS;
const CanvasJSChart = CanvasJSReact.CanvasJSChart;

function Compare() {
  const { user: currentUser } = useSelector((state) => state.auth);
  const [userData, setUserData] = useState([]);
  const [compareData, setCompareData] = useState([]);
  const [searched, setSearched] = useState(false);
  const [inputField, setInputField] = useState("");
  const compareFormHandler = async function (e) {
    e.preventDefault();
    setSearched(true);
    setUserData([]);
    setCompareData([]);
    try {
      const data = await studentService.getCompareData(
        currentUser.id.toString(),
        inputField
      );
      setUserData(data[0]);
      setCompareData(data[1]);
    } catch (err) {
      console.log(err);
    } finally {
      setInputField("");
    }
  };

  const options = buildCanvas(userData, compareData);
  const inputHandler = function (e) {
    setInputField(e.target.value);
  };

  return (
    <Fragment>
      <form onSubmit={compareFormHandler}>
        <div className="container compare__container">
          <div className="form-group compare__input">
            <label>Compare your date with:</label>
            <input
              type="text"
              onChange={inputHandler}
              value={inputField}
              placeholder="student id"
            ></input>
          </div>
          <div className="btn__compare">
            <button className="btn btn-sample">Compare</button>
          </div>
        </div>
      </form>
      {compareData.length > 0 && (
        <div className="compare__chart">
          <CanvasJSChart
            options={options}
            /* onRef = {ref => this.chart = ref} */
          />
        </div>
      )}
      {compareData.length < 1 && searched && (
        <p className="text-center compare__error">No student with given id</p>
      )}
    </Fragment>
  );
}

export default Compare;
