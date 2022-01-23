import React, { Component } from 'react';
import { Alert, Button, Card, Col, Form, Row } from 'react-bootstrap';
import ContactService from '../../services/ContactService';
import { withRouter } from '../../withRouter';

class ContactDetails extends Component {

    constructor(props) {
        super(props);

        this.handleDelete = this.handleDelete.bind(this);

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

    componentDidMount() {
        ContactService.getContact(this.props.id)
            .then(response => {
                this.setState({
                    contact: response.data
                });
            })
            .catch(error => {
                this.setState({
                    error: error.response.data
                });
            });
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

    handleDelete() {
        ContactService.deleteContact(this.props.id)
            .then(() => {
                this.setState({
                    error: "",
                })
                this.props.navigate('/contacts')
            })
            .catch(error => {
                this.setState({
                    error: error.response.data
                });
            });
    }

    handleSubmit = event => {
        event.preventDefault();

        ContactService.replaceContact(this.props.id, this.state.contact)
            .then(() => {
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
        if (error) {
            return (
                <Alert variant="danger">
                    {error.error}: {error.message}
                </Alert>
            );
        }
        return (
            <div>
                <Button className="text-start mb-4" variant="danger" onClick={this.handleDelete} >Delete</Button>{' '}
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
                                        <Form.Control type="text" name='lastName' value={contact.lastName ? contact.lastName : "-"} placeholder="Enter last name" onChange={this.handleContactChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>First name</Form.Label>
                                        <Form.Control type="text" name='firstName' value={contact.firstName ? contact.firstName : "-"} placeholder="Enter first name" onChange={this.handleContactChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Gender</Form.Label>
                                        <Form.Select aria-label="Default select example" name='gender' value={contact.gender ? contact.gender : "-"} onChange={this.handleContactChange} >
                                            <option value="">Select gender</option>
                                            <option value="MALE">MALE</option>
                                            <option value="FEMALE">FEMALE</option>
                                            <option value="DIVERSE">DIVERSE</option>
                                        </Form.Select>
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Date of birth</Form.Label>
                                        <Form.Control type="date" name='dateOfBirth' value={contact.dateOfBirth ? contact.dateOfBirth : "-"} onChange={this.handleContactChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Email</Form.Label>
                                        <Form.Control type="email" name='email' value={contact.email ? contact.email : "-"} placeholder="Enter email" onChange={this.handleContactChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Phone number</Form.Label>
                                        <Form.Control type="tel" name='phoneNumber' value={contact.phoneNumber ? contact.phoneNumber : "-"} placeholder="Enter phone number" onChange={this.handleContactChange} />
                                    </Form.Group>
                                </Col>
                                <Col>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Address</Form.Label>
                                        <Form.Control type="text" name='address' value={contact.address && contact.address.address ? contact.address.address : "-"} placeholder="Enter address" onChange={this.handleAddressChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Additional address</Form.Label>
                                        <Form.Control type="text" name='additionalAddress' value={contact.address && contact.address.additionalAddress ? contact.address.additionalAddress : "-"} placeholder="Enter additional address" onChange={this.handleAddressChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Postcode</Form.Label>
                                        <Form.Control type="number" name='postcode' value={contact.address && contact.address.postcode ? contact.address.postcode : "-"} placeholder="Enter postcode" onChange={this.handleAddressChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Town</Form.Label>
                                        <Form.Control type="text" name='town' value={contact.address && contact.address.town ? contact.address.town : "-"} placeholder="Enter town" onChange={this.handleAddressChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Country</Form.Label>
                                        <Form.Select aria-label="Default select example" name='country' value={contact.address && contact.address.country ? contact.address.country : "-"} onChange={this.handleAddressChange} >
                                            <option value="">Select country</option>
                                            <option value="GERMANY">GERMANY</option>
                                            <option value="AUSTRIA">AUSTRIA</option>
                                            <option value="SWITZERLAND">SWITZERLAND</option>
                                        </Form.Select>
                                    </Form.Group>
                                </Col>
                            </Row>
                            <Button variant='primary' type='submit'>Update</Button>
                        </Form>
                    </Card.Body>
                </Card>
            </div>
        );
    }
}

export default withRouter(ContactDetails);