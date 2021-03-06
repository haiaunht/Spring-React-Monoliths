import _ from "lodash"
import React, {useState} from "react"
import Error from "./Error"
import EditSuccessful from "./EditSuccessful";

const EditSurrenderForm = props => {
  const [submitSuccessful, setSubmitSuccessful] = useState(false)
  const [errors, setErrors] = useState([])

  const [newSurrender, setNewSurrender] = useState({
    name: props.surrender.name,
    phoneNumber: props.surrender.phoneNumber,
    email: props.surrender.email,
    petName: props.surrender.petName,
    petAge: props.surrender.petAge,
    petTypeId: props.surrender.petTypeId,
    petImageUrl: props.surrender.petImageUrl,
    vaccinationStatus: props.surrender.vaccinationStatus,
    applicationStatus: "pending"
  })

  const updateSurrenderForm = async () => {
    const id = props.surrender.id
    try {
      const response = await fetch(`/api/v1/surrender/update/${id}`, {
        method: "POST",
        headers: new Headers({
          "Content-Type": "application/json"
        }),
        body: JSON.stringify(newSurrender)
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
        const data = await response.json()
      }
    } catch (error) {
      console.error(`Error in fetch: ${error}`)
    }
  }

  const handleInput = event => {
    setNewSurrender({
      ...newSurrender,
      [event.currentTarget.name]: event.currentTarget.value
    })
  }

  const handleSubmit = event => {
    event.preventDefault()
    updateSurrenderForm()
    setSubmitSuccessful(true)
  }

  if (submitSuccessful) {
    return (
      <EditSuccessful />
    )
  }
  else {
    return (
      <div>
        <h2>Please edit you form: </h2>
        <div >
          <div className="edit-surrender-form">
            <form onSubmit={handleSubmit} className="edit-surrender-form">
              <div className="cell">
                <Error errors={errors}/>
              </div>

              <label htmlFor="name">
                Your Name:
                <input
                    id="name"
                    type="text"
                    name="name"
                    onChange={handleInput}
                    value={newSurrender.name}
                />
              </label>

              <label htmlFor="phoneNumber">
                Phone:
                <input
                    id="phoneNumber"
                    type="text"
                    name="phoneNumber"
                    onChange={handleInput}
                    value={newSurrender.phoneNumber}
                />
              </label>

              <label htmlFor="email">
                Email:
                <input
                    id="email"
                    type="email"
                    name="email"
                    onChange={handleInput}
                    value={newSurrender.email}
                />
              </label>

              <label htmlFor="petName">
                Pets Name:
                <input
                    id="petName"
                    type="text"
                    name="petName"
                    onChange={handleInput}
                    value={newSurrender.petName}
                />
              </label>

              <label htmlFor="petImageUrl">
                Picture of your pet:
                <input
                    id="petImageUrl"
                    type="url"
                    name="petImageUrl"
                    onChange={handleInput}
                    value={newSurrender.petImageUrl}
                />
              </label>

              <label htmlFor="petAge">
                Pets Age (in months):
                <input
                    id="petAge"
                    type="text"
                    name="petAge"
                    onChange={handleInput}
                    value={newSurrender.petAge}
                />
              </label>

              <label htmlFor="petTypeId">
                Pet Type:
                <select
                    id="petTypeId"
                    name="petTypeId"
                    value={newSurrender.petTypeId}
                    onChange={handleInput}
                >
                  <option value="">Please Select</option>
                  <option value="1">Puppies</option>
                  <option value="2">Kitties</option>
                </select>
              </label>

              <label htmlFor="vaccinationStatus">
                Vaccinated?
                <select
                    id="vaccinationStatus"
                    name="vaccinationStatus"
                    value={newSurrender.vaccinationStatus}
                    onChange={handleInput}
                >
                  <option value="">Please Select</option>
                  <option value="true">Yes</option>
                  <option value="false">No</option>
                </select>
              </label>

              <label htmlFor="applicationStatus">
                <input
                    id="applicationStatus"
                    type="text"
                    name="applicationStatus"
                    defaultValue="pending" hidden
                />
              </label>

              <input id="surrender-btn" type="submit" value="Submit"/>
            </form>
          </div>
        </div>
      </div>
    )
  }
}
export default EditSurrenderForm
