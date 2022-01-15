import { useParams } from "react-router";
import ContactDetails from "../components/contact/ContactDetails";
import { Container, Button } from "react-bootstrap";

const Contact = () => {
    let params = useParams();
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Contact: {params.id.substr(params.id.length - 8)}</h2>
            <ContactDetails id={params.id} />
        </Container>
    );
}

export default Contact;