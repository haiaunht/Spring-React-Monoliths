## Getting Started

```no-highlight
et get java-react-objects-in-space
cd java-react-objects-in-space
createdb java_react_objects_in_space_development
idea .
```

## Masters of the Universe

“If you wish to make an apple pie from scratch, you must first invent the universe.” - Carl Sagan

Thankfully we don't need to invent the universe. But we do have a lot of stuff floating around out there that needs to be categorized. That where you come in. You've been tasked by NASA to create a form for users to submit newly categorized interstellar objects.
NASA wants to ensure you capture the object's:

* name
* ngc designation (new general catalog i.e NGC 4121)
* the year it was discovered

## Meeting Expectations Requirements
The necessary model, repository, and migration have been provided for you. Additionally App.js should render a header after you spring-boot:run and navigate to localhost:8080.

* Create a Rest Controller with the following
  * an endpoint the returns a list of the space objects
  * an endpoint for creation of new space objects
* Create the following in React (it should all display on the same page)
  * a list of all existing space objects
    * the list should display all information related to the object
  * a form for creating new space objects
    * the form must use controlled components
    * upon successful submission the form must persist the data in the database
    * upon successful submission the page should be re-rendered with the updated list of space objects

## Exceeding Expectations Requirements

* Create an endpoint in your Rest Controller to delete Space Objects
* Render a button to delete each object along with it's information
  * Using the button should re-render the page without the relevant object
* Create a function to clear your form
  * ensure your form clears on submission
* Add React Form Validation to ensure all database constraints are also present on the form
