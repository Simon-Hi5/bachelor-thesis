import { useParams } from "react-router";
import ContactDetails from "../components/contact/ContactDetails";

const Contact = () => {
    let params = useParams();
    console.log("test");
    return (
        <ContactDetails id={params.id} />
    );
}

export default Contact;