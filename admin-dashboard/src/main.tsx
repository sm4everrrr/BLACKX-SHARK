import React from 'react';
import { createRoot } from 'react-dom/client';
import './style.css';
function App() {
  return <main><p className="eyebrow">BLACKX SHARK / CONTROL</p><h1>Admin console</h1><section><h2>Backend connection required</h2><p>Catalog, orders, payment verification and support management will appear after the API is deployed and an authorized super-admin is provisioned.</p><strong>Do not verify payments from client-submitted UTRs alone.</strong></section></main>;
}
createRoot(document.getElementById('root')!).render(<React.StrictMode><App /></React.StrictMode>);
