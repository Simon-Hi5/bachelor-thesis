import { Container } from "react-bootstrap";
import InteractionForm from "../../components/interaction/InteractionForm";

const NewInteraction = () => {
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">New Interaction</h2>
            <InteractionForm/>
        </Container>
    );
}

export default NewInteraction;