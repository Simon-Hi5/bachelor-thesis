import React from 'react';
import { Container } from 'react-bootstrap';
import InteractionList from '../../components/interaction/InteractionList';

const Interactions = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Interactions</h2>
            <InteractionList />
        </Container>
    );
}

export default Interactions;