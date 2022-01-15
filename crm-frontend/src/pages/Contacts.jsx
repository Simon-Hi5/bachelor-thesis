import React from 'react';
import { Container } from 'react-bootstrap';
import ContactList from '../components/contact/ContactList';

const Contacts = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Contacts</h2>
            <ContactList />
        </Container>
    );
}

export default Contacts;