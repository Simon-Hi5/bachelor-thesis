import React from 'react';
import { Outlet } from 'react-router';
import ContactList from '../components/contact/ContactList';

const Contacts = () => {
    return (
        <div>
            <h2>Contacts</h2>
            <ContactList />
            <Outlet />
        </div>
    );
}

export default Contacts;