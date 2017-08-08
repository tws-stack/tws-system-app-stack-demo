import React, {Component} from "react";
import request from 'superagent';
require('../../style/App.css');


class ComputeApp extends Component {
  constructor(props) {
    super(props);
    this.focus = (name) => {
      this.focus(name)
    };
    this.state = {
      text: "",
      answerAvailable: false,
      result: ''
    }
  }

  componentDidMount() {
    this.focus("add_a");
  }

  focus(name) {
    this[name].focus();
  }

  handleClick() {
    request
      .get('/api/compute_service/compute')
      .query({a: this.add_a})
      .query({b: this.add_b})
      .end((err, res) => {
        if (err) {
          console.log("err is: ", err);
        } else {
          this.setState({
            answerAvailable: true,
            result: res.text
          })
        }
      })
  }

  handleFocus(){
    this.setState({
      answerAvailable: false
    })
  }

  render() {
    return (
      <div>
        <form>
          <div className="form-group">
            <label htmlFor="formGroupExampleInput">一个加数</label>
            <input type="number" className="form-control" id="formGroupExampleInput" placeholder="Example input"
                   ref={(ref) => {
                     this.add_a = ref;
                   }} onBlur={() => {
              this.focus("add_b")
            }} onFocus={()=>{this.handleFocus()}} />
          </div>
          <div className="form-group">
            <label htmlFor="formGroupExampleInput2">另一个加数</label>
            <input type="number" className="form-control" id="formGroupExampleInput2" placeholder="Another input"
                   ref={(ref) => {
                     this.add_b = ref;
                   }}/>
          </div>
          <input className="btn btn-primary" type="submit" value="求和" onClick={() => {
            this.handleClick()
          }}/>
        </form>
        { this.state.answerAvailable ?
          (<div className="alert alert-success" role="alert">
            <strong>Well done!</strong> You successfully get answer :<a href="#" className="alert-link">{this.state.result}</a>.
          </div>) : ""
        }
      </div>
    );
  }
}

export default ComputeApp;

