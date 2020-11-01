import React,{ Component, useState } from 'react';
import {Router, Route, Link, IndexRoute} from 'react-router';
import ReactDOM from 'react-dom';
import { BrowserRouter } from 'react-router-dom'
import { CheckBox } from './Components/CheckBox';
import GetRequest from './Utility/GetRequest'
import './css/App.css';

function App() {

     const [filters, setFilters] = useState([]);
     const [listCourses, setListCourses] = useState([]);

     const countryCheckBoxes = ["India", "US", "UK", "China", "Australia", "Canada"];
     const courseCheckBoxes = ["Engineering", "Medical", "Ms", "Philosophy"];
     const feesCheckBox = [10000,20000,30000,40000,50000];
     const streamCheckBox = ["Science", "Maths", "Commerce", "Arts"];

     function handleCheckChildElement(checkBoxName, value) {
          return(event) => {
               console.log({event, checkBoxName, value});
               setFilters(prevState => {
                    prevState.push({checkBoxName, value});
                    return prevState;
               });
               GetRequest("/courses").then(resp=>{
                    console.log(resp.data);
                    setListCourses(resp.data);
               });
               console.log(filters);
          }
     }

         return (
         <div className="app-container">
              <div className="filters">
                    <div className="selectedFilters">
                    </div>
                    <div className="filter country">
                         <ul>
                         {
                              countryCheckBoxes.map((item) => {
                                   return (<CheckBox handleCheckChildElement={handleCheckChildElement("country", item)} value={item} checked={false}/>)
                              })
                         }
                         </ul>
                    </div>
                    <div className="filter course">
                         <ul>
                         {
                              courseCheckBoxes.map((item) => {
                                   return (<CheckBox handleCheckChildElement={handleCheckChildElement("course", item)} value={item} checked={false}/>)
                              })
                         }
                         </ul>
                    </div>
                    <div className="filter fees">
                    <ul>
                         {
                              feesCheckBox.map((item) => {
                                   return (<CheckBox handleCheckChildElement={handleCheckChildElement("fees", item)} value={item} checked={false}/>)
                              })
                         }
                         </ul>
                    </div>
                    <div className="filter stream">
                    <ul>
                         {
                              streamCheckBox.map((item) => {
                                   return (<CheckBox handleCheckChildElement={handleCheckChildElement("stream", item)} value={item} checked={false}/>)
                              })
                         }
                         </ul>
                    </div>     
              </div>
              <div className="container">
                    {
                         listCourses.map((item)=> {
                             return(<div className="courseCard">
                                   <div className="logo">
                                        <img src={item.universityLogo}/>
                                   </div>
                                   <div className="details">
                                             <h3>{item.universityName} </h3>
                                             <h2>Course: {item.courseName}</h2>
                                             <h2>Fees: {item.fees}</h2>
                                             <table>
                                                  <tr> 
                                                  <th> Exams </th> 
                                                  <th> Cutoff </th>
                                                  </tr>
                                                  <tr>
                                                       <td> SAT </td>
                                                       <td> 5.6 </td>
                                                  </tr>
                                                  <tr>
                                                       <td> SAT </td>
                                                       <td> 5.6 </td>
                                                  </tr>
                                                  <tr>
                                                       <td> SAT </td>
                                                       <td> 5.6 </td>
                                                  </tr>
                                             </table>
                                             <a href={item.universityLink}> here </a>
                                   </div>
                              </div>); 
                         })
                    }
              </div>
         </div>
           /*<BrowserRouter>
                <div>
                     <Route exact path='/' component={Login} />
                     <Route exact path='/pool-project' component={HomePage} />
                     <Route exact path='/pool-project/book-specific-table' component={BookSpecificTable} />
                </div>
           </BrowserRouter>*/
         );
}
export default App;



ReactDOM.render(
	<App />,
	document.getElementById('react')
)
