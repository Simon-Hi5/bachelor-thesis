import React, { Component } from 'react';
import axios from 'axios';
import { CONTACT_API } from '../../Constants';
import { Link } from 'react-router-dom';

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
                {
                    contacts.map(contact => <Link to={`/contacts/${contact.id}`} key={contact.id}>{contact.lastName}</Link>)
                }
            </div>
        )
    }
}

export default ContactList;