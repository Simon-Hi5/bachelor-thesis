import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import Interactions from './pages/Interactions';
import Opportunities from './pages/Opportunities';
import Contacts from './pages/Contacts';
import Contact from './pages/Contact';
import { Container } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.min.css';
import NewContact from './pages/NewContact';

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route exact path='/' element={<App />}>
          <Route exact path='contacts' element={<Contacts />} />
          <Route path="contacts/new" element={<NewContact />} />
          <Route path="contacts/:id" element={<Contact />} />
          <Route exact path='interactions' element={<Interactions />} />
          <Route exact path='opportunities' element={<Opportunities />} />
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
