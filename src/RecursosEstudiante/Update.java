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
    
    Update() throws SQLException {
        Scanner sc = new Scanner(System.in);
        Estudiante person = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ACTUALIZA REGISTROS >>");

        System.out.println("Ingresar id del registro a modificar: ");
        person.setIdEstudiante(sc.nextInt());

        String tablaBuscar = "tb_estudiante";
        String camposBuscar = "id_estudiante, nom_estudiante, ape_estudiante, carnet_estudiante, edad_estudiante";
        String condicionBuscar = "id_estudiante = " + person.getIdEstudiante();
        utilerias.desplegarRegistros(tablaBuscar, camposBuscar, condicionBuscar);

        System.out.println("Nombre: ");
        person.setNomEstudiante(sc.next());

        System.out.println("Apellidos: ");
        person.setApeEstudiante(sc.next());

        System.out.println("Carnet: ");
        person.setCarnetEstudiante(sc.next());
        
        System.out.println("Edad: ");
        person.setEdadEstudiante(sc.nextInt());

        String tabla = "tb_estudiante";
        String camposValoresNuevos = "nom_estudiante = '" + person.getNomEstudiante() + "', ape_estudiante = '" + person.getApeEstudiante() + "', carnet_estudiante = '" + person.getCarnetEstudiante() + "', edad_estudiante = " + person.getEdadEstudiante();

        utilerias.actualizarEliminarRegistro(tabla, camposValoresNuevos, condicionBuscar);
        System.out.println("Modificado correctamente!");

        MenuPrincipal.desplegarMenu();

    }
}