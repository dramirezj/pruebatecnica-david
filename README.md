Para ejecutar el códgo se debe ejecutar las siguientes instrucciones
1. mvn clean package -DskipTests, con esto empaquetamos la app
2. docker-compose build java_app, generamos la imagen docker con el contenedor
3. docker-compose up, subimos el contenedor

Métodos permitidos
GET
POST
PUT
DELETE

URL
1. http://localhost:8090/api/tickets/filter?pagenumber=0&pagesize=2, filtra los datos pasando como parametro un id en la sección headers
2. http://localhost:8090/api/tickets?pagenumber=0&pagesize=2, trae todos los tickets por paginados
3. http://localhost:8090/api/tickets/save, crea un nuevo ticket
4. http://localhost:8080/api/tickets/update, actualiza un tickect enviando el id