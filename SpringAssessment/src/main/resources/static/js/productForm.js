const productsControl = new ProductsController();

//When user clicks on 'Save Item', calls API to add items to the database
//Add an 'onsubmit' event listener for productform to add a product
newItemForm.addEventListener('submit', (event) => {
    // Prevent default action, do not need the form to submit first (1) Form Validation
    //(2) We are using our own fetch method to send the data over to the backend (Rest API)
    event.preventDefault();
    // Select the inputs
    const newItemTitleInput = document.querySelector('#newItemTitleInput');
    const newItemDescription = document.querySelector('#newItemDescription');
    const newItemDate = document.querySelector('#newItemDate');

    /*
        Do the Validation code here
    */

    // Get the values of the inputs - variable names to be same as MySQL columns
    const title = newItemTitleInput.value;
    const description = newItemDescription.value;
    const date = newItemDate.value;

    // Clear the form
    newItemTitleInput.value = '';
    newItemDescription.value = '';
    newItemDate.value = '';

    // Add the task to the task manager
    //After we get all the values and object from the form, we will call the addItem method in the ProductsController class to perform the POST HTTP Request by calling the Rest API provided by the backend
    productsControl.addItem(title, description, date);

});