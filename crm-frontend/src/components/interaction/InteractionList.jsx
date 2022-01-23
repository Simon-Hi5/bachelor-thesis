import React, { Component } from 'react';
import { Button, Card, Nav, Table } from 'react-bootstrap';
import { NavLink } from 'react-router-dom';
import InteractionService from '../../services/InteractionService';

class InteractionList extends Component {

    constructor(props) {
        super(props);

        this.state = {
            interactions: [],
        }
    }

    componentDidMount() {
        InteractionService.getAllInteractions()
            .then(response => {
                this.setState({
                    interactions: response.data
                })
            });
    }

    render() {
        const { interactions } = this.state;
        return (
            <div>
                <Button className="text-start mb-4" variant="primary" as={NavLink} to='/interactions/new'>New</Button>{' '}
                <Card>
                    <Card.Body>
                        <Table responsive>
                            <thead>
                                <tr>
                                    <th>#</th>
                                    <th>Form of interaction</th>
                                    <th>Date and time</th>
                                    <th>Note</th>
                                    <th>Related contact</th>
                                </tr>
                            </thead>
                            <tbody>
                                {interactions.map(interaction =>
                                    <tr key={interaction.id}>
                                        <td>
                                            <Nav.Link style={{ display: 'contents' }} as={NavLink} to={`/interactions/${interaction.id}`} key={interaction.id}>
                                                {interaction.id.substr(interaction.id.length - 8)}
                                            </Nav.Link>
                                        </td>
                                        <td>{(interaction.formOfInteraction ? interaction.formOfInteraction : "-")}</td>
                                        <td>{(interaction.dateAndTime ? interaction.dateAndTime : "-")}</td>
                                        <td>{(interaction.note ? interaction.note : "-")}</td>
                                        <td>
                                            {(interaction.relatedContactId ? (
                                             <Nav.Link style={{ display: 'contents' }} as={NavLink} to={`/contacts/${interaction.relatedContactId}`} key={interaction.relatedContactId}>
                                                {interaction.relatedContactId.substr(interaction.relatedContactId.length - 8)}
                                                </Nav.Link>
                                            ) : "-")}
                                        </td>
                                    </tr>
                                )}
                            </tbody>
                        </Table>
                    </Card.Body>
                </Card>
            </div>
        )
    }
}

export default InteractionList;