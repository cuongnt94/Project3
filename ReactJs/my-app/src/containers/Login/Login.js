import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';
import RaisedButton from 'material-ui/RaisedButton';
import TextField from 'material-ui/TextField';
import React, { Component } from 'react';
import axios from 'axios';
import "./Login.css";

class Login extends Component{
    constructor(props){
        super(props);
        this.state={
        email:'',
        password:''
        }
       }
  state = {email: "", password: ""}
  handleClick(event){
    var apiBaseUrl = "http://localhost:9999/auth";
    var self = this;
    var payload={
    "email":this.state.email,
    "password":this.state.password
    }
    //console.log(apiBaseUrl+'/login')
    axios.post(apiBaseUrl+'/login', payload)
    .then(function (response) {
    console.log(response);
    if(response.data.code == 200){
    console.log("Login successfull");
    }
    else{
    console.log("Invalid Login");
    alert("Invalid Login");
    }
    })
    .catch(function (error) {
    console.log(error);
    });
    }
render(){
  return (
    <div>
        <MuiThemeProvider>
          <div>
           <TextField
             hintText="Enter your email"
             floatingLabelText="Email"
             onChange = {(event,newValue) => this.setState({email:newValue})}
             />
           <br/>
             <TextField
               type="password"
               hintText="Enter your Password"
               floatingLabelText="Password"
               onChange = {(event,newValue) => this.setState({password:newValue})}
               />
             <br/>
             <RaisedButton label="Submit" primary={true} onClick={(event) => this.handleClick(event)}/>
         </div>
         </MuiThemeProvider>
      </div>
    );
    }
    
}
export default Login;