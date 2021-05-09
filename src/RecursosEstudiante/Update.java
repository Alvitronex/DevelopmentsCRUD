/*
EJERCICIO DE APLICACIÓN
Crear el CRUD para almacenar registros en la siguiente tabla.

ESTUDIANTE
**************************************
Campos Tipo de Datos Otros
*************************************
id_estudiante int - Llave primaria, autoincrementable desde 1001
carnet_estudiante varchar(6) - Ejemplo MP1234
nom_estudiante varchar(30)
ape_estudiante varchar(30)
edad_estudiante Int(3)

*/
package RecursosEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    
    Update() throws SQLException{
        Scanner leer = new Scanner(System.in);
        Estudiante est = new Estudiante();
        ConexionCRUD utilirias = new ConexionCRUD();
        System.out.println("\n<< ACTUALIZAR REGISTROS >>");
        
        System.out.println("Ingresar id del a modificar: ");
        est.setIdEstudiante(leer.nextInt());
        
        //ingreso de datos a actualizar 
        String tablaBuscar = "tb_estudiante";
        String camposBuscar = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String condicion = "id_estudiante = " + est.getIdEstudiante();
        utilirias.desplegarRegistros(tablaBuscar, camposBuscar, condicion);
        
        System.out.println("Carnet: ");
        est.setCarnetEstudiante(leer.next());
        
        System.out.println("Nombre: ");
        est.setNomEstudiante(leer.next());
        
        System.out.println("Apellido: ");
        est.setApeEstudiante(leer.next());
        
        System.out.println("Edad: ");
        est.setEdadEstudiante(leer.nextInt());
        
        String tabla ="tb_estudiante";
        String camposValoresNuevos = "carnet_estudiante = '" + est.getCarnetEstudiante() + "', nom_estudiante = '" + est.getNomEstudiante() + 
                                     "', ape_estudiante = '" + est.getApeEstudiante() + "', edad_estudiante = '"+ est.getEdadEstudiante() + "'";
        
        utilirias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicion);
        System.out.println("Modificado correctamente");
        MenuPrincipal.desplegarMenu();
    }
}
