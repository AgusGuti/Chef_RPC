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
-Cambiar atributo de Receta/tiempoPreparacion de int a String para que pueda leer el nuevo select y guardar en la BDD
-Agregar atributo fotoPerfil a la clase User.
-Guardar las recetas de usuario en la vista abm-recetas.
-Corregir en la base el id_user (siempre carga el id 1 pese a tener otro perfil abierto)
-Validación (alta quizás con algún boolean) de seguidores y seguidos. Hacer <list> de seguidores y seguidos, y volcarlos a sus respectivas vistas.


## SERVIDOR JAVA GRPC

*IMPORTANTE* Agregar atributo "fotoPerfil" (nulleable porque no estaría en el formulario de registro, pero sí en el perfil principal) a user, nos re olvidamos. O no sé si es mucho quilombo una clase "Perfil" unida a "User" (relación un perfil por cada usuario) que tenga un nickname y una foto de perfil.

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

4. python main.py

## BD MYSQL

1. Crear base de datos chefencasa en mysql antes de ejecutar los servicios.

## EJECUCIÓN

1. Una vez corriendo ambos servicios se accede al front desde: http://localhost:5000
