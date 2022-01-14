import React from 'react';
import { Outlet } from 'react-router';
import ContactList from '../components/contact/ContactList';
import { Container } from 'react-bootstrap';

const Contacts = () => {
    return (
        <Container>
            <h2>Contacts</h2>
            <ContactList />
            <Outlet />
        </Container>
    );
}

export default Contacts;