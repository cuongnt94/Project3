import React, { Component } from 'react';
import Table from 'react-bootstrap/Table';
import './Summary.css';
class Summary extends Component {
    constructor(props) {
       super(props)
       this.state = {
          summaryUnits: [
             { weekEnding: '3/24/2018', totalHours: 40, submissionStatus: 'Not Started', approvalStatus: 'N/A', option: 'Edit', comment: '' },
             { weekEnding: '3/17/2018', totalHours: 32, submissionStatus: 'Incomplete', approvalStatus: 'Not Approved', option: 'Edit', comment: '1 Floating Day Required' },
             { weekEnding: '3/10/2018', totalHours: 40, submissionStatus: 'Completed', approvalStatus: 'Approved', option: 'View', comment: '' },
          ]
       }
    }
 
    renderTableHeader() {
       let header = Object.keys(this.state.summaryUnits[0])
       return header.map((key, index) => {
          return <th key={index}>{key.toUpperCase()}</th>
       })
    }
 
    renderTableData() {
       return this.state.summaryUnits.map((summaryUnit, index) => {
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
          </div>
       )
    }
}

 export default Summary; 