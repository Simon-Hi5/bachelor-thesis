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

ReactDOM.render(
  <React.StrictMode>
    <Router>
      <Routes>
        <Route exact path='/' element={<App />}>
          <Route exact path='contacts' element={<Contacts />}>
            <Route path=":id" element={<Contact />} />
            <Route
              index
              element={
                  <p>Select an invoice</p>
              }
            />
          </Route>
          <Route exact path='interactions' element={<Interactions />} />
          <Route exact path='opportunities' element={<Opportunities />} />
          <Route
            path="*"
            element={
              <p>There's nothing here!</p>
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
