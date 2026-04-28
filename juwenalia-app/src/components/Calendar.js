import React from 'react';

const WEEKDAYS = ['Pn', 'Wt', 'Śr', 'Cz', 'Pt', 'So', 'Nd'];

const MONTH_NAMES_PL = [
  'Styczeń', 'Luty', 'Marzec', 'Kwiecień', 'Maj', 'Czerwiec',
  'Lipiec', 'Sierpień', 'Wrzesień', 'Październik', 'Listopad', 'Grudzień',
];

function toMon0(jsDay) {
  return (jsDay + 6) % 7;
}

export function Calendar({ dateStart, dateEnd, facebook}) {
  const start = new Date(dateStart);
  const end   = new Date(dateEnd);

  const year  = start.getFullYear();
  const month = start.getMonth();

  const daysInMonth    = new Date(year, month + 1, 0).getDate();
  const firstDayOffset = toMon0(new Date(year, month, 1).getDay());

  const eventStart = start.getDate();
  const eventEnd   = end.getDate();

  const cells = [
    ...Array(firstDayOffset).fill(null),
    ...Array.from({ length: daysInMonth }, (_, i) => i + 1),
  ];

  function dayClass(day) {
    if (!day) return 'cal-day empty';
    if (day < eventStart || day > eventEnd) return 'cal-day';
    const classes = ['cal-day', 'event-day'];
    if (day === eventStart) classes.push('event-start');
    else if (day === eventEnd) classes.push('event-end');
    else classes.push('event-mid');
    return classes.join(' ');
  }

  return (
    <div className="card calendar">
      <div className="calendar-month">{MONTH_NAMES_PL[month]} {year}</div>
      <div className="calendar-grid">
        {WEEKDAYS.map(d => (
          <div key={d} className="cal-weekday">{d}</div>
        ))}
        {cells.map((day, i) => (
          <div key={i} className={dayClass(day)}>{day}</div>
        ))}
      </div>
      <div className="calendar-footer">
        Dołącz do wydarzenia {facebook && (
        <a href={facebook} target="_blank" rel="noopener noreferrer" className="fb-link">
          <svg viewBox="0 0 24 24" fill="currentColor" width="20" height="20">
            <path d="M24 12.073C24 5.405 18.627 0 12 0S0 5.405 0 12.073C0 18.1 4.388 23.094 10.125 24v-8.437H7.078v-3.49h3.047V9.41c0-3.025 1.792-4.697 4.533-4.697 1.312 0 2.686.236 2.686.236v2.97h-1.513c-1.491 0-1.956.931-1.956 1.886v2.268h3.328l-.532 3.49h-2.796V24C19.612 23.094 24 18.1 24 12.073z"/>
          </svg>
        </a>
      )}
      </div>
    </div>
  );
}
