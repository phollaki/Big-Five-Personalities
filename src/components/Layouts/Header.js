import React, { useState, useCallback, Fragment } from "react";
import { Link } from "react-router-dom";
import studentLogo from "../../images/studentLogo.png";
import "./Header.css";
import { Collapse, NavbarToggler, Nav, NavItem, NavLink } from "reactstrap";
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../../actions/auth";
function Header() {
  const dispatch = useDispatch();
  const [collapsed, setCollapsed] = useState(false);
  const toggleNavbar = () => setCollapsed(!collapsed);
  const { user: currentUser } = useSelector((state) => state.auth);
  console.log(currentUser.personality);
  const logOut = useCallback(() => {
    dispatch(logout());
  }, [dispatch]);

  return (
    <header className="navbar navbar-expand-lg header fixed-top">
      <div className="container-fluid">
        <Link to="/" className="navbar-brand d-flex header_logo">
          <img
            src={studentLogo}
            alt="Student logo for student management system"
            width="40px"
            height="40px"
          />
          <h4 className="header__title">The Big 5 Traits</h4>
        </Link>
        {currentUser && (
          <>
            <NavbarToggler onClick={toggleNavbar} className="mr-2" />
            <Collapse isOpen={collapsed} navbar>
              <Nav>
                <NavItem>
                  <NavLink href="/test" className="header_text">
                    Test
                  </NavLink>
                </NavItem>

                <NavItem>
                  <NavLink href="/compare" className="header_text">
                    Compare
                  </NavLink>
                </NavItem>
                {currentUser.personality != null && (
                  <Fragment>
                    <NavItem>
                      <NavLink href="/personality" className="header_text">
                        My Result
                      </NavLink>
                    </NavItem>
                    <NavItem>
                      <NavLink href="/calculation" className="header_text">
                        Calculation
                      </NavLink>
                    </NavItem>
                  </Fragment>
                )}
              </Nav>
            </Collapse>
            <div className="nav justify-content-center">
              <NavLink
                href="/personality"
                style={{
                  textDecoration: "none",
                  color: "black",
                }}
              >
                <span>Welcome </span>
                <span>
                  <b>{currentUser.username}</b>
                </span>
                <span>!</span>
              </NavLink>
            </div>
            <button
              className="btn btn-sample my-2 my-sm-0"
              type="submit"
              onClick={logOut}
            >
              Logout
            </button>
          </>
        )}
      </div>
    </header>
  );
}

export default Header;
