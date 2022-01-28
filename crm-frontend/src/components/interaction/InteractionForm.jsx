import React, { Component } from "react";
import { Alert, Button, Card, Col, Form, Row } from "react-bootstrap";
import ContactService from "../../services/ContactService";
import InteractionService from "../../services/InteractionService";
import { withRouter } from "../../withRouter";

class InteractionForm extends Component {

    constructor(props) {
        super(props);

        this.handleSubmit = this.handleSubmit.bind(this);

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

    handleSubmit = event => {
        event.preventDefault();

        InteractionService.saveInteraction(this.state.interaction)
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
                                    <Form.Label>Form of interaction</Form.Label>
                                    <Form.Select aria-label="Default select example" name='formOfInteraction' value={interaction.formOfInteraction} onChange={this.handleInteractionChange} >
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
                                    <Form.Control type="datetime-local" name='dateAndTime' value={interaction.dateAndTime} onChange={this.handleInteractionChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Note</Form.Label>
                                    <Form.Control as="textarea" rows={3} name='note' value={interaction.note} placeholder="Enter note" onChange={this.handleInteractionChange} />
                                </Form.Group>
                                <Form.Group className="mb-3" >
                                    <Form.Label>Realted contact</Form.Label>
                                    <Form.Select aria-label="Default select example" name='relatedContactId' value={interaction.relatedContactId} onChange={this.handleInteractionChange} >
                                        <option value="">Select related Contact ID</option>
                                        {contacts.map(contact => 
                                            <option key={contact.id} value={contact.id}>{contact.id.substr(contact.id.length - 8)+ ", " + contact.firstName + " " + contact.lastName}</option>
                                            )}
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

export default withRouter(InteractionForm);