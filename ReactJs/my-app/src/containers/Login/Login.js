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
        password:'',
        token:''
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
    console.log(apiBaseUrl+'/login')
    axios.post(apiBaseUrl+'/login', payload)
    .then(response => {
            console.log(response);
        console.log(response.data)
        if(response.data != 401){
            console.log("Login Successful" + response.data);
            this.token = response.data;
            alert("Login Successful"+ this.token);

            }
            else{
            console.log("Invalid Login" + response.data);
            alert("Invalid Login"+ response.data);
            }
    })
    
  
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