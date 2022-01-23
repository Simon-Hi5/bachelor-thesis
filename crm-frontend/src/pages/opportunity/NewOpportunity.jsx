import { Container } from "react-bootstrap";
import OpportunityForm from "../../components/opportunity/OpportunityForm";

const NewOpportunity = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">New Opportunity</h2>
            <OpportunityForm/>
        </Container>
    );
}

export default NewOpportunity;