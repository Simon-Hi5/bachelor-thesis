import { Container } from "react-bootstrap";
import { useParams } from "react-router";
import OpportunityDetails from "../../components/opportunity/OpportunityDetails";

const Opportunity = () => {
    let params = useParams();
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Opportunity: {params.id.substr(params.id.length - 8)}</h2>
            <OpportunityDetails id={params.id} />
        </Container>
    );
}

export default Opportunity;