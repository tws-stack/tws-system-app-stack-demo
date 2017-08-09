import React, {Component} from 'react';
import '../style/App.css';

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            text: ''
        }
    }

    componentDidMount() {
        const request = new Request('/api/hello_world_service/hello', {
            method: 'GET',
            headers: new Headers({
                'Content-Type': 'text/plain',
                'Accept': 'application/json'
            })
        });

        fetch(request).then(response => {
            return response.text();
        }).then(text=>{
            this.setState({text});
        }).catch(error => {
            console.log('err is :',error);
        });
    }

    render() {
        return (
            <div className="App">
                <h1>
                    {this.state.text}
                </h1>
            </div>
        );
    }
}

export default App;
