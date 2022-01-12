import { Outlet } from 'react-router';
import './App.css';
import Pages from './pages/Pages';

function App() {
  return (
    <div className="App">
      <h1>Micro-CRM</h1>
      <Pages />
      <Outlet />
    </div>
  );
}

export default App;