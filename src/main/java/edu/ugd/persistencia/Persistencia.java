/*
 * Código ejemplo simple de cómo utilizar JPA para interactuar con una base de datos. 
 * Se crea un cliente y una venta, se establece una relación entre ellos y se recuperan 
 * los clientes para su visualización. Este código es un punto de partida para una aplicación 
 * que gestiona la persistencia de datos en una base de datos utilizando JPA.
 */

package edu.ugd.persistencia;

import edu.ugd.persistencia.controlador.*;
import edu.ugd.persistencia.controlador.JpaUtil;
import edu.ugd.persistencia.modelo.*;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author faguirre
 */
public class Persistencia {

    public static void main(String[] args) {
        try {
            //Se crean dos controladores JPA, ClienteJpaController y VentaJpaController, que se utilizan para interactuar con la base de datos.
            ClienteJpaController ClienteDao = new ClienteJpaController(JpaUtil.getEntityManager());
            VentaJpaController VentaDao = new VentaJpaController(JpaUtil.getEntityManager());
            
            // Se crea una instancia de un cliente llamado unCliente con nombre "Fernando" y apellido "Aguirre". 
            // Luego, se utiliza el controlador ClienteDao para persistir este cliente en la base de datos.
            Cliente unCliente = new Cliente();
            unCliente.setNombre("Fernando");
            unCliente.setApellido("Aguirre");
            ClienteDao.create(unCliente);
            
            // Se crea una instancia de una venta llamada nVenta con una fecha, una descripción y un monto. 
            // Luego, se utiliza el controlador VentaDao para persistir esta venta en la base de datos.
            Venta nVenta = new Venta();
            nVenta.setFecha(new Date());
            nVenta.setDescripcion("Primera venta");
            nVenta.setMonto(3440.00);
            VentaDao.create(nVenta);
            
            //Se establece una relación entre el cliente unCliente y la venta nVenta al agregar la venta al cliente 
            //y luego se actualiza el cliente en la base de datos.
            unCliente.addVenta(nVenta);
            ClienteDao.edit(unCliente);
            
            
            //Se recupera una lista de clientes de la base de datos utilizando el controlador ClienteDao 
            //y se itera a través de la lista para imprimir los nombres y apellidos de los clientes en la consola.
            List<Cliente> clientes = ClienteDao.findClienteEntities();
            for (Cliente c:clientes){
                System.out.println(c.getNombre() + " " + c.getApellido());
            }
        } catch (Exception ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
