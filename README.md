# jpapersistence
Persistencia con JPA implementado con NetBeans y Maven. El proyecto se conecta a una base de datos MS SQL Server local.

Pasos realizados
----------------------
1. Creación del proyecto
2. Creación de las clases Entidades
3. Creación de la base de datos "persistencia" en el MS SQL Server
4. En el proyecto: Nuevo -> Persistence Unit.
   
   4.1. Se agregó un nombre "unidad_persistencia"   
   4.2. Se seleccionó como Persistence Library "EclipseLink"  
   4.3. Se creó la cadena de conexión JDBC nueva para conectar al SQL Server. Para ello fue necesario agregar la dependencia del driver para SQL Server al archivo POM  
        En este caso fue (depende del motor de BD y de la versión):
   
         <dependency>
            <groupId>com.microsoft.sqlserver</groupId>
            <artifactId>mssql-jdbc</artifactId>
            <version>12.4.2.jre11</version>
        </dependency>
   
    4.4. Se seleccionó la opción "Drop and Create" en la opción Table Generation Strategy. Esto es útil mientras se desarrolla. Luego se debería poner en "None"  
    4.5. Se agregaron las clases Entidades en la opción "Include Entity Classes"   
6. En el proyecto: Nuevo -> JPA Controller Classes for Entity Classes. Esto fue para cada Clase Entidad y cumple la especificación del patrón DAO
7. Creación de una clase JPAUtil que tendrá una unica instancia de EntityManagerFactory, que será compartida por toda la aplicación. Cada vez que se instancia un JPA Controller se inicializa con el EntityManagerFactory.
8. En el método main se agregaron algunas lineas de creación y recuperación de objetos desde y hacia la BD.
