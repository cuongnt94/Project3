import React from "react";
import {
  BrowserRouter as Router,
  Switch,
  Route,
  Link,
  Redirect
} from "react-router-dom";
import Summary from "./containers/Summary/Summary";
import TimeSheet from "./containers/TimeSheet/TimeSheet";

export default function App() {
  return (
    <Router>
      <div>
        <nav>
          <ul> 
            <li>
              <Link to="/">Summary</Link>
            </li>
            <li>
              <Link to="/timesheet">TimeSheet</Link>
            </li>
            <li>
              <Link to="/profile">Profile</Link>
            </li>
          </ul>
        </nav>

        {/* A <Switch> looks through its children <Route>s and
            renders the first one that matches the current URL. */}
        <Switch>
          <Route path="/timesheet" component = {TimeSheet}/>
          <Route path="/profile"/>
          <Route path="/" exact component ={Summary}/>
          <Redirect to="/" />
        </Switch>
      </div>
    </Router>
  );
}

function Home() {
  return <h2>Home</h2>;
}

function About() {
  return <h2>About</h2>;
}

function Users() {
  return <h2>Users</h2>;
}
