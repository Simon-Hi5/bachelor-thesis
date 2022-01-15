import React from 'react';
import ContactList from '../components/contact/ContactList';
import { Button, Container } from 'react-bootstrap';
import { NavLink } from "react-router-dom";

const Contacts = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Contacts</h2>
            <ContactList />
        </Container>
    );
}

export default Contacts;