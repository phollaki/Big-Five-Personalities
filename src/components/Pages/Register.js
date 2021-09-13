import React, { useState, useRef } from "react";
import { useDispatch, useSelector } from "react-redux";

import Form from "react-validation/build/form";
import Input from "react-validation/build/input";
import CheckButton from "react-validation/build/button";
import { isEmail } from "validator";

import { register } from "../../actions/auth";

const required = (value) => {
  if (!value) {
    return (
      <div className="alert alert-danger" role="alert">
        This field is required!
      </div>
    );
  }
};

const validEmail = (value) => {
  if (!isEmail(value)) {
    return (
      <div className="alert alert-danger" role="alert">
        This is not a valid email.
      </div>
    );
  }
};

const vusername = (value) => {
  if (value.length < 3 || value.length > 20) {
    return (
      <div className="alert alert-danger" role="alert">
        The username must be between 3 and 20 characters.
      </div>
    );
  }
};

const vpassword = (value) => {
  if (value.length < 6 || value.length > 40) {
    return (
      <div className="alert alert-danger" role="alert">
        The password must be between 6 and 40 characters.
      </div>
    );
  }
};

const Register = () => {
  const form = useRef();
  const checkBtn = useRef();

  const [username, setUsername] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [location, setLocation] = useState("");
  const [department, setDepartment] = useState("");
  const [fname, setFname] = useState("");
  const [lname, setLname] = useState("");
  const [faculty, setFaculty] = useState("");
  const [gender, setGender] = useState("");
  const [successful, setSuccessful] = useState(false);

  const { message } = useSelector((state) => state.message);
  const dispatch = useDispatch();

  const onChangeUsername = (e) => {
    const username = e.target.value;
    setUsername(username);
  };
  const onChangeLocation = (e) => {
    const location = e.target.value;
    setLocation(location);
  };
  const onChangeDepartment = (e) => {
    const department = e.target.value;
    setDepartment(department);
  };
  const onChangeFaculty = (e) => {
    const faculty = e.target.value;
    setFaculty(faculty);
  };
  const onChangeFirstName = (e) => {
    const fname = e.target.value;
    setFname(fname);
  };
  const onChangeLastName = (e) => {
    const lname = e.target.value;
    setLname(lname);
  };
  const onChangeGender = (e) => {
    const gender = e.target.value;
    setGender(gender);
  };

  const onChangeEmail = (e) => {
    const email = e.target.value;
    setEmail(email);
  };

  const onChangePassword = (e) => {
    const password = e.target.value;
    setPassword(password);
  };

  const handleRegister = (e) => {
    e.preventDefault();

    setSuccessful(false);

    form.current.validateAll();

    if (checkBtn.current.context._errors.length === 0) {
      dispatch(
        register(
          username,
          password,
          department,
          faculty,
          location,
          gender,
          fname,
          lname
        )
      )
        .then(() => {
          setSuccessful(true);
        })
        .catch(() => {
          setSuccessful(false);
        });
    }
  };

  return (
    <div className="col-md-12">
      <div className="card card-container">
        <img
          src="//ssl.gstatic.com/accounts/ui/avatar_2x.png"
          alt="profile-img"
          className="profile-img-card"
        />

        <Form onSubmit={handleRegister} ref={form}>
          {!successful && (
            <div>
              <div className="form-group">
                <label htmlFor="username">Username</label>
                <Input
                  type="text"
                  className="form-control"
                  name="username"
                  value={username}
                  onChange={onChangeUsername}
                  validations={[required, vusername]}
                />
              </div>

              <div className="form-group">
                <label htmlFor="password">Password</label>
                <Input
                  type="password"
                  className="form-control"
                  name="password"
                  value={password}
                  onChange={onChangePassword}
                  validations={[required, vpassword]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="dep_code">Department Code</label>
                <Input
                  type="text"
                  className="form-control"
                  name="dep_code"
                  value={department}
                  onChange={onChangeDepartment}
                  validations={[required]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="loc_code">Location code</label>
                <Input
                  type="text"
                  className="form-control"
                  name="loc_code"
                  value={location}
                  onChange={onChangeLocation}
                  validations={[required]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="gender">Gender</label>
                <Input
                  type="text"
                  className="form-control"
                  name="gender"
                  value={gender}
                  onChange={onChangeGender}
                  validations={[required]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="fname">First Name</label>
                <Input
                  type="text"
                  className="form-control"
                  name="fname"
                  value={fname}
                  onChange={onChangeFirstName}
                  validations={[required]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="lname">Last Name</label>
                <Input
                  type="text"
                  className="form-control"
                  name="lname"
                  value={lname}
                  onChange={onChangeLastName}
                  validations={[required]}
                />
              </div>
              <div className="form-group">
                <label htmlFor="faculty">Faculty</label>
                <Input
                  type="text"
                  className="form-control"
                  name="faculty"
                  value={faculty}
                  onChange={onChangeFaculty}
                  validations={[required]}
                />
              </div>

              <div className="form-group">
                <button className="btn btn-primary btn-block">Sign Up</button>
              </div>
            </div>
          )}

          {message && (
            <div className="form-group">
              <div
                className={
                  successful ? "alert alert-success" : "alert alert-danger"
                }
                role="alert"
              >
                {message}
              </div>
            </div>
          )}
          <CheckButton style={{ display: "none" }} ref={checkBtn} />
        </Form>
      </div>
    </div>
  );
};

export default Register;
