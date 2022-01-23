import React from 'react';
import { Container } from 'react-bootstrap';
import OpportunityList from '../../components/opportunity/OpportunityList';

const Opportunities = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Opportunities</h2>
            <OpportunityList />
        </Container>
    );
}

export default Opportunities;