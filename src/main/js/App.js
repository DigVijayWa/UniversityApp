import React, { Component, useState, useEffect } from "react";
import { Router, Route, Link, IndexRoute } from "react-router";
import ReactDOM from "react-dom";
import { BrowserRouter } from "react-router-dom";
import { CheckBox } from "./Components/CheckBox";
import GetRequest from "./Utility/GetRequest";
import "./css/App.css";

function App() {
  const [filters, setFilters] = useState([]);
  const [listCourses, setListCourses] = useState([]);
  const [countryCheckBoxes, setCountryCheckBoxes] = useState([ {id: 1, value: "India", isChecked: false},
  {id: 2, value: "US", isChecked: false},
  {id: 3, value: "UK", isChecked: false},
  {id: 4, value: "Chine", isChecked: false},
  {id: 5, value: "Australia", isChecked: false},
  {id: 6, value: "Canada", isChecked: false}]);
  const [courseCheckBoxes, setCourseCheckBoxes] = useState([{id: 7, value: "Engineering", isChecked: false},
  {id: 8, value: "Medical", isChecked: false},
  {id: 9, value: "Ms", isChecked: false},
  {id: 10, value: "Philosophy", isChecked: false}]);
  const [feesCheckBox, setFeesCheckBox] = useState([ {id: 11, value: 10000, isChecked: false},
     {id: 12, value: 20000, isChecked: false},
     {id: 13, value: 30000, isChecked: false},
     {id: 14, value: 40000, isChecked: false},
     {id: 15, value: 50000, isChecked: false}]);
  const [streamCheckBox, setStreamCheckBox] = useState([{id: 16, value: "Science", isChecked: false},
  {id: 17, value: "Maths", isChecked: false},
  {id: 18, value: "Commerce", isChecked: false},
  {id: 19, value: "Arts", isChecked: false}]);
  
  useEffect(() => {
     // Update the document title using the browser API
     GetRequest("/courses").then((resp) => {
          console.log(resp.data);
          setListCourses(resp.data);
     });
   });
  function handleCheckChildElement(checkBoxName, value) {
    return (event) => {
      console.log({ event, checkBoxName, value });
      setFilters((prevState) => {
        prevState.push({ checkBoxName, value });
        return prevState;
      });
     if(checkBoxName == "country") {
          let countries = countryCheckBoxes;
          countries.forEach(item => {
               if(item.value == event.target.value){
                    console.log("here");
                    item.isChecked = event.target.checked;
               }
          });
          setCountryCheckBoxes(countries);
     }
      console.log(filters);
    };
  }

  return (
    <div className="app">
     <div className="app-header">
          <img src="https://i.ibb.co/rv13sbV/graphic-careers.png"></img>
          <h1>Career Counselor</h1>
     </div>
     <div className="app-container">
          <div className="filters">
          <div className="selectedFilters">
               <h2>Selected Filters:</h2>
               {
                    filters.map((item) => {
                         return(<div className="appliedFilters">
                              <h4>{item.value}</h4>
                         </div>);
                    })
               }
          </div>
          <div className="filter country">
               <h3>Country</h3>
               <ul>
               {countryCheckBoxes.map((item) => {
               return (
                    <CheckBox
                    handleCheckChildElement={handleCheckChildElement(
                         "country",
                         item.value
                    )}
                    value={item.value}
                    />
               );
               })}
               </ul>
          </div>
          <div className="filter course">
               <h3>Course</h3>
               <ul>
               {courseCheckBoxes.map((item) => {
               return (
                    <CheckBox
                    handleCheckChildElement={handleCheckChildElement(
                         "course",
                         item.value
                    )}
                    value={item.value}
                    />
               );
               })}
               </ul>
          </div>
          <div className="filter fees">
               <h3>Fees</h3>
               <ul>
               {feesCheckBox.map((item) => {
               return (
                    <CheckBox
                    handleCheckChildElement={handleCheckChildElement(
                         "fees",
                         item.value
                    )}
                    value={"<"+item.value}
                    />
               );
               })}
               </ul>
          </div>
          <div className="filter stream">
               <h3>Stream</h3>
               <ul>
               {streamCheckBox.map((item) => {
               return (
                    <CheckBox
                    handleCheckChildElement={handleCheckChildElement(
                         "stream",
                         item.value
                    )}
                    value={item.value}
                    />
               );
               })}
               </ul>
          </div>
          </div>
          <div className="container">
          {listCourses.map((item) => {
               return (
               <div className="courseCard">
               <div className="logo">
                    <img src={item.universityLogo} />
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
                    {
                         Object.keys(item.exams).map((it)=> {
                                   return( <tr>
                                        <td>{it}</td>
                                   <td>{item.exams[it]}</td>
                                   </tr>);
                         })
                    }
                    </table>
                    <a href={item.universityLink}> here </a>
               </div>
               </div>
               );
          })}
          </div>
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

ReactDOM.render(<App />, document.getElementById("react"));
