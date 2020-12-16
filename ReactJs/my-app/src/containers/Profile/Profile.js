import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import DayPicker from 'react-day-picker';
import DatePicker from 'react-datepicker';
import 'react-day-picker/lib/style.css';
import axios from 'axios'; 
import 'bootstrap/dist/css/bootstrap.min.css';
import './Profile.css';
class Profile extends Component {
    /*constructor(props) {
       super(props)
       const [state, setState] = useState({
        weekEnding: "",
        billingHours: "",
        compensatedHours: "",
        startingTime: true,
        endingTime: "master",
        totalHours: "",
        floatingDay: false,
        holiday: false,
        vacation: false
      });
    }*/

    state = {
        phone: "",
        email: "",
        address: "",
        emergencyName1: "",
        emergencyPhone1: "",
        emergencyName2: "",
        emergencyPhone2: "",
        
    }

    handleChange = (evt) => {
        const value = evt.target.value;
        this.setState({
          ...this.state,
          [evt.target.name]: value
        });
    }

    render() {
       return (
            <div className="app">
                <form>
                    <label>
                        <div className="heading">Contact</div>
                        <input
                            type="text"
                            name="phone"
                            value={this.state.phone}
                            onChange={this.handleChange}
                            placeholder = "phone number"
                        />
                    </label>
                    <label>
                        <input
                            type="text"
                            name="email"
                            value={this.state.email}
                            onChange={this.handleChange}
                            placeholder = "email"
                        />
                    </label>
                    <label>
                        <input
                            type="text"
                            name="address"
                            value={this.state.address}
                            onChange={this.handleChange}
                            placeholder = "address"
                        />
                    </label>
                    <label>
                        <div className="heading">Emergency Contact 1</div>
                        <input
                            type="text"
                            name="emergencyName1"
                            value={this.state.emergencyName1}
                            onChange={this.handleChange}
                            placeholder = "name"
                        />
                    </label>
                    <label>
                        <input
                            type="text"
                            name="emergencyPhone1"
                            value={this.state.emergencyPhone1}
                            onChange={this.handleChange}
                            placeholder = "phone number"
                        />
                    </label>
                    <label>
                        <div className="heading">Emergency Contact 2</div>
                        <input
                            type="text"
                            name="emergencyName2"
                            value={this.state.emergencyName2}
                            onChange={this.handleChange}
                            placeholder = "name"
                        />
                    </label>
                    <label>
                        <input
                            type="text"
                            name="emergencyPhone2"
                            value={this.state.emergencyPhone2}
                            onChange={this.handleChange}
                            placeholder = "phone number"
                        />
                    </label>
                </form>    
            </div>
        )
    }
}

 export default Profile;