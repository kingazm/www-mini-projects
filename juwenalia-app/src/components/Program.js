import React from 'react';

export function Program({ program }) {
  return (
    <div className="card program-container">
      <p className="section-label">Program wydarzenia</p>
      <div className="program-list">
        {program.map((activity, i) => (
          <div key={i} className="program-item">
            <span className="program-num">{i + 1}</span>
            {activity}
          </div>
        ))}
      </div>
    </div>
  );
}
