import React, { Component } from 'react';
import { Alert, Button, Card, Col, Form, Row } from 'react-bootstrap';
import ContactService from '../../services/ContactService';
import InteractionService from '../../services/InteractionService';
import { withRouter } from '../../withRouter';

class InteractionDetails extends Component {

    constructor(props) {
        super(props);

        this.handleDelete = this.handleDelete.bind(this);

        this.state = {
            error: "",
            contacts: [],
            interaction: {
                note: '',
                formOfInteraction: '',
                relatedContactId: '',
                dateAndTime: '',
                id: null,
            }
        }
    }

    componentDidMount() {
        InteractionService.getInteraction(this.props.id)
            .then(response => {
                this.setState({
                    interaction: response.data
                });
            })
            .catch(error => {
                this.setState({
                    error: error.response.data
                });
            });

        ContactService.getAllContacts()
            .then(response => {
                this.setState({
                    contacts: response.data
                })
            });
    }

    handleInteractionChange = event => {
        const interaction = this.state.interaction;
        interaction[event.target.name] = event.target.value;
        this.setState({
            interaction,
        })
    }

    handleDelete() {
        InteractionService.deleteInteraction(this.props.id)
            .then(() => {
                this.setState({
                    error: "",
                })
                this.props.navigate('/interactions')
            })
            .catch(error => {
                this.setState({
                    error: error.response.data
                });
            });
    }

    handleSubmit = event => {
        event.preventDefault();

        InteractionService.replaceInteraction(this.props.id, this.state.interaction)
            .then(() => {
                this.setState({
                    error: "",
                })
                this.props.navigate('/interactions')
            })
            .catch(error => {
                this.setState({
                    error: error.response.data,
                })
            });
    }

    render() {
        const { interaction, error, contacts } = this.state;
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
                                        <Form.Label>Form of interaction</Form.Label>
                                        <Form.Select aria-label="Default select example" name='formOfInteraction' value={interaction.formOfInteraction ? interaction.formOfInteraction : "-"} onChange={this.handleInteractionChange} >
                                            <option value="">Select form of interaction</option>
                                            <option value="EMAIL">EMAIL</option>
                                            <option value="PHONE">PHONE</option>
                                            <option value="MEETING">MEETING</option>
                                            <option value="COMPLAINT">COMPLAINT</option>
                                            <option value="MISC">MISC</option>
                                        </Form.Select>
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Date and time</Form.Label>
                                        <Form.Control type="datetime-local" name='dateAndTime' value={interaction.dateAndTime ? interaction.dateAndTime : "-"} onChange={this.handleInteractionChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Note</Form.Label>
                                        <Form.Control as="textarea" rows={3} name='note' value={interaction.note ? interaction.note : "-"} placeholder="Enter note" onChange={this.handleInteractionChange} />
                                    </Form.Group>
                                    <Form.Group className="mb-3" >
                                        <Form.Label>Realted contact</Form.Label>
                                        <Form.Select aria-label="Default select example" name='relatedContactId' value={interaction.relatedContactId ? interaction.relatedContactId : "-"} onChange={this.handleInteractionChange} >
                                            <option value="">Select related Contact ID</option>
                                            {contacts.map(contact =>
                                                <option key={contact.id} value={contact.id}>{contact.id.substr(contact.id.length - 8) + ", " + contact.firstName + " " + contact.lastName}</option>
                                            )}
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

export default withRouter(InteractionDetails);