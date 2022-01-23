import 'bootstrap/dist/css/bootstrap.min.css';
import React from 'react';
import { Container } from 'react-bootstrap';
import ReactDOM from 'react-dom';
import {
  BrowserRouter as Router, Route, Routes
} from "react-router-dom";
import App from './App';
import './index.css';
import Contact from './pages/contact/Contact';
import Contacts from './pages/contact/Contacts';
import Interactions from './pages/interaction/Interactions';
import NewContact from './pages/contact/NewContact';
import Opportunities from './pages/opportunity/Opportunities';
import reportWebVitals from './reportWebVitals';
import NewInteraction from './pages/interaction/NewInteraction';
import Interaction from './pages/interaction/Interaction';
import NewOpportunity from './pages/opportunity/NewOpportunity';
import Opportunity from './pages/opportunity/Opportunity';

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route exact path='/' element={<App />}>
          <Route exact path='contacts' element={<Contacts />} />
          <Route path="contacts/new" element={<NewContact />} />
          <Route path="contacts/:id" element={<Contact />} />
          <Route exact path='interactions' element={<Interactions />} />
          <Route path="interactions/new" element={<NewInteraction />} />
          <Route path="interactions/:id" element={<Interaction />} />
          <Route exact path='opportunities' element={<Opportunities />} />
          <Route path="opportunities/new" element={<NewOpportunity />} />
          <Route path="opportunities/:id" element={<Opportunity />} />
          <Route
            path="*"
            element={
              <Container>
              <h2 className="text-start mt-5 mb-5">There's nothing here!</h2>
            </Container>
            }
          />
        </Route>
      </Routes>
    </Router>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
