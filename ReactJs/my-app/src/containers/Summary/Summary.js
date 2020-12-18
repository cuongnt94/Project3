import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import './Summary.css';
import axios from 'axios';

class Summary extends Component {      
    constructor(props) {
         super(props)
         this.state = {
            summaryUnits: [
            { weekEnding: '3/24/2018', totalHours: 40, submissionStatus: 'Not Started', approvalStatus: 'N/A', option: 'Edit', comment: '' },
            { weekEnding: '3/17/2018', totalHours: 32, submissionStatus: 'Incomplete', approvalStatus: 'Not Approved', option: 'Edit', comment: '1 Floating Day Required' },
            { weekEnding: '3/10/2018', totalHours: 40, submissionStatus: 'Completed', approvalStatus: 'Approved', option: 'View', comment: '' },
         ],
         
         token: props.token,
         data: null,
         itemsToShow: 2,
         expanded: false,
      }
   }

   componentDidMount()
   {
      var payload={
         "token":this.state.token,
      }

      this.setState({data: axios.get('localhost:8000/project/timesheet/getShortTimesheet')
            .then(function (response) {
            console.log(response);
            if(response.data.code == 200){
            console.log("Getting data successfully");
            console.log(this.state.data);
            }
            else{
            console.log("Fail to get data");
            alert("Invalid Data from Backend");
            }
            })
            .catch(function (error) {
            console.log(error);
         })
      })
   }
    
   showMore = () => {
      this.state.itemsToShow === 2 ? (
        this.setState({ itemsToShow: this.state.summaryUnits.length, expanded: true })
      ) : (
        this.setState({ itemsToShow: 2, expanded: false })
      )
   }

   renderTableHeader() {
       let header = Object.keys(this.state.summaryUnits[0])
       return header.map((key, index) => {
          return <th key={index}>{key.toUpperCase()}</th>
       })
   }
 
    renderTableData = () => {
       return this.state.summaryUnits.slice(0, this.state.itemsToShow).map((summaryUnit, index) => {
          const { weekEnding, totalHours, submissionStatus, approvalStatus, option, comment } = summaryUnit //destructuring
          return (
             <tr>
                <td>{weekEnding}</td>
                <td>{totalHours}</td>
                <td>{submissionStatus}</td>
                <td>{approvalStatus}</td>
                <td>{option}</td>
                <td>{comment}</td>
             </tr>
          )
       })
    }
 
    render() {
       return (
         <div>
            <table id='students'>
               <tbody>
                   <tr>{this.renderTableHeader()}</tr>
                   {this.renderTableData()}
               </tbody>
            </table>
            <a className="btn btn-primary" onClick={this.showMore}>
               {this.state.expanded ? (
                  <span>Show less</span>
               ) : (
                  <span>Show more</span>
               )}
            </a>
         </div>
       )
    }
}

 export default Summary; 