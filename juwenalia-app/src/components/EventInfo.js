import React from 'react';

export function EventInfo({ location, date, description }) {
  return (
    <div className="card event-info-container">
      <p className="section-label">Szczegóły</p>
      <div className="info-field">
        <div className="label">Lokalizacja</div>
        <div className="value">{location}</div>
      </div>
      <div className="info-field">
        <div className="label">Data</div>
        <div className="value">{date}</div>
      </div>
      <div className="info-field">
        <div className="label">Opis</div>
        <div className="value description">{description}</div>
      </div>
    </div>
  );
}
