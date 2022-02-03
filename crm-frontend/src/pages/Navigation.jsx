import React from 'react';
import { NavLink } from "react-router-dom";
import { Navbar, Container, Nav } from 'react-bootstrap';
import logo from '../logo.svg';

const Navigation = () => {
    return (
        <Navbar bg="primary" variant="dark">
            <Container>
                <Navbar.Brand as={NavLink} to='/' >
                    <img
                        alt=""
                        src={logo}
                        width="33"
                        height="33"
                        className="d-inline-block align-top"
                    />{' '}
                    Micro-CRM
                </Navbar.Brand>
                <Navbar.Collapse id="basic-navbar-nav"></Navbar.Collapse>
                <Nav className="me-auto">
                    <Nav.Link as={NavLink} to='/contacts' >Contacts</Nav.Link>
                    <Nav.Link as={NavLink} to='/interactions' >Interactions</Nav.Link>
                    <Nav.Link as={NavLink} to='/opportunities' >Opportunities</Nav.Link>
                </Nav>
            </Container>
        </Navbar>
    );
};

export default Navigation;