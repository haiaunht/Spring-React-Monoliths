import React, {useState} from "react";
import _ from "lodash"
import Error from "./Error"
import {Redirect} from "react-router-dom";

const SpaceObjectForm = props => {
  const [errors, setErrors] = useState([])
  const [submitSuccessful, setSubmitSuccessful] = useState(null)
  const [redirect, setRedirect] = useState(false)

  const [spaceObject, setSpaceObject] = useState({
    name:"",
    ngc:"",
    yearDiscovered:""
  })

  const addNewApplication = async () => {
    try {
      const response = await fetch("/api/v1/spaces", {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(spaceObject)
      })
      if (!response.ok) {
        if (response.status === 422) {
          const data = await response.json()
          return setErrors(data.errors)
        } else {
          const errorMessage = `${response.status} (${response.statusText})`
          const error = new Error(errorMessage)
          throw error
        }
      }
      const body = await response.json()
      if (body) {
        setRedirect(true)
        setSpaceObject(body.spaceObject)
        setSubmitSuccessful(true)
      }
    } catch (error) {
      console.error(`Error in Fetch: ${error.message}`)
      setSubmitSuccessful(false)
    }
  }

  const handleInputChange = e => {
    e.preventDefault()
    setSpaceObject({
      ...spaceObject,
      [e.currentTarget.name]: e.currentTarget.value
    })
  }

  const clearForm = event => {
    event.preventDefault()
    setSpaceObject({
      name: "",
      ngc: "",
      yearDiscovered: ""
    })
  }

  const validForSubmission = () => {
    let submitErrors = {}
    const requiredFields = ["name", "ngc", "yearDiscovered"]
    requiredFields.forEach(field => {
      if (spaceObject[field].trim() === "") {
        submitErrors = {...submitErrors, [field]:"is blank"}
      }
    })
    setErrors(submitErrors)
    return _.isEmpty(submitErrors)
  }

  const handleSubmit = event => {
    event.preventDefault()
    if (validForSubmission()) {
      addNewApplication()
    }
    setSpaceObject({
      name: "",
      ngc: "",
      yearDiscovered: ""
    })
  }

  if (redirect) {
    return <Redirect to="/spaces" />
  }


  return (
      <div>
        <h2>Add a New Space object Form </h2>
        <form onSubmit={handleSubmit}>
          <Error errors={errors} />
          <label htmlFor="name">Object's Name
            <input type="text" id="name" name="name" onChange={handleInputChange} value={spaceObject.name}/>
          </label>

          <label htmlFor="ngc">NGC
            <input type="text" id="ngc" name="ngc" onChange={handleInputChange} value={spaceObject.ngc}/>
          </label>

          <label htmlFor="yearDiscovered">Year's discovered
            <input type="text" id="yearDiscovered" name="yearDiscovered" onChange={handleInputChange} value={spaceObject.yearDiscovered}/>
          </label>

          <div className="button-group">
            <button className="button" onClick={clearForm}>Clear Form</button>
            <input className="button" type="submit" value="Add" />
          </div>

        </form>
      </div>
  )
}

export default SpaceObjectForm