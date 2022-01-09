import React from 'react';
import { NavLink } from "react-router-dom";

const Pages = () => {
    return (
        <nav>
            <NavLink
                style={({ isActive }) => {
                    return {
                        color: isActive ? "red" : ""
                    };
                }}
                to='/'
            >Home</NavLink>
                        <NavLink
                style={({ isActive }) => {
                    return {
                        color: isActive ? "red" : ""
                    };
                }}
                to='/contacts'
            >Contacts</NavLink>
                        <NavLink
                style={({ isActive }) => {
                    return {
                        color: isActive ? "red" : ""
                    };
                }}
                to='/interactions'
            >Interactions</NavLink>
                        <NavLink
                style={({ isActive }) => {
                    return {
                        color: isActive ? "red" : ""
                    };
                }}
                to='/opportunities'
            >Opportunities</NavLink>
        </nav>
    );
};

export default Pages;