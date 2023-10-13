import React from 'react';
import ReactDom from 'react-dom';
import './index.css';
import App from './App';
import reportWebvitals from './reportWebVitals';
ReactDom.render(
    <React.StrictMode>
        <App/>
    </React.StrictMode>,
    document.getElementById('root')
);
reportWebvitals();