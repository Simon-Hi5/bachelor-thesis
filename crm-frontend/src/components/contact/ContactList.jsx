import React, { Component } from 'react';
import { NavLink } from 'react-router-dom';
import ContactService from '../../services/ContactService';
import { Container, Nav, Table } from 'react-bootstrap';

class ContactList extends Component {

    constructor(props) {
        super(props);

        this.state = {
            contacts: [],
        }
    }

    componentDidMount() {
        ContactService.getAllContacts()
            .then(response => {
                console.log(response.data);
                this.setState({
                    contacts: response.data
                })
            });
    }

    render() {
        const { contacts } = this.state;
        return (
            <Container>
                <Table responsive>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Last name</th>
                            <th>First name</th>
                            <th>Gender</th>
                            <th>Date of birth</th>
                            <th>Email</th>
                            <th>Phone number</th>
                            <th>Address</th>
                        </tr>
                    </thead>
                    <tbody>
                        {contacts.map(contact =>
                            <tr key={contact.id}>
                                <td>
                                    <NavLink
                                        style={({ isActive }) => {
                                            return {
                                                color: isActive ? "red" : ""
                                            };
                                        }}
                                        to={`/contacts/${contact.id}`}
                                        key={contact.id}
                                    >{contact.id}
                                    </NavLink></td>
                                <td>{(!!contact.lastName ? contact.lastName : "-")}</td>
                                <td>{(!!contact.firstName ? contact.firstName : "-")}</td>
                                <td>{(!!contact.gender ? contact.gender : "-")}</td>
                                <td>{(!!contact.dateOfBirth ? contact.dateOfBirth : "-")}</td>
                                <td>{(!!contact.email ? contact.email : "-")}</td>
                                <td>{(!!contact.phoneNumber ? contact.phoneNumber : "-")}</td>
                                <td>{(!!contact.address ? (contact.address.address + ", " +
                                    contact.address.postcode + " " + contact.address.) : "-")}</td>
                            </tr>
                        )}
                    </tbody>
                </Table>
            </Container>
        )
    }
}

export default ContactList;