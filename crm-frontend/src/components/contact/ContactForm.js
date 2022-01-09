import React, { Component } from "react";
import axios from 'axios';

class ContactForm extends Component {

    constructor(props) {
        super(props);
    
        this.state = {
             lastName: '',
             firstName: '',
        }
    }

    handleChange = (e) => {
        this.setState({
            [e.target.name]: e.target.value,
        })
    }

    handleSubmit = (e) => {
        axios.post('http://localhost:8080/contacts', this.state)
            .then(response => {

            }
        )
    }

    render() {
        const {lastName, firstName} = this.state;
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