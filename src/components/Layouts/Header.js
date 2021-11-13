import React, { useState, useCallback, Fragment } from "react";
import { Link } from "react-router-dom";
import studentLogo from "../../images/studentLogo.png";
import "./Header.css";
import { Collapse, NavbarToggler, Nav, NavItem, NavLink } from "reactstrap";
import { useDispatch, useSelector } from "react-redux";
import { logout } from "../../actions/auth";
import LogoutIcon from "@mui/icons-material/Logout";
function Header() {
  const dispatch = useDispatch();
  const [collapsed, setCollapsed] = useState(false);
  const toggleNavbar = () => setCollapsed(!collapsed);
  const { user: currentUser } = useSelector((state) => state?.auth);

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
            <div className="header__logout" type="submit" onClick={logOut}>
              <LogoutIcon className="logout__icon" />
              <span>Logout</span>
            </div>
          </>
        )}
        {!currentUser && (
          <>
            <NavbarToggler onClick={toggleNavbar} className="mr-2" />
            <Collapse isOpen={collapsed} navbar>
              <Nav>
                <NavItem>
                  <NavLink href="/guest-test" className="header_text">
                    Test
                  </NavLink>
                </NavItem>
                <NavItem>
                  <NavLink href="/login" className="header_text">
                    Login
                  </NavLink>
                </NavItem>
              </Nav>
            </Collapse>
          </>
        )}
      </div>
    </header>
  );
}

export default Header;
