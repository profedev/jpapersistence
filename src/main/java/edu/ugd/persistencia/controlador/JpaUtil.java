/**
 * Clase que se utiliza para configurar y proporcionar una instancia de EntityManagerFactory en una aplicación que utiliza JPA (Java Persistence API).
 * El propósito de esta clase es proporcionar un acceso centralizado a la instancia de EntityManagerFactory para que pueda ser utilizada en toda la aplicación. 
 * Esto ayuda a mantener una sola instancia de EntityManagerFactory en lugar de crear una nueva cada vez que se necesite interactuar con la base de datos, lo que es más eficiente y evita problemas de concurrencia.
 */
package edu.ugd.persistencia.controlador;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


/**
 *
 * @author faguirre
 */
public class JpaUtil {
    /*  
    Se inicializa una instancia de EntityManagerFactory en su inicialización estática. 
    Esta instancia se crea utilizando el método Persistence.createEntityManagerFactory("unidad_persistencia"). 
    El argumento "unidad_persistencia" se utiliza para especificar la unidad de persistencia que se ha configurado 
    en el archivo de configuración de JPA. Esta unidad de persistencia define la configuración de la base de datos, 
    como la URL de conexión, el nombre de usuario, la contraseña, etc.
    */
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad_persistencia");;
    public static EntityManagerFactory getEntityManager(){
        return emf;
    }   
    
}
