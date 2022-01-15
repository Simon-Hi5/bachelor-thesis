import { Outlet } from 'react-router';
import './App.css';
import Navigation from './pages/Navigation';

function App() {
  return (
    <div className="App">
      <Navigation />
      <Outlet />
    </div>
  );
}

export default App;