import { Outlet } from 'react-router';
import './App.css';
import Navigation from './pages/Navigation';

function App() {
  return (
    <div className="App">
      <Navigation />
      <Outlet />
      <div className="mb-5"/>
    </div>
  );
}

export default App;