import logo from './logo.svg';
import './App.css';
import ContactList from './components/contact/ContactList';
import ContactForm from './components/contact/ContactForm';

function App() {
  return (
      <div className="App">
        <ContactList/>
        <ContactForm/>
      </div>
  );
}

export default App;