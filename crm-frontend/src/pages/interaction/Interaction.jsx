import { Container } from "react-bootstrap";
import { useParams } from "react-router";
import InteractionDetails from "../../components/interaction/InteractionDetails";

const Interaction = () => {
    let params = useParams();
    return (
        <Container>
            <h2 className="text-start mt-4 mb-4">Interaction: {params.id.substr(params.id.length - 8)}</h2>
            <InteractionDetails id={params.id} />
        </Container>
    );
}

export default Interaction;