import React, { Component } from 'react';
import axios from 'axios';
import { CONTACT_API } from '../../Constants';
import { NavLink } from 'react-router-dom';

class ContactList extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contacts: [],
        }
    }

    componentDidMount() {
        axios.get(CONTACT_API)
            .then(response => {
                this.setState({
                    contacts: response.data
                })
            });
    }

    render() {
        const { contacts } = this.state;
        return (
            <div>
                <h3>List of Contacts</h3>
                <nav>
                    {
                        contacts.map(contact =>
                            <NavLink 
                                style={({ isActive }) => {
                                    return {
                                        color: isActive ? "red" : ""
                                    };
                                }}
                                to={`/contacts/${contact.id}`}
                                key={contact.id}
                            >
                                {contact.lastName}
                            </NavLink>
                        )
                    }
                </nav>
            </div>
        )
    }
}

export default ContactList;