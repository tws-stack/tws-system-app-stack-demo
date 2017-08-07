import React, {Component} from "react";
import request from 'superagent';
require('../style/App.css');

class ComputeApp extends Component {
  constructor(props){
    super(props);
    this.state={
      text: ""
    }
  }

  componentDidMount(){
    request
      .get('/api/hello_world_service/hello')
      .end((err,res)=>{
        if(err){
          return console.log('err is :',err);
        }

        this.setState({
          text:res.text
        });
      })
  }

  render() {
    return (
      <div >
        <h1>{this.state.text}</h1>
      </div>
    );
  }
}

export default App;

