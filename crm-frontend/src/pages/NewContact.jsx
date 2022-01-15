import { Container, Button } from "react-bootstrap";
import ContactForm from "../components/contact/ContactForm";

const NewContact = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">New Contact</h2>
            <ContactForm/>
        </Container>
    );
}

export default NewContact;