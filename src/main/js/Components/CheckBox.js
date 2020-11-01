import React from 'react'

export const CheckBox = props => {
    return (
      <li>
       <input key={props.id} onChange={props.handleChange} onClick={props.handleCheckChildElement} type="checkbox" checked={props.isChecked} value={props.value} /> {props.value}
      </li>
    )
}