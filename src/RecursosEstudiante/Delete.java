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

public class Delete {//clase para eliminar registros
     Delete() throws SQLException {
        Scanner sc = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<< ELIMINAR REGISTROS >> ");
        
        System.out.println("Ingresar el id del registro: ");
        String idContactoEliminar = sc.next();
        
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicion = "id_estudiante = " + idContactoEliminar;
        utilerias.desplegarRegistros(tabla, campos, condicion);
        
        System.out.println("Presionar << Y >> para confirmar: ");
        String confirmarBorrar = sc.next();
        
        if("Y".equals(confirmarBorrar)) {
            String valoresCamposNuevos = "";
            
            utilerias.actualizarEliminarRegistro(tabla, valoresCamposNuevos, condicion);
            System.out.println("Registro borrado satisfactoriamente!!!");
        } 
        MenuPrincipal.desplegarMenu();
    }
}


