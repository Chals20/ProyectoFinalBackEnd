# ProyectoFinalBackEnd



Category rutas;

GET http://localhost:8181/categories/findAll
GET http://localhost:8181/categories/findById/{id}
POST http://localhost:8181/categories/save ->body
PUT  http://localhost:8181/categories/update/{id} ->body
DELETE http://localhost:8181/categories/delete/{id}


Dish rutas;

GET http://localhost:8181/dishes/findAll
GET http://localhost:8181/dishes/findById/{id}
POST http://localhost:8181/dishes/save ->body
PUT  http://localhost:8181/dishes/update/{id} ->body
DELETE http://localhost:8181/dishes/delete/{id}


Order rutas;

GET http://localhost:8181/orders/findAll
GET http://localhost:8181/orders/findById/{id}
POST http://localhost:8181/orders/save ->body
PUT  http://localhost:8181/orders/update/{id} ->body
DELETE http://localhost:8181/orders/delete/{id}

Dishorders rutas;

GET http://localhost:8181/dishorders/findAll
GET http://localhost:8181/dishorders/findById/{id}
POST http://localhost:8181/dishorders/save ->body
PUT  http://localhost:8181/dishorders/update/{id} ->body
DELETE http://localhost:8181/dishorders/delete/{id}

User rutas;

GET http://localhost:8181/user/findAll
GET http://localhost:8181/user/findById/{id}
POST http://localhost:8181/user/save ->body
PUT  http://localhost:8181/user/update/{id} ->body
DELETE http://localhost:8181/user/delete/{id}
GET http://localhost:8181/user/findByUsername/{username}
