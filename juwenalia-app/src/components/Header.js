import React from 'react';

function Header({ name, year }) {
  return (
    <header className="site-header">
      <h1>
        {name} <span className="year">{year}</span>
      </h1>
    </header>
  );
}

export default Header;
