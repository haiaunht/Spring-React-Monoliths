import React, { useState, useEffect } from "react"
import SpaceObjectTile from "./SpaceObjectTile";
import SpaceObjectForm from "./SpaceObjectForm";

const SpaceObjectIndexPage = props => {
  const [spaces, setSpaces] = useState([])

  const fetchSpaces = async () => {
    try {
      const response = await fetch('/api/v1/spaces')
      if (!response.ok) {
        const errorMessage = `${response.status} (${response.statusText})`
        const error = new Error(errorMessage)
        throw error
      }
      const body = await response.json()
      console.log(body.content)
      setSpaces(body.content)
    } catch (err) {
      console.log(`Error in fetch space objects: ${err.message}`)
    }
  }

  useEffect(() => {
    fetchSpaces()
  }, [])

  const allSpaces = spaces.map(space => {
    return (
      <SpaceObjectTile
          key={space.id}
          id={space.id}
          name={space.name}
          ngc={space.ngc}
          yearDiscovered={space.yearDiscovered}
      />
    )
  })

  return (
      <>
        <h1>Welcome to NASA</h1>
        <div >
        {allSpaces}
        </div>
        <SpaceObjectForm/>
      </>
  )
}

export default SpaceObjectIndexPage