# Chef_RPC

Clases creadas en capa servidor:

.Categoría
.Receta
.User
.Seguidores
.Seguidos
.Favoritos
.Ingredientes
.Subcategoria

## Restante

-Solucionar la carga del objeto categoría dentro de la clase receta.

-No levantó correctmente los seguidos de los INSERT (F. de Obs: 15/09/2023)
-Falta poder cargar foto de perfil al registrarse y mostrarla en Mi Perfil (F. de Obs: 15/09/2023)
-Falta implementar poder dejar de seguir, evitar que me sigan (F. de Obs: 17/09/2023)
-ERROR al mostrar Mis Recetas me mostró las recetas de otro usuario (F. de Obs: 15/09/2023)

-Falta poder marcar publicacion como favorito al verla en STORYLINE (F. de Obs: 15/09/2023)


## SERVIDOR JAVA GRPC

### Version JAVA:

- JDK 17

### Comandos terminal:

1. cd app-java
2. mvn clean install -DskipTests
3. mvn spring-boot:run
   
4. Correr Inserts_alt.sql (para tener para test) (OPCIONAL)

## CLIENTE/SERVIDOR PYTHON 

### Version Python:  

- Python 3.9.13

### Comandos terminal:

1. cd app-python
2. pip install -r requirements.txt
3. Si se modifica del lado del server de las clases ejecutar nuevamente:
   
   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/user.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/receta.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/categoria.proto

   python -m grpc_tools.protoc -I../app-java/src/main/proto --python_out=. --pyi_out=. --grpc_python_out=. ../app-java/src/main/proto/ingrediente.proto


4. python main.py

## BD MYSQL

1. Crear base de datos chefencasa en mysql antes de ejecutar los servicios.

## EJECUCIÓN

1. Una vez corriendo ambos servicios se accede al front desde: http://localhost:5000
