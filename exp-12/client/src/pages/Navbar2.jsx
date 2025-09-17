import React from "react";
import { Link } from "react-router-dom";

const Navbar2 = () => {
    return (
        <ul style={{ listStyle: 'none',display: 'flex', gap: '1rem'}}>
            <li>
               <Link to="/home">Home</Link>
            </li>
            <li>
               <Link to="/about">About</Link>
            </li>
        </ul>
    );
};

export default Navbar2;
