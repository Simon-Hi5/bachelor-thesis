import React from 'react';
import {
    BrowserRouter as Router,
    Route,
    Link,
    Routes,
} from "react-router-dom";

const Pages = () => {
    return (
        <nav>
            <Link to="/">Home</Link>
            <Link to="/contacts">Contacts</Link>
            <Link to="/interactions">Interactions</Link>
            <Link to="/opportunities">Opportunities</Link>
        </nav>
    );
};

export default Pages;