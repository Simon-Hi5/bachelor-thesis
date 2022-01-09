import React, { Component } from 'react';
import axios from 'axios';

class ContactList extends Component {
    
    componentDidMount() {
        axios.get('')
    }

    render() {
        return (
            <div>
                <h2>List of Contacts</h2>
            </div>
        )
    }
}

export default ContactList;