import React from 'react';
import ReactDOM from 'react-dom';
import App from '../component/App';

describe('test for components',()=>{
  it('test renders without crashing',()=>{
    const div = document.createElement('div');
      ReactDOM.render(<App />,div);
  })
});
