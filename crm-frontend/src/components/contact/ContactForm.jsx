import React, { Component } from "react";
import ContactService from "../../services/ContactService";
import { Form, Button, Card, Alert, Row, Col } from "react-bootstrap";
import { withRouter } from "../../withRouter";

class ContactForm extends Component {

    constructor(props) {
        super(props);

        this.handleSubmit=this.handleSubmit.bind(this);

        this.state = {
            error: "",
            contact: {
                address: {
                    additionalAddress: '',
                    address: '',
                    country: '',
                    postcode: '',
                    town: '',
                },
                dateOfBirth: '',
                email: '',
                firstName: '',
                gender: '',
                id: null,
                lastName: '',
                phoneNumber: '',
            }
        }
    }

    handleContactChange = event => {
        const contact = this.state.contact;
        contact[event.target.name] = event.target.value;
        this.setState({
            contact,
        })
    }

    handleAddressChange = event => {
        const contact = this.state.contact;
        contact.address[event.target.name] = event.target.value;
        this.setState({
            contact,
        })
    }

    handleSubmit = event => {
        event.preventDefault();

        ContactService.saveContact(this.state.contact)
            .then(response => {
                this.setState({
                    error: "",
                })
                this.props.navigate('/contacts')
            })
            .catch(error => {
                this.setState({
                    error: error.response.data,
                })
            });
    }

    render() {
        const { contact, error } = this.state;
        return (
            <Card>
                <Card.Body>
                    {!error ? "" :
                        <Alert variant="danger">
                            {error.error}: {error.message}
                        </Alert>
                    }
                    <Form onSubmit={this.handleSubmit}>
                        <Row>
                            <Col>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Last name</Form.Label>
                                    <Form.Control type="text" name='lastName' value={contact.lastName} placeholder="Enter last name" onChange={this.handleContactChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>First name</Form.Label>
                                    <Form.Control type="text" name='firstName' value={contact.firstName} placeholder="Enter first name" onChange={this.handleContactChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Gender</Form.Label>
                                    <Form.Select aria-label="Default select example" name='gender' value={contact.gender} onChange={this.handleContactChange} >
                                        <option>Select gender</option>
                                        <option value="MALE">MALE</option>
                                        <option value="FEMALE">FEMALE</option>
                                        <option value="DIVERSE">DIVERSE</option>
                                    </Form.Select>
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Date of birth</Form.Label>
                                    <Form.Control type="date" name='dateOfBirth' value={contact.dateOfBirth} onChange={this.handleContactChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Email</Form.Label>
                                    <Form.Control type="email" name='email' value={contact.email} placeholder="Enter email" onChange={this.handleContactChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Phone number</Form.Label>
                                    <Form.Control type="tel" name='phoneNumber' value={contact.phoneNumber} placeholder="Enter phone number" onChange={this.handleContactChange} />
                                </Form.Group>
                            </Col>
                            <Col>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Address</Form.Label>
                                    <Form.Control type="text" name='address' value={contact.address.address} placeholder="Enter address" onChange={this.handleAddressChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Additional address</Form.Label>
                                    <Form.Control type="text" name='additionalAddress' value={contact.address.additionalAddress} placeholder="Enter additional address" onChange={this.handleAddressChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Postcode</Form.Label>
                                    <Form.Control type="number" name='postcode' value={contact.address.postcode} placeholder="Enter postcode" onChange={this.handleAddressChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Town</Form.Label>
                                    <Form.Control type="text" name='town' value={contact.address.town} placeholder="Enter town" onChange={this.handleAddressChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Country</Form.Label>
                                    <Form.Select aria-label="Default select example" name='country' value={contact.address.country} onChange={this.handleAddressChange} >
                                        <option>Select country</option>
                                        <option value="GERMANY">GERMANY</option>
                                        <option value="AUSTRIA">AUSTRIA</option>
                                        <option value="SWITZERLAND">SWITZERLAND</option>
                                    </Form.Select>
                                </Form.Group>
                            </Col>
                        </Row>
                        <Button variant='primary' type='submit'>Create</Button>
                    </Form>
                </Card.Body>
            </Card>
        )
    }
}

export default withRouter(ContactForm);