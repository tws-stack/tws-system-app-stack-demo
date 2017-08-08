import React from 'react';
import ReactDOM from 'react-dom';
import App from './component/App';
import {
  BrowserRouter as Router,
  Route,
  Link,
  IndexRoute
} from 'react-router-dom'

import ComputeApp from './component/compute-service/ComputeApp';

ReactDOM.render(
  <Router>
    <div>
      <div>
        <Route path="/hello" component={App}/>
        <Route path="/compute" component={ComputeApp}/>
      </div>

      <ul>
        <li><Link to="/hello">hello world!</Link></li>
        <li><Link to="/compute">compute App</Link></li>
      </ul>
    </div>
  </Router>,
  document.getElementById('root'));


