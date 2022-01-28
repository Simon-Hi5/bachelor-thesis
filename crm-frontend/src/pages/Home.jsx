import { Button, Container, Card, Row, Col } from "react-bootstrap";
import { NavLink } from "react-router-dom";

const Home = () => {
    return (
        <Container>
            <h1 className="text-start mt-4 mb-4">Micro-CRM</h1>
            <div>
                <Row>
                    <Col>
                        <Card style={{ width: '18rem' }}>
                            <Card.Body>
                                <Card.Title><h3 className="mt-2 mb-3">Contact Management</h3></Card.Title>
                                <Button className="mt-3 mb-2" variant="primary" as={NavLink} to='/contacts'>Contacts</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: '18rem' }}>
                            <Card.Body>
                            <Card.Title><h3 className="mt-2 mb-3">Interaction Management</h3></Card.Title>
                                <Button className="mt-3 mb-2" variant="primary" as={NavLink} to='/interactions'>Interactions</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card style={{ width: '18rem' }}>
                            <Card.Body>
                            <Card.Title><h3 className="mt-2 mb-3">Opportunity Management</h3></Card.Title>
                                <Button className="mt-3 mb-2" variant="primary" as={NavLink} to='/opportunities'>Opportunities</Button>
                            </Card.Body>
                        </Card>
                    </Col>
                </Row>
            </div>
        </Container>
    );
}

export default Home;