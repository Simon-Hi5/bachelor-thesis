import React, { Component } from 'react';
import ContactService from '../../services/ContactService';

class ContactDetails extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contact: {},
        }
    }

    componentDidMount() {
        this.updateContact();
    }

    componentDidUpdate(prevProps) {
        if (this.props.id !== prevProps.id) {
            this.updateContact();
        }
    }

    updateContact() {
        ContactService.getContact(this.props.id)
            .then(response => {
                this.setState({
                    contact: response.data
                })
            })
    }

    render() {
        const { contact } = this.state;
        return (
            <div>
                <h4>Contact Details</h4>
                <p>{contact.lastName}</p>
                <p>{contact.firstName}</p>
                <p>{contact.email}</p>
            </div>
        )
    }
}

export default ContactDetails;