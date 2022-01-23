import { Container } from "react-bootstrap";
import { useParams } from "react-router";
import ContactDetails from "../../components/contact/ContactDetails";
import InteractionList from "../../components/interaction/InteractionList";
import OpportunityList from "../../components/opportunity/OpportunityList";

const Contact = () => {
    let params = useParams();
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Contact: {params.id.substr(params.id.length - 8)}</h2>
            <ContactDetails id={params.id} />
            <h3 className="text-start mt-5 mb-4">Related interactions</h3>
            <InteractionList id={params.id} />
            <h3 className="text-start mt-5 mb-4">Related opportunities</h3>
            <OpportunityList id={params.id} />
        </Container>
    );
}

export default Contact;