CS590DE Lab 5 - Part 2
Product and Shopping components as REST services, with a REST client
David Kasozi Saaka

PROJECTS
--------
  product-service    the Product component   - REST + MongoDB, port 8081
  shopping-service   the Shopping component  - REST + MongoDB, port 8082
  rest-client        console application that exercises both

Each service has its own Mongo database, because in the Part 1 component
design every component owns its own data:

  product-service   ->  lab5_productdb  >  product
  shopping-service  ->  lab5_shoppingdb >  shoppingcart

REST INTERFACES
---------------
Product component (IProductCatalog)
  POST /api/products                    addProduct
  GET  /api/products/{productNumber}    getProduct

Shopping component (IShoppingCart)
  POST /api/carts/{customerNumber}/items   addToShoppingCart
  GET  /api/carts/{customerNumber}         getShoppingCart

HOW TO RUN
----------
1. Make sure MongoDB is running on localhost:27017.

2. Start the product service and leave it running:
     cd product-service
     mvn spring-boot:run

3. Start the shopping service in a second window and leave it running:
     cd shopping-service
     mvn spring-boot:run

4. Run the client in a third window:
     cd rest-client
     mvn spring-boot:run

   It adds a product, reads it back, adds it to the cart and prints the cart.

5. Check the data in MongoDB Compass:
     lab5_productdb  > product
     lab5_shoppingdb > shoppingcart

NOTE ON COMPONENT DEPENDENCIES
------------------------------
In Part 1 the Shopping component requires IProductCatalog. Because the two
components are deployed separately here, the shopping service satisfies that
dependency over HTTP through ProductCatalogClient. The shopping service never
reads the product database directly - each component owns its own data.
