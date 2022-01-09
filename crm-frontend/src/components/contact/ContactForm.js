import React, { Component } from "react";
import axios from 'axios';
import { CONTACT_API } from "../../Constants";

class ContactForm extends Component {

    constructor(props) {
        super(props);

        this.state = {
            address: {
                additionalAddress: '',
                addresscountry: '',
                postcode: '',
                town: '',
            },
            dateOfBirth: '',
            email: '',
            firstNamegender: '',
            id: '',
            lastName: '',
            phoneNumber: '',
        }
    }

    handleChange = event => {
        this.setState({
            [event.target.name]: event.target.value,
        })
    }

    handleSubmit = event => {
        event.preventDefault();

        axios.post(CONTACT_API, this.state)
            .then(response => {

            }
            )
    }

    render() {
        const { lastName, firstName } = this.state;
        return (
            <div>
                <form onSubmit={this.handleSubmit}>
                    <div>
                        <label>Last name</label>
                        <input
                            type='text'
                            name='lastName'
                            value={lastName}
                            onChange={this.handleChange}
                        ></input>
                        <label>First name</label>
                        <input
                            type='text'
                            name='firstName'
                            value={firstName}
                            onChange={this.handleChange}
                        ></input>
                    </div>
                    <div>
                        <button type='submit'>Submit</button>
                    </div>
                </form>
            </div>
        )
    }
}

export default ContactForm;