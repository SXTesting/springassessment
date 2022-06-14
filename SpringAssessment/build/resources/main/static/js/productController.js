const createHTMLList = (id, title, description, date) =>
`
<table class="table table-condensed" >
    <tr>
        <td>${title}</td>
        <td>${description}</td>
        <td>${date}</td>
    </tr>
</table>
`;

class ProductsController
{
    constructor()
    {
        this._items = [];       //create an array to store the details of product items
    }

    //method to add the items into the database
    addItem(title, description, date)
    {
        var productController = this;
        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('date', date);

       fetch('http://localhost:8080/item/add', {
             method: 'POST',
             body: formData
             })

             .catch((error) => {
                 console.error('Error:', error);
                 alert("Error adding item to TODO")
             });
    }

    //This method will do the fetch method to fetch data from database using
    //the REST API endpoint from Spring Boot
    displayItem()
    {
         let productController = this;
         productController._items = [];

         fetch('http://127.0.0.1:8080/item/all')        //12ms
            .then((resp) => resp.json())
            .then(function(data) {
                console.log("2. receive data")
                console.log(data);
                data.forEach(function (item, index) {

                    const itemObj = {
                        id: item.id,            //1
                        title: item.title,        //Cat Tee Black T-Shirt
                        description: item.description,  //4 MSL
                        date: item.date
                   };
                    productController._items.push(itemObj);
              });

              productController.renderProductPage();

            })
            .catch(function(error) {
                console.log(error);
            });

    }

    //Based on the item fetched from the displayItem() method and show the products in the
    //product page
    renderProductPage()
    {
        let productHTMLList = [];

        for (let i=0; i<this._items.length; i++)
        {
            const item = this._items[i];            //assign the individual item to the variable

            const productHTML = createHTMLList(i, item.title, item.description, item.date);

            productHTMLList.push(productHTML);
        }

        //Join all the elements/items in my productHTMLList array into one string, and seperate by a break
        const pHTML = productHTMLList.join('\n');
        document.querySelector('#list').innerHTML = pHTML;

    }


}   //End of ProductsController class

