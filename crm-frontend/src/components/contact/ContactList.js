import React, { Component } from 'react';
import axios from 'axios';

class ContactList extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contacts: [],
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8080/contacts')
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
                <h2>List of Contacts</h2>
                {
                    contacts.map(contact => <div key={contact.id}>{contact.lastName}</div>)
                }
            </div>
        )
    }
}

export default ContactList;