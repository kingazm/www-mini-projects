import './App.css';
import eventData from './resources/eventData.json';
import Header from './components/Header';
import { EventInfo } from './components/EventInfo';
import { Calendar } from './components/Calendar';
import { Program } from './components/Program';
import { ArtistsAttractions } from './components/ArtistsAttractions';
import { Footer } from './components/Footer';

function App() {
  return (
    <div className="App">
      <Header
          name={eventData.name}
          year={eventData.year}
      />
      <div className="event-main">
        <EventInfo
          location={eventData.location}
          date={eventData.date}
          description={eventData.description}
        />
        <Calendar 
          dateStart={eventData.dateStart} 
          dateEnd={eventData.dateEnd} 
          facebook={eventData.facebook}
        />
      </div>
      <Program program={eventData.program} />
      <ArtistsAttractions artists={eventData.artists} />
      <Footer />
    </div>
  );
}

export default App;
